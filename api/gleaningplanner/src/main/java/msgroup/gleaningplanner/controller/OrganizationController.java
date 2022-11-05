package msgroup.gleaningplanner.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.OrganizationTO;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.service.OrganizationService;

@RestController

public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
 
    @PostMapping("/organization/register")
    public void createOrganization(@RequestBody OrganizationTO incoming) {
        Organization newOrganization = organizationService.createOrganization(incoming.username, incoming.orgName, incoming.description, incoming.missionStatement, incoming.imageURL, incoming.address, incoming.postalCode, incoming.city, incoming.password, incoming.maxDistance, incoming.websiteLink);
        return;
    }
}
