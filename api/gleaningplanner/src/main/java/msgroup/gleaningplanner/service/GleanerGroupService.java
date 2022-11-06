package msgroup.gleaningplanner.service;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.controller.TransferObject.GleanerGroupRegistrationTO.GleanerGroupRegistrationRequest;
import msgroup.gleaningplanner.model.GleanerGroup;
import msgroup.gleaningplanner.model.GleanerGroupRegistration;
import msgroup.gleaningplanner.repository.EventRepository;
import msgroup.gleaningplanner.repository.GleanerGroupRepository;


@Service
public class GleanerGroupService {
    
    private GleanerGroupRepository gleanerGroupRepository;
    private EventRepository eventRepository;

    public GleanerGroupService(GleanerGroupRepository gleanerGroupRepository) {
        this.gleanerGroupRepository = gleanerGroupRepository;
    }

    public GleanerGroup createGleanerGroup(String username,
        String password,
        String groupName,
        String region,
        String description,
        String missionStatement,
        String imageURL){

        GleanerGroup newGleanerGroup = new GleanerGroup();
            newGleanerGroup.setUsername(username);
            newGleanerGroup.setPassword(password);
            newGleanerGroup.setGroupName(groupName);
            newGleanerGroup.setRegion(region);
            newGleanerGroup.setDescription(description);
            newGleanerGroup.setMissionStatement(missionStatement);
            newGleanerGroup.setImageURL(imageURL);

            return gleanerGroupRepository.save(newGleanerGroup);
    }

    // public GleanerGroupRegistration registerToEvent(GleanerGroupRegistrationRequest incoming){
    //     GleanerGroup gleanerGroup = gleanerGroupRepository.findGleanerGroupByID(incoming.gleanerGroupID);
    // }

}
