package msgroup.gleaningplanner.service;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.DocumentationTool.Location;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Produce;
import msgroup.gleaningplanner.model.Producer;
import msgroup.gleaningplanner.model.Volunteer;
import msgroup.gleaningplanner.model.VolunteerRegistration;
import msgroup.gleaningplanner.model.Produce.CropType;
import msgroup.gleaningplanner.repository.EventRepository;
import msgroup.gleaningplanner.repository.FarmRepository;
import msgroup.gleaningplanner.repository.ProduceRepository;
import msgroup.gleaningplanner.repository.ProducerRepository;
import msgroup.gleaningplanner.repository.VolunteerRegistrationRepository;

import msgroup.gleaningplanner.model.AuthorType;
import msgroup.gleaningplanner.model.Comment;
import msgroup.gleaningplanner.repository.CommentRepository;

@Service
public class ProducerService {
    
    private ProducerRepository producerRepository;    
    private LocationService locationService;
    private VolunteerRegistrationRepository volunteerRegistrationRepository;
    private EventRepository eventRepository;
    private ProduceRepository produceRepository;
    private CommentRepository commentRepository;
    private FarmRepository farmRepository;

    public ProducerService(
        ProducerRepository producerRepository, 
        LocationService locationService,
        VolunteerRegistrationRepository volunteerRegistrationRepository,
        EventRepository eventRepository,
        ProduceRepository produceRepository,
        CommentRepository commentRepository,
        FarmRepository farmRepository
    ) {
        this.locationService = locationService;
        this.producerRepository = producerRepository;
        this.volunteerRegistrationRepository = volunteerRegistrationRepository;
        this.eventRepository = eventRepository;
        this.produceRepository = produceRepository;
        this.commentRepository = commentRepository;
        this.farmRepository = farmRepository;
    }

    public Producer createProducer(
        String firstName,
        String lastName,
        String email,
        String username,
        String password,
        String phoneNumber,
        String address,
        String postalCode,
        String city
    ){

        Producer newProducer = new Producer();
        newProducer.setEmail(email);
        newProducer.setFirstName(firstName);
        newProducer.setLastName(lastName);
        newProducer.setPassword(password);
        newProducer.setPhoneNumber(phoneNumber);

        LocationAPITO location =
                locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();

        newProducer.setUsername(username);
        newProducer.setLatitude(location.data.get(0).latitude);
        newProducer.setLongitude(location.data.get(0).longitude);
        newProducer.setAddress(address);
        newProducer.setCity(city);
        newProducer.setPostalCode(postalCode);

        return producerRepository.save(newProducer);
    }

    public Producer updateProducer(
        Integer id,
        String firstName,
        String lastName,
        String email,
        String username,
        String password,
        String phoneNumber,
        String address,
        String postalCode,
        String city)
    {
        Producer newProducer = producerRepository.findProducerByID(id);

        if (firstName != null){
            newProducer.setFirstName(firstName);
        }
        if (lastName != null) {
            newProducer.setLastName(lastName);
        }
        if (email != null){
            newProducer.setEmail(email);
        }
        if (username != null) {
            newProducer.setUsername(username);
        }
        if (password != null) {
            newProducer.setPassword(password);
        }
        if (phoneNumber != null) {
            newProducer.setPhoneNumber(phoneNumber);
        }
        if (address != null && postalCode != null && city != null){
            newProducer.setAddress(address);
            newProducer.setPostalCode(postalCode);
            newProducer.setCity(city);

            LocationAPITO locationAPITO = locationService.transformToLatitudeLongitude(newProducer.getAddress(), newProducer.getPostalCode(), newProducer.getCity()).getBody();
            newProducer.setLatitude(locationAPITO.data.get(0).latitude);
            newProducer.setLongitude(locationAPITO.data.get(0).longitude);
        }

        return producerRepository.save(newProducer);
    }

