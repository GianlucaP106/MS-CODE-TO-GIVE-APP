package msgroup.gleaningplanner.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.GleanerGroup;
import msgroup.gleaningplanner.model.GleanerGroupRegistration;
import msgroup.gleaningplanner.repository.EventRepository;
import msgroup.gleaningplanner.repository.GleanerGroupRegistrationRepository;
import msgroup.gleaningplanner.repository.GleanerGroupRepository;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.controller.TransferObject.GleanerGroupRegistrationTO.GleanerGroupRegistrationRequest;


@Service
public class GleanerGroupService {
    
    private GleanerGroupRepository gleanerGroupRepository;
    private GleanerGroupRegistrationRepository gleanerGroupRegistrationRepository;
    private EventRepository eventRepository;

    private LocationService locationService;

    public GleanerGroupService(GleanerGroupRepository gleanerGroupRepository, LocationService locationService,
                GleanerGroupRegistrationRepository gleanerGroupRegistrationRepository) {
        this.gleanerGroupRepository = gleanerGroupRepository;
        this.locationService = locationService;
        this.gleanerGroupRegistrationRepository = gleanerGroupRegistrationRepository;
    }

    public GleanerGroup createGleanerGroup(
        String username,
        String password,
        String groupName,
        String region,
        String address,
        String city,
        String postalCode,
        String description,
        String missionStatement,
        String imageURL){

            LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();
            GleanerGroup newgleanerGroup = new GleanerGroup();
            newgleanerGroup.setUsername(username);
            newgleanerGroup.setPassword(password);
            newgleanerGroup.setGroupName(groupName);
            newgleanerGroup.setRegion(region);
            newgleanerGroup.setAddress(address);
            newgleanerGroup.setCity(city);
            newgleanerGroup.setPostalCode(postalCode);
            newgleanerGroup.setDescription(description);
            newgleanerGroup.setMissionStatement(missionStatement);
            newgleanerGroup.setImageURL(imageURL);

            newgleanerGroup.setLatitude(location.data.get(0).latitude);
            newgleanerGroup.setLongitude(location.data.get(0).longitude);
            newgleanerGroup.setAddress(address);
            newgleanerGroup.setCity(city);
            newgleanerGroup.setPostalCode(postalCode);
            
            return gleanerGroupRepository.save(newgleanerGroup);
    }

    public Set<GleanerGroup> filtersGleanerGroups(
        Integer id,
        String username, 
        String password,
        String groupName,
        String region,
        String address, 
        String city,
        String postalCode,
        String description,
        String missionStatement, 
        String imageURL
    ) {

        Set<GleanerGroup> filtered = new HashSet<GleanerGroup>();
        
        if (id != null && id != 0) {
            filtered.add(gleanerGroupRepository.findGleanerGroupByID(id));
            return filtered;
        }

        if (username != null) {
            filtered.add(gleanerGroupRepository.findAllGleanerGroupByUsername(username));
            return filtered;
        }
        
        LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();
        
        List<String> incoming = Arrays.asList(
            groupName, region, address, city, postalCode, description,
            missionStatement, imageURL, Double.toString(location.data.get(0).latitude), Double.toString(location.data.get(0).longitude));
        List<String> gleanergroupInfo;

        for (GleanerGroup gleanerGroup : gleanerGroupRepository.findAll()) {
            gleanergroupInfo = Arrays.asList(
                gleanerGroup.getGroupName(), 
                gleanerGroup.getRegion(),
                gleanerGroup.getAddress(),
                gleanerGroup.getCity(), 
                gleanerGroup.getPostalCode(),                                 
                gleanerGroup.getDescription(), 
                gleanerGroup.getMissionStatement(), 
                gleanerGroup.getImageURL(), 
                Double.toString(gleanerGroup.getLatitude()), 
                Double.toString(gleanerGroup.getLongitude()));

            boolean valid = true;
            for (int index = 0; index < incoming.size(); index++) {
                
                if (incoming.get(index) != null && 
                !incoming.get(index).equals(gleanergroupInfo.get(index))) valid = false;
            }

            if (valid) filtered.add(gleanerGroup);
        }

        return filtered;
    }

    public GleanerGroup updateGleanerGroup(
        Integer id,
        String username,
        String password,
        String groupName,
        String region,
        String address,
        String city,
        String postalCode,
        String description,
        String missionStatement,
        String imageURL){

        GleanerGroup newGleanerGroup = gleanerGroupRepository.findGleanerGroupByID(id);
        if (username != null){
            newGleanerGroup.setUsername(username);
        }
        if (password != null){
            newGleanerGroup.setPassword(password);
        }
        if (groupName != null){
            newGleanerGroup.setGroupName(groupName);
        }
        if (region != null){
            newGleanerGroup.setRegion(region);
        }
        if (description != null){
            newGleanerGroup.setDescription(description);
        }
        if (missionStatement != null){
            newGleanerGroup.setMissionStatement(missionStatement);
        }
        if (imageURL!= null){
            newGleanerGroup.setImageURL(imageURL);
        }          
        if (address != null && postalCode != null && city != null){
            newGleanerGroup.setAddress(address);
            newGleanerGroup.setCity(city);
            newGleanerGroup.setPostalCode(postalCode);

            LocationAPITO locationAPITO = locationService.transformToLatitudeLongitude(
            newGleanerGroup.getAddress(), newGleanerGroup.getPostalCode(), 
            newGleanerGroup.getCity()).getBody();

            newGleanerGroup.setLatitude(locationAPITO.data.get(0).latitude);
            newGleanerGroup.setLongitude(locationAPITO.data.get(0).longitude);
        }

        return gleanerGroupRepository.save(newGleanerGroup);
    }

    public GleanerGroupRegistration registerToEvent(
        Integer eventID,
        Integer gleanerGroupID
    ) {
        GleanerGroup group = gleanerGroupRepository.findGleanerGroupByID(gleanerGroupID);
        Event event = eventRepository.findEventByID(eventID);

        GleanerGroupRegistration registration = new GleanerGroupRegistration();

        registration.setEvent(event);
        registration.setGleanerGroup(group);
        registration.setEventApproved(false);
           
        return gleanerGroupRegistrationRepository.save(registration);
    }
}
