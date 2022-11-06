package msgroup.gleaningplanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.GleanerGroupRegistrationTO;
import msgroup.gleaningplanner.controller.TransferObject.GleanerGroupTO;
import msgroup.gleaningplanner.controller.TransferObject.GleanerGroupRegistrationTO.GleanerGroupRegistrationRequest;
import msgroup.gleaningplanner.model.GleanerGroup;
import msgroup.gleaningplanner.model.GleanerGroupRegistration;
import msgroup.gleaningplanner.service.GleanerGroupService;

@RestController
public class GleanerGroupController {
    private GleanerGroupService gleanergroupService;

    public GleanerGroupController(GleanerGroupService gleanergroupService){
        this.gleanergroupService = gleanergroupService;
    }

    @PostMapping("/gleaner-group/register")
    public ResponseEntity<GleanerGroupTO> createGleanerGroup(@RequestBody GleanerGroupTO incoming){
        GleanerGroup newGleanerGroup = gleanergroupService.createGleanerGroup(
            incoming.username, incoming.password, incoming.groupName,
            incoming.region, incoming.description,
            incoming.missionStatement, incoming.imageURL);
        
        GleanerGroupTO out = new GleanerGroupTO(newGleanerGroup.getUsername(), newGleanerGroup.getPassword(), newGleanerGroup.getGroupName(), newGleanerGroup.getRegion(), newGleanerGroup.getDescription(), newGleanerGroup.getMissionStatement(), newGleanerGroup.getImageURL());
        return new ResponseEntity<GleanerGroupTO>(out, HttpStatus.OK);
    }


    // @PostMapping("/gleaner-group/eventRegister")
    // public ResponseEntity<GleanerGroupRegistrationTO> eventRegister(@RequestBody GleanerGroupRegistrationRequest incoming){
    //     GleanerGroupRegistration registration =  gleanergroupService.registerToEvent(incoming);

    // }

}

/*
 *     "username": "username",
    "password": "password",
    "groupName": "groupName",
    "region": "region",
    "description": "description",
    "missionStatement": "missionStatement",
    "imageURL": "imageURL",
 */