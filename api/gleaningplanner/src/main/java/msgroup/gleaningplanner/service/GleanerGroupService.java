package msgroup.gleaningplanner.service;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.model.GleanerGroup;
import msgroup.gleaningplanner.repository.GleanerGroupRepository;


@Service
public class GleanerGroupService {
    private GleanerGroupRepository gleanerGroupRepository;

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
}
