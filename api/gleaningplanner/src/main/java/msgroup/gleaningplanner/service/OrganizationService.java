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
import msgroup.gleaningplanner.controller.TransferObject.OrganizationTO;
import msgroup.gleaningplanner.model.AuthorType;
import msgroup.gleaningplanner.model.Comment;
import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.model.OrganizationRegistration;
import msgroup.gleaningplanner.model.Produce;
import msgroup.gleaningplanner.model.Produce.CropType;
import msgroup.gleaningplanner.repository.CommentRepository;
import msgroup.gleaningplanner.repository.EventRepository;
import msgroup.gleaningplanner.repository.OrganizationRegistrationRepository;
import msgroup.gleaningplanner.repository.OrganizationRepository;
import msgroup.gleaningplanner.repository.ProduceRepository;

@Service
public class OrganizationService {

    private OrganizationRepository organizationRepository;
    private LocationService locationService;
    private EventRepository eventRepository;
    private CommentRepository commentRepository;
    private OrganizationRegistrationRepository organizationRegistrationRepository;
    private ProduceRepository produceRepository;

    public OrganizationService(
        OrganizationRepository organizationRepository, 
        LocationService locationService, 
        EventRepository eventRepository,
        CommentRepository commentRepository,
        OrganizationRegistrationRepository organizationRegistrationRepository,
        ProduceRepository produceRepository
    ) {
        this.organizationRepository = organizationRepository;
        this.locationService = locationService;
        this.eventRepository = eventRepository;
        this.commentRepository = commentRepository;
        this.organizationRegistrationRepository = organizationRegistrationRepository;
        this.produceRepository = produceRepository;
    }

    public Organization createOrganization(
        String username, 
        String password,
        String orgName, 
        String description, 
        String missionStatement, 
        String imageURL, 
        String address, 
        String city, 
        String postalCode,
        Double maxDistance, 
        String websiteLink,
        String phoneNumber) {

            LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();

            Organization newOrganization = new Organization();
            newOrganization.setUsername(username);
            newOrganization.setPassword(password);
            newOrganization.setOrganizationName(orgName);
            newOrganization.setDescription(description);
            newOrganization.setMissionStatement(missionStatement);
            newOrganization.setMaxDistance(maxDistance);
            newOrganization.setWebsiteLink(websiteLink);
            newOrganization.setImageURL(imageURL);
            // setting long and lat
            newOrganization.setLatitude(location.data.get(0).latitude);
            newOrganization.setLongitude(location.data.get(0).longitude);
            newOrganization.setAddress(address);
            newOrganization.setCity(city);
            newOrganization.setPostalCode(postalCode);
            newOrganization.setParticipatedEvent(0);
            newOrganization.setPhoneNumber(phoneNumber);
            
            return organizationRepository.save(newOrganization);
            
    }

    public Set<Organization> filterOrganizations(
        Integer id,
        String username, 
        String password,
        String orgName, 
        String description, 
        String missionStatement, 
        String imageURL, 
        String address, 
        String city, 
        String postalCode,
        Double maxDistance, 
        String websiteLink
    ) {

        Set<Organization> filtered = new HashSet<Organization>();
        
        if (id != null && id > 0) {
            filtered.add(organizationRepository.findOrganizationByID(id));
            return filtered;
        }

        if (username != null) {
            filtered.add(organizationRepository.findOrganizationByUsername(username));
            return filtered;
        }
        
        String longitude = null;
        String latitude = null;
        if (address != null && postalCode != null && city != null) {
            LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();
            latitude = Double.toString(location.data.get(0).latitude);
            longitude = Double.toString(location.data.get(0).longitude);
        }

        String mD = null;
        if (maxDistance != null) {
            mD = Double.toString(maxDistance);
        }

        List<String> incoming = Arrays.asList(orgName, description, missionStatement, imageURL, address, city, postalCode, mD, websiteLink, latitude, longitude);
        List<String> organizationInfo;
        
        for (Organization organization : organizationRepository.findAll()) {
            organizationInfo = Arrays.asList(organization.getOrganizationName(), organization.getDescription(), organization.getMissionStatement(), organization.getImageURL(), organization.getAddress(), organization.getCity(), organization.getPostalCode(), Double.toString(organization.getMaxDistance()), organization.getWebsiteLink(), latitude, longitude);
            boolean valid = true;
            for (int index = 0; index < incoming.size(); index++) {
                
                if (incoming.get(index) != null && 
                !incoming.get(index).equals(organizationInfo.get(index))) valid = false;
            }

            if (valid) filtered.add(organization);
        }

        return filtered;
    }

