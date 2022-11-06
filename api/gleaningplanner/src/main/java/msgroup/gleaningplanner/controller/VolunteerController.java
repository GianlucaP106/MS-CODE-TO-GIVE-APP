package msgroup.gleaningplanner.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.AcceptenceTO;
import msgroup.gleaningplanner.controller.TransferObject.CommentTO;
import msgroup.gleaningplanner.controller.TransferObject.VolunteerFilterTO;
import msgroup.gleaningplanner.controller.TransferObject.VolunteerRegistrationTO;
import msgroup.gleaningplanner.controller.TransferObject.VolunteerTO;
import msgroup.gleaningplanner.controller.TransferObject.VolunteerRegistrationTO.RegistrationRequest;
import msgroup.gleaningplanner.controller.TransferObject.VolunteerRegistrationTO.RequestVolunteerJoinVolunteerGroup;
import msgroup.gleaningplanner.controller.TransferObject.VolunteerTO.signInRequestVolunteer;
import msgroup.gleaningplanner.model.Volunteer;
import msgroup.gleaningplanner.model.VolunteerRegistration;
import msgroup.gleaningplanner.repository.VolunteerRepository;
import msgroup.gleaningplanner.service.VolunteerService;
import msgroup.gleaningplanner.model.Comment;

@RestController
public class VolunteerController {

    private VolunteerService volunteerService;
    private VolunteerRepository volunteerRepository;

    public VolunteerController(VolunteerService volunteerService, VolunteerRepository volunteerRepository) {
        this.volunteerService = volunteerService;
        this.volunteerRepository = volunteerRepository;
    }

    @PostMapping("volunteer/sign-in")
    public ResponseEntity<VolunteerTO> signIn(@RequestBody signInRequestVolunteer incoming){

        Volunteer vol = volunteerService.verifySignUp(
            incoming.username, 
            incoming.password
        );

        if(vol == null) return new ResponseEntity<VolunteerTO>(new VolunteerTO(), HttpStatus.BAD_REQUEST);

        VolunteerTO out = new VolunteerTO(
            vol.getID(), 
            vol.getUsername(), 
            vol.getFirstName(), 
            vol.getLastName(), 
            vol.getEmail(), 
            vol.getPhoneNumber(),
            vol.getPostalCode(), 
            vol.getAddress(), 
            vol.getCity(), 
            vol.getLatitude(), 
            vol.getLongitude(), 
            null,
            vol.getParticipatedEvent()
        );
        return new ResponseEntity<VolunteerTO>(out, HttpStatus.OK);

    }

    @GetMapping("/volunteer/all")
    public List<VolunteerTO> getAllVolunteers(){
        List<VolunteerTO> volunteers = new ArrayList<VolunteerTO>();
        for(Volunteer volunteer: volunteerRepository.findAll()){
            volunteers.add(new VolunteerTO(
                volunteer.getID(), 
                volunteer.getUsername(), 
                volunteer.getFirstName(), 
                volunteer.getLastName(), 
                volunteer.getEmail(), 
                volunteer.getPhoneNumber(),
                volunteer.getPostalCode(), 
                volunteer.getAddress(), 
                volunteer.getCity(), 
                volunteer.getLatitude(), 
                volunteer.getLongitude(), 
                null,
                volunteer.getParticipatedEvent()
            ));
        }
        return volunteers;
    }
 
    @PostMapping("/volunteer/register")
    public ResponseEntity<VolunteerTO> createVolunteer(@RequestBody VolunteerTO incoming) {
        Volunteer newVolunteer = volunteerService.createVolunteer(
            incoming.firstName, 
            incoming.lastName, 
            incoming.email,
            incoming.username,
            incoming.password,
            incoming.phoneNumber,
            incoming.address,
            incoming.postalCode, 
            incoming.city
        );
        VolunteerTO out = new VolunteerTO(
            newVolunteer.getID(), 
            newVolunteer.getUsername(), 
            newVolunteer.getFirstName(), 
            newVolunteer.getLastName(), 
            newVolunteer.getEmail(), 
            newVolunteer.getPhoneNumber(),
            newVolunteer.getPostalCode(), 
            newVolunteer.getAddress(), 
            newVolunteer.getCity(), 
            newVolunteer.getLatitude(), 
            newVolunteer.getLongitude(), 
            null,
            newVolunteer.getParticipatedEvent()
        );
        return new ResponseEntity<VolunteerTO>(out, HttpStatus.OK);
    }

