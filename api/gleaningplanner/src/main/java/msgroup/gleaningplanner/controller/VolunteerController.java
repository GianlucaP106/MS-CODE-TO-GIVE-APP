package msgroup.gleaningplanner.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void createVolunteer(@RequestBody VolunteerTO incoming) {
        Volunteer newVolunteer = volunteerService.createVolunteer(incoming.firstName, incoming.lastName, incoming.email,incoming.username,incoming.password,incoming.phoneNumber,incoming.address,incoming.postalCode, incoming.city);
        return;
    }

}
