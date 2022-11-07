package msgroup.gleaningplanner.service;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Volunteer;
import msgroup.gleaningplanner.model.VolunteerRegistration;
import msgroup.gleaningplanner.repository.EventRepository;
import msgroup.gleaningplanner.repository.VolunteerRegistrationRepository;
import msgroup.gleaningplanner.repository.VolunteerRepository;

import msgroup.gleaningplanner.model.AuthorType;
import msgroup.gleaningplanner.model.Comment;
import msgroup.gleaningplanner.repository.CommentRepository;


@Service
public class VolunteerService {

    private VolunteerRepository volunteerRepository;
    private VolunteerRegistrationRepository volunteerRegistrationRepository;
    private LocationService locationService;
    private EventRepository eventRepository;
    private CommentRepository commentRepository;

    public VolunteerService(
        VolunteerRepository volunteerRepository, 
        LocationService locationService, 
        EventRepository eventRepository, 
        VolunteerRegistrationRepository volunteerRegistrationRepository,
        CommentRepository commentRepository
    ) {

        this.volunteerRepository = volunteerRepository;
        this.locationService = locationService;
        this.eventRepository = eventRepository;
        this.volunteerRegistrationRepository = volunteerRegistrationRepository;
        this.commentRepository = commentRepository;
    }

    public Volunteer createVolunteer(String firstName, 
        String lastName, 
        String email,
        String username, 
        String password, 
        String phoneNumber, 
        String address, 
        String postalCode, 
        String city
    ) {

            Volunteer newVolunteer = new Volunteer();
            newVolunteer.setEmail(email);
            newVolunteer.setFirstName(firstName);
            newVolunteer.setLastName(lastName);
            newVolunteer.setPassword(password);
            newVolunteer.setPhoneNumber(phoneNumber);

            LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();

            newVolunteer.setUsername(username);
            newVolunteer.setLatitude(location.data.get(0).latitude);
            newVolunteer.setLongitude(location.data.get(0).longitude);
            newVolunteer.setAddress(address);
            newVolunteer.setCity(city);
            newVolunteer.setPostalCode(postalCode);
            return volunteerRepository.save(newVolunteer);
            
    }

    public Set<Volunteer> filterVolunteers(
    Integer ID ,
    String username,
    String firstName,
    String lastName,
    String email,
    String phoneNumber,
    String postalCode,
    String address,
    String city,
    String password) {

        Set<Volunteer> filtered = new HashSet<Volunteer>();

        if (ID != null && ID != 0 && ID > 0) {
            filtered.add(volunteerRepository.findVolunteerByID(ID));
            return filtered;
        }
        
        if (username != null) {
            filtered.add(volunteerRepository.findVolunteerByUsername(username));
            return filtered;
        }
        String latitude = null;
        String longitude = null;
        if (address != null && postalCode != null && city != null) {
            LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();
            latitude = Double.toString(location.data.get(0).latitude);
            longitude = Double.toString(location.data.get(0).longitude);
        }



        List<String> incoming = Arrays.asList(firstName, lastName, email, phoneNumber, latitude , longitude, address, city, postalCode);
        List<String> volunteerInfo;

        for (Volunteer volunteer : volunteerRepository.findAll()) {
            volunteerInfo = Arrays.asList(volunteer.getFirstName(), volunteer.getLastName(), volunteer.getEmail(), volunteer.getPhoneNumber(), Double.toString(volunteer.getLatitude()), Double.toString(volunteer.getLongitude()), volunteer.getAddress(), volunteer.getCity(), volunteer.getPostalCode());
            boolean valid = true;
            for (int index = 0; index < incoming.size(); index++) {

                if (incoming.get(index) != null && !incoming.get(index).equals(volunteerInfo.get(index))) {
                    valid = false;
                }    
            }
            if (valid) filtered.add(volunteer);
        }

        return filtered;

    }

    public VolunteerRegistration registerToEvent(
        Integer eventID,
        Integer volunteerID
    ){
        Volunteer volunteer = volunteerRepository.findVolunteerByID(volunteerID);
        Event event = eventRepository.findEventByID(eventID);

        VolunteerRegistration newRegistration = new VolunteerRegistration();
        newRegistration.setVolunteer(volunteer);
        newRegistration.setEvent(event);
        newRegistration.setVolunteerGroupAccepted(false); 
        newRegistration.setEventAccepted(false);
        newRegistration.setOwner(false);
        newRegistration.setVolunteerGroupNumber(0);

        volunteerRegistrationRepository.save(newRegistration);
        return newRegistration;
    }

    public VolunteerRegistration requestJoinGroup(
        Integer eventID,
        Integer volunteerID,
        Integer groupNumber
    ){

        VolunteerRegistration registration = 
            volunteerRegistrationRepository.findVolunteerRegistrationByEventAndVolunteer(
                eventRepository.findEventByID(eventID),
                volunteerRepository.findVolunteerByID(volunteerID)
            );

        List<VolunteerRegistration> regs = volunteerRegistrationRepository.findAllVolunteerRegistrationByVolunteerGroupNumber(groupNumber);

        if(regs != null) {
            List<VolunteerRegistration> regsEvent = new ArrayList<VolunteerRegistration>();
            for(VolunteerRegistration reg : regs){
                if(reg.getEvent().getID() == eventID){
                    regsEvent.add(reg);
                }
            }
            if(regsEvent.size() == 0 ){
                registration.setOwner(true);
                registration.setVolunteerGroupAccepted(true);
            }
               
        }

        registration.setVolunteerGroupNumber(groupNumber);
        return volunteerRegistrationRepository.save(registration);
    }

    public VolunteerRegistration acceptVolunteer(int volunteerID, int eventID) {

        VolunteerRegistration registrations = 
            volunteerRegistrationRepository.findVolunteerRegistrationByEventAndVolunteer(
                eventRepository.findEventByID(eventID),
                volunteerRepository.findVolunteerByID(volunteerID)
            );

        if(registrations  == null) return null;

        registrations.setVolunteerGroupAccepted(true);
        volunteerRegistrationRepository.save(registrations);

        return registrations;
    }


    public Comment postCommentEvent(int volunteerID, int eventID, String comment, String authorType){
        
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
        newComment.setVolunteer(volunteerRepository.findVolunteerByID(volunteerID));

        return commentRepository.save(newComment);
    }


    public Volunteer verifySignUp(String username, String password){
        Volunteer volunteer = volunteerRepository.findVolunteerByUsername(username);


        if(volunteer == null) return null;
        if(!volunteer.getPassword().equals(password)) return null;

        return volunteer;
    }

}
