package msgroup.gleaningplanner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.GleanerGroupTO;
import msgroup.gleaningplanner.model.GleanerGroup;
import msgroup.gleaningplanner.service.GleanerGroupService;

@RestController
public class GleanerGroupController {
    private GleanerGroupService gleanergroupService;

    public GleanerGroupController(GleanerGroupService gleanergroupService){
        this.gleanergroupService = gleanergroupService;
    }

    @PostMapping("/producer/register")
    public ResponseEntity<GleanerGroupTO> createGleanerGroup(@RequestBody GleanerGroupTO incoming){
        GleanerGroup newGleanerGroup = gleanergroupService.createGleanerGroup(
            incoming.username, incoming.password, incoming.groupName,
            incoming.region, incoming.description,
            incoming.missionStatement, incoming.imageURL);
        
        GleanerGroupTO out = new GleanerGroupTO(newGleanerGroup.getUsername(), newGleanerGroup.getPassword(), newGleanerGroup.getGroupName(), newGleanerGroup.getRegion(), newGleanerGroup.getDescription(), newGleanerGroup.getMissionStatement(), newGleanerGroup.getImageURL());
        return new ResponseEntity<GleanerGroupTO>(out, HttpStatus.OK);
    }
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