    @PostMapping("/volunteer/get-by-filter")
    public ResponseEntity<VolunteerFilterTO> getVolunteerByFilter(@RequestBody VolunteerTO incoming) {
        Set<Volunteer> filteredVolunteers = this.volunteerService.filterVolunteers(
            incoming.ID,
            incoming.username,
            incoming.firstName,
            incoming.lastName,
            incoming.email,
            incoming.phoneNumber,
            incoming.postalCode,
            incoming.address,
            incoming.city,
            incoming.password
        );
        List<VolunteerTO> volunteerTOs = new ArrayList<VolunteerTO>();
        for (Volunteer volunteer : filteredVolunteers) {
            if (volunteer != null) {
                VolunteerTO to = new VolunteerTO(
                    volunteer.getID(),
                    volunteer.getUsername(),
                    volunteer.getFirstName(),
                    volunteer.getLastName(),
                    volunteer.getEmail(),
                    volunteer.getPhoneNumber(),
                    volunteer.getPostalCode(),
                    volunteer.getAddress(),
                    volunteer.getCity(),
                    volunteer.getLatitude(),
                    volunteer.getLongitude(),
                    null,
                    volunteer.getParticipatedEvent()
                );

                volunteerTOs.add(to);
            }
        }
        return new ResponseEntity<VolunteerFilterTO>(new VolunteerFilterTO(volunteerTOs), HttpStatus.OK);
    }


    @PostMapping("/volunteer/event-register")
    public ResponseEntity<VolunteerRegistrationTO> registerToEvent(@RequestBody RegistrationRequest incoming){
        VolunteerRegistration volunteerRegistration = volunteerService.registerToEvent(
            incoming.eventID,
            incoming.volunteerID
        );

        VolunteerRegistrationTO out = new VolunteerRegistrationTO(volunteerRegistration.getID(), volunteerRegistration.getVolunteer().getID(), volunteerRegistration.getEvent().getID(), 
        volunteerRegistration.getVolunteerGroupNumber(), volunteerRegistration.isVolunteerGroupAccepted(), volunteerRegistration.isOwner(), volunteerRegistration.isEventAccepted());

        return new ResponseEntity<VolunteerRegistrationTO>(out, HttpStatus.OK);

    }

    @PostMapping("/volunteer/event-request-group")
    public ResponseEntity<VolunteerRegistrationTO> requestGroupJoin(@RequestBody RequestVolunteerJoinVolunteerGroup incoming){
         VolunteerRegistration volunteerRegistration = volunteerService.requestJoinGroup(
            incoming.eventID,
            incoming.volunteerID,
            incoming.volunteerGroupNumber
        );

        VolunteerRegistrationTO out = new VolunteerRegistrationTO(volunteerRegistration.getID(), volunteerRegistration.getVolunteer().getID(), volunteerRegistration.getEvent().getID(), 
        volunteerRegistration.getVolunteerGroupNumber(), volunteerRegistration.isVolunteerGroupAccepted(), volunteerRegistration.isOwner(), volunteerRegistration.isEventAccepted());

        return new ResponseEntity<VolunteerRegistrationTO>(out, HttpStatus.OK);
    }

    @PostMapping("/volunteer/accept/volunteer")
    public ResponseEntity<AcceptenceTO> acceptVolunteer(@RequestBody AcceptenceTO incoming) {
        VolunteerRegistration volunteerRegistration = volunteerService.acceptVolunteer(incoming.getVolunteerID(),incoming.getEventID());

        Volunteer volunteer = volunteerRegistration.getVolunteer();

        List<VolunteerTO> out = Arrays.asList(
            new VolunteerTO(
                volunteer.getID(), 
                volunteer.getUsername(), 
                volunteer.getFirstName(), 
                volunteer.getLastName(), 
                volunteer.getEmail(), 
                volunteer.getPhoneNumber(), 
                volunteer.getPostalCode(), 
                volunteer.getAddress(), 
                volunteer.getCity(), 
                volunteer.getLatitude(), 
                volunteer.getLongitude(), 
                null,
                volunteer.getParticipatedEvent()
            ));

        return new ResponseEntity<AcceptenceTO>(
            new AcceptenceTO(
                volunteerRegistration.getEvent().getID(),
                volunteerRegistration.getVolunteerGroupNumber(),
                out
            ), 
            HttpStatus.OK
        );
    }
    
    @PostMapping("/volunteer/comment-event/")
    public  ResponseEntity<CommentTO> postCommentEvent(@RequestBody CommentTO incoming) {
        Comment comment = volunteerService.postCommentEvent(
            incoming.volunteerID,
            incoming.eventID,
            incoming.comment,
            incoming.authorType
        );

        CommentTO out = new CommentTO();
        out.setAuthorType(comment.getAuthorType().toString());
        out.setComment(comment.getComment());
        out.setOrganizationID(comment.getVolunteer().getID());
        out.setEventID(comment.getEvent().getID());

        return new ResponseEntity<CommentTO>(out, HttpStatus.OK);
    }
}