    public Set<Producer> filterProducers(
        Integer id,
        String firstName,
        String lastName,
        String email,
        String username,
        String password,
        String phoneNumber,
        String address,
        String postalCode,
        String city
    ) {
        
        Set<Producer> filtered = new HashSet<Producer>();

        if (id != null && id > 0) {
            filtered.add(producerRepository.findProducerByID(id));
            return filtered;
        }

        if (username != null) {
            filtered.add(producerRepository.findProducerByUsername(username));
            return filtered;
        }

        String longitude = null;
        String latitude = null;
        if (address != null && postalCode != null && city != null) {
            LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();
            latitude = Double.toString(location.data.get(0).latitude);
            longitude = Double.toString(location.data.get(0).longitude);
        }

        List<String> incoming = Arrays.asList(firstName, lastName, email, phoneNumber, address, address, postalCode, city, latitude, longitude);
        List<String> producerInfo;

        for (Producer producer: producerRepository.findAll()) {
            producerInfo = Arrays.asList(producer.getFirstName(), producer.getLastName(), producer.getEmail(), producer.getPhoneNumber(), producer.getAddress(), producer.getPostalCode(), producer.getCity(), latitude, longitude);
            boolean valid = true;
            for (int index = 0; index < incoming.size(); index++) {

                if (incoming.get(index) != null &&
                !incoming.get(index).equals(producerInfo.get(index))) valid = false;
            }

            if (valid) filtered.add(producer);
        }
   
        return filtered;
    }

    public List<Volunteer> acceptVolunteerGroup(int eventID, int volunteerGroup) {

        List<VolunteerRegistration> registrations = volunteerRegistrationRepository.findAllVolunteerRegistrationByVolunteerGroupNumber(volunteerGroup);

        List<Volunteer> accepted = new ArrayList<Volunteer>();
        for (VolunteerRegistration reg : registrations) {
            if (reg.getEvent().getID() == eventID && reg.isVolunteerGroupAccepted()) {
                Volunteer vol = reg.getVolunteer();
                reg.setEventAccepted(true);
                volunteerRegistrationRepository.save(reg);
                vol.setParticipatedEvent(
                    vol.getParticipatedEvent() + 1
                );
                accepted.add(reg.getVolunteer());
            }
        }
        return accepted;
    }

    public Produce addProduceToEvent(
        int eventID, 
        String produceType, 
        double amount
    ) {
        Produce produce = new Produce();
        produce.setEvent(eventRepository.findEventByID(eventID));

        CropType type = CropType.Apples;
        for (CropType crop : CropType.values()) {
            if (crop.toString().equals(produceType)) {
                type = crop;
                break;
            }
        }
        produce.setCropType(type);
        produce.setAmount(amount);
        return produceRepository.save(produce);
    }

    public Comment postCommentEvent(int producerID, int eventID, String comment, String authorType){
        
        AuthorType type;
        if (authorType.equals("PRODUCER")) type = AuthorType.PRODUCER;
        else if (authorType.equals("VOLUNTEER")) type = AuthorType.VOLUNTEER;
        else if (authorType.equals("GLEANERGROUP")) type = AuthorType.GLEANERGROUP;
        else type = AuthorType.ORGANIZATION;

        Comment newComment = new Comment();
        newComment.setAuthorType(type);
        newComment.setComment(comment);

        newComment.setDate(Date.from(Instant.now()));
        
        newComment.setEvent(eventRepository.findEventByID(eventID));
        newComment.setProducer(producerRepository.findProducerByID(producerID));
        
        return commentRepository.save(newComment);
    }


    public Producer verifySignIn(String userName, String password){
        Producer producer = producerRepository.findProducerByUsername(userName);

        if(producer == null) return null;
        if(!producer.getPassword().equals(password)) return null;

        return producer;

    }

    public Producer getProducerByFarm(Integer id) {
        return farmRepository.findFarmByID(id).getProducer();
    }

}
