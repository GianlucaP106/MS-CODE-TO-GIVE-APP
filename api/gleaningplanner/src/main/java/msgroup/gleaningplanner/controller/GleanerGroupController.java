package msgroup.gleaningplanner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.GleanerGroupFilterTO;
import msgroup.gleaningplanner.controller.TransferObject.GleanerGroupRegistrationTO;
import msgroup.gleaningplanner.controller.TransferObject.GleanerGroupTO;
import msgroup.gleaningplanner.controller.TransferObject.GleanerGroupRegistrationTO.GleanerGroupRegistrationRequest;
import msgroup.gleaningplanner.controller.TransferObject.GleanerGroupTO.signInRequestGleanerGroup;
import msgroup.gleaningplanner.model.GleanerGroup;
import msgroup.gleaningplanner.model.GleanerGroupRegistration;
import msgroup.gleaningplanner.service.GleanerGroupService;

import msgroup.gleaningplanner.model.Comment;
import msgroup.gleaningplanner.controller.TransferObject.CommentTO;

@RestController
public class GleanerGroupController {
    private GleanerGroupService gleanergroupService;

    public GleanerGroupController(GleanerGroupService gleanergroupService){
        this.gleanergroupService = gleanergroupService;
    }

    @PostMapping("/gleaner-group/sign-in")
    public ResponseEntity<GleanerGroupTO> signIn(@RequestBody signInRequestGleanerGroup incoming){
        GleanerGroup group = gleanergroupService.verifySignUp(
            incoming.username, 
            incoming.password
        );

        if(group == null) return new ResponseEntity<GleanerGroupTO>(new GleanerGroupTO(), HttpStatus.BAD_REQUEST);

        GleanerGroupTO out = new GleanerGroupTO(
            group.getID(),
            group.getUsername(),
            group.getPassword(), 
            group.getGroupName(), 
            group.getRegion(),
            group.getAddress(),
            group.getCity(),
            group.getPostalCode(),
            group.getDescription(), 
            group.getMissionStatement(), 
            group.getImageURL(),
            group.getLatitude(),
            group.getLongitude());
        return new ResponseEntity<GleanerGroupTO>(out, HttpStatus.OK);
    }

    @PostMapping("/gleaner-group/register")
    public ResponseEntity<GleanerGroupTO> createGleanerGroup(@RequestBody GleanerGroupTO incoming){
        GleanerGroup newGleanerGroup = gleanergroupService.createGleanerGroup(
            incoming.username, 
            incoming.password, 
            incoming.groupName,
            incoming.region,
            incoming.address,
            incoming.city,
            incoming.postalCode,
            incoming.description,
            incoming.missionStatement, 
            incoming.imageURL);

        GleanerGroupTO out = new GleanerGroupTO(
            newGleanerGroup.getID(),
            newGleanerGroup.getUsername(),
            newGleanerGroup.getPassword(), 
            newGleanerGroup.getGroupName(), 
            newGleanerGroup.getRegion(),
            newGleanerGroup.getAddress(),
            newGleanerGroup.getCity(),
            newGleanerGroup.getPostalCode(),

            newGleanerGroup.getDescription(), 
            newGleanerGroup.getMissionStatement(), 
            newGleanerGroup.getImageURL(),
            newGleanerGroup.getLatitude(),
            newGleanerGroup.getLongitude());
        return new ResponseEntity<GleanerGroupTO>(out, HttpStatus.OK);
    }

