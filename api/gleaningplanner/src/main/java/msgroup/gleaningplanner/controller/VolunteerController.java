package msgroup.gleaningplanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.VolunteerTO;
import msgroup.gleaningplanner.model.Volunteer;
import msgroup.gleaningplanner.service.VolunteerService;

@RestController

public class VolunteerController {

    private VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }
 
    @PostMapping("/volunteer/register")
    public ResponseEntity<VolunteerTO> createVolunteer(@RequestBody VolunteerTO incoming) {
        Volunteer newVolunteer = volunteerService.createVolunteer(incoming.firstName, incoming.lastName, incoming.email,incoming.username,incoming.password,incoming.phoneNumber,incoming.address,incoming.postalCode, incoming.city);
        VolunteerTO out = new VolunteerTO(newVolunteer.getID(), newVolunteer.getUsername(), newVolunteer.getFirstName(), newVolunteer.getLastName(), newVolunteer.getEmail(), newVolunteer.getPhoneNumber(), "POSTAL", "address", "city", null);
        return new ResponseEntity<VolunteerTO>(out, HttpStatus.OK);
    }

}
