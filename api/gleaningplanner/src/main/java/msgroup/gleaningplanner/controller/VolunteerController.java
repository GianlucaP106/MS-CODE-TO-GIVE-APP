package msgroup.gleaningplanner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.VolunteerFilterTO;
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

    @GetMapping("/volunteer/get-by-filter")
    public ResponseEntity<VolunteerFilterTO> getVolunteerByFilter(@RequestBody VolunteerTO incoming) {
        System.out.println("hellelelelelkelknrkfonfre ");
        List<Volunteer> filteredVolunteers = this.volunteerService.filterVolunteers(
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
            VolunteerTO to = new VolunteerTO(
                volunteer.getID(),
                volunteer.getUsername(),
                volunteer.getFirstName(),
                volunteer.getLastName(),
                volunteer.getEmail(),
                volunteer.getPhoneNumber(),
                "postal",
                "address",
                "city",
                null
            );
            volunteerTOs.add(to);
        }

        return new ResponseEntity<VolunteerFilterTO>(new VolunteerFilterTO(volunteerTOs), HttpStatus.OK);
    }

}