    @PutMapping("/gleaner-group/update")
    public ResponseEntity<GleanerGroupTO> updateGleanerGroup(@RequestBody GleanerGroupTO incoming){
       
        GleanerGroup newGleanerGroup = gleanergroupService.updateGleanerGroup(
        incoming.ID, 
        incoming.username, 
        incoming.password,
        incoming.groupName,
        incoming.region,
        incoming.address, 
        incoming.city,
        incoming.postalCode,
        incoming.description,
        incoming.missionStatement, 
        incoming.imageURL);

        GleanerGroupTO out =  new GleanerGroupTO(
                            newGleanerGroup.getID(),
                            newGleanerGroup.getUsername(),
                            newGleanerGroup.getPassword(),
                            newGleanerGroup.getGroupName(),
                            newGleanerGroup.getRegion(),
                            newGleanerGroup.getDescription(),
                            newGleanerGroup.getMissionStatement(),
                            newGleanerGroup.getImageURL(),
                            newGleanerGroup.getAddress(),
                            newGleanerGroup.getCity(),
                            newGleanerGroup.getPostalCode(),
                            newGleanerGroup.getLatitude(),
                            newGleanerGroup.getLongitude()
                            );
        return new ResponseEntity<GleanerGroupTO>(out, HttpStatus.OK);
    }

    @GetMapping("/gleaner-group/get-with-filters")
    public ResponseEntity<GleanerGroupFilterTO> getGleanerGroupWithFilters(@RequestBody GleanerGroupTO incoming) {
        Set<GleanerGroup> filteredgleanerGroups = this.gleanergroupService.filtersGleanerGroups(
            incoming.ID, 
            incoming.username, 
            incoming.password,
            incoming.groupName,
            incoming.region,
            incoming.address, 
            incoming.city,
            incoming.postalCode,
            incoming.description,
            incoming.missionStatement, 
            incoming.imageURL
        );

        List<GleanerGroupTO> gleanergroupsTOs = new ArrayList<GleanerGroupTO>();
        for (GleanerGroup gleanerGroup : filteredgleanerGroups) {
            GleanerGroupTO to = new GleanerGroupTO(
                gleanerGroup.getID(),
                gleanerGroup.getUsername(),
                gleanerGroup.getPassword(),
                gleanerGroup.getGroupName(),
                gleanerGroup.getRegion(),
                gleanerGroup.getDescription(),
                gleanerGroup.getMissionStatement(),
                gleanerGroup.getImageURL(),
                gleanerGroup.getAddress(),
                gleanerGroup.getCity(),
                gleanerGroup.getPostalCode(),
                gleanerGroup.getLatitude(),
                gleanerGroup.getLongitude()
            );
            gleanergroupsTOs.add(to);
        }

        return new ResponseEntity<GleanerGroupFilterTO>(new GleanerGroupFilterTO(gleanergroupsTOs), HttpStatus.OK);
    }

    @PostMapping("/gleaner-group/event-register")
    public ResponseEntity<GleanerGroupRegistrationTO> eventRegister(@RequestBody GleanerGroupRegistrationRequest incoming){
        GleanerGroupRegistration registration =  gleanergroupService.registerToEvent(
            incoming.eventID,
            incoming.gleanerGroupID
        );

        GleanerGroupRegistrationTO out = new GleanerGroupRegistrationTO(
            registration.getID(),
            registration.getGleanerGroup().getID(),
            registration.getEvent().getID(),
            registration.isEventApproved()
        );

        return new ResponseEntity<GleanerGroupRegistrationTO>(out, HttpStatus.OK);
    }

    @GetMapping("/gleaner-group/all")
    public List<GleanerGroupTO> getAllGleanerGroups() {
        return gleanergroupService.getAll();
    }

    @PostMapping("/gleaner-group/comment-event/")
    public  ResponseEntity<CommentTO> postCommentEvent(@RequestBody CommentTO incoming) {
        Comment comment = gleanergroupService.postCommentEvent(
            incoming.gleanerGroupID,
            incoming.eventID,
            incoming.comment,
            incoming.authorType
        );

        CommentTO out = new CommentTO();
        out.setAuthorType(comment.getAuthorType().toString());
        out.setComment(comment.getComment());
        out.setOrganizationID(comment.getGleanerGroup().getID());
        out.setEventID(comment.getEvent().getID());

        return new ResponseEntity<CommentTO>(out, HttpStatus.OK);
    }
}