    public Organization updateOrganization(
        Integer id,
        String username, 
        String password,
        String orgName, 
        String description, 
        String missionStatement, 
        String imageURL, 
        String address, 
        String city, 
        String postalCode,
        Double maxDistance, 
        String websiteLink
    ) {

        Organization newOrganization = organizationRepository.findOrganizationByID(id);

        if (description != null){
            newOrganization.setDescription(description);
        }
        if (imageURL != null) {
            newOrganization.setImageURL(imageURL);
        }
        if (maxDistance != null){
            newOrganization.setMaxDistance(maxDistance);
        }
        if (missionStatement != null) {
            newOrganization.setMissionStatement(missionStatement);
        }
        if (orgName != null) {
            newOrganization.setOrganizationName(orgName);
        }
        if (password != null) {
            newOrganization.setPassword(password);
        }
        if (username != null){
            newOrganization.setUsername(username);
        }
        if (websiteLink != null){
            newOrganization.setWebsiteLink(missionStatement);
        }
        if (address != null && postalCode != null && city != null){
            newOrganization.setAddress(address);
            newOrganization.setPostalCode(postalCode);
            newOrganization.setCity(city);

            LocationAPITO locationAPITO = locationService.transformToLatitudeLongitude(newOrganization.getAddress(), newOrganization.getPostalCode(), newOrganization.getCity()).getBody();
            newOrganization.setLatitude(locationAPITO.data.get(0).latitude);
            newOrganization.setLongitude(locationAPITO.data.get(0).longitude);
        }

        return organizationRepository.save(newOrganization);
    }

    public OrganizationRegistration registerToEvent(
        Integer eventId,
        Integer organizationId
    ) {
        Organization organization = organizationRepository.findOrganizationByID(organizationId);
        Event event = eventRepository.findEventByID(eventId);

        // incrementing by 1
        organization.setParticipatedEvent(
            organization.getParticipatedEvent() + 1
        );

        OrganizationRegistration registration = new OrganizationRegistration();
        
        registration.setEvent(event);
        registration.setOrganization(organization);

        return organizationRegistrationRepository.save(registration);
    }

    public Comment postCommentEvent(String comment, String authorType, int organizationID, int eventID) {
        
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
        newComment.setOrganization(organizationRepository.findOrganizationByID(organizationID));

        return commentRepository.save(newComment);
        
    }

    public List<OrganizationTO> getAll() {
        List<OrganizationTO> organizations = new ArrayList<OrganizationTO>();

        for(Organization organization : organizationRepository.findAll()) {
            organizations.add(new OrganizationTO(
                organization.getID(),
                organization.getOrganizationName(),
                organization.getDescription(),
                organization.getMissionStatement(),
                organization.getImageURL(),
                organization.getAddress(),
                organization.getPostalCode(),
                organization.getAddress(),
                organization.getCity(),
                null,
                organization.getMaxDistance(),
                organization.getWebsiteLink(),
                organization.getLatitude(),
                organization.getLatitude(),
                organization.getParticipatedEvent(),
                organization.getPhoneNumber()
            ));
        }
        return organizations;
    }

    public Produce addProduceToRegistration(
        int eventID, 
        int organizationID,
        String produceType, 
        double amount
    ) {
        Produce produce = new Produce();
        Event event = eventRepository.findEventByID(eventID);
        Organization org = organizationRepository.findOrganizationByID(organizationID);


        OrganizationRegistration registration = 
            organizationRegistrationRepository.findOrganizationRegistrationByEventAndOrganization(event, org);

        produce.setOrganizationRegistration(registration);

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

    public Organization verifySignIn(String username, String password){

        Organization org = organizationRepository.findOrganizationByUsername(username);
        if(org == null) return null;
        if(!org.getPassword().equals(password)) return null;

        return org;
    }
}
