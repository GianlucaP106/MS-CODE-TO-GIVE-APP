package msgroup.gleaningplanner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.OrganizationFilterTO;
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
    public ResponseEntity<OrganizationTO> createOrganization(@RequestBody OrganizationTO incoming) {
        Organization newOrganization = organizationService.createOrganization(incoming.username, incoming.orgName, incoming.description, incoming.missionStatement, incoming.imageURL, incoming.address, incoming.postalCode, incoming.city, incoming.password, incoming.maxDistance, incoming.websiteLink);
        OrganizationTO out = new OrganizationTO(newOrganization.getID(), newOrganization.getUsername(), newOrganization.getOrganizationName(), 
        newOrganization.getDescription(), newOrganization.getMissionStatement(), 
        newOrganization.getImageURL(), "POSTAL", "address", "city", null, 
        newOrganization.getMaxDistance(), newOrganization.getWebsiteLink(),
        newOrganization.getLongitude(), newOrganization.getLatitude());

        return new ResponseEntity<OrganizationTO>(out, HttpStatus.OK);
    }

    @PutMapping("organization/update")
    public ResponseEntity<OrganizationTO> updateOrganization(@RequestBody OrganizationTO incoming) {
        Organization organization = organizationService.getOrganizationById(incoming.id);
        if (incoming.description != null){
            organization.setDescription(incoming.description);
        }
        if (incoming.imageURL != null) {
            organization.setImageURL(incoming.imageURL);
        }
        if (incoming.maxDistance != -1){
            organization.setMaxDistance(incoming.maxDistance);
        }
        if (incoming.missionStatement != null) {
            organization.setMissionStatement(incoming.missionStatement);
        }
        if (incoming.orgName != null) {
            organization.setOrganizationName(incoming.orgName);
        }
        if (incoming.password != null) {
            organization.setPassword(incoming.password);
        }
        if (incoming.username != null){
            organization.setUsername(incoming.username);
        }
        if (incoming.websiteLink != null){
            organization.setWebsiteLink(incoming.missionStatement);
        }
        // call method to convert TODO
        organization.setLatitude(0);
        organization.setLongitude(0);
        OrganizationTO out = new OrganizationTO(organization.getID(), organization.getUsername(), organization.getOrganizationName(), organization.getDescription(), organization.getMissionStatement(), organization.getImageURL(), "POSTAL", "address", "city", null, organization.getMaxDistance(), organization.getWebsiteLink());
        return new ResponseEntity<OrganizationTO>(out, HttpStatus.OK);
    }

    @GetMapping("/organization/get-by-filter")
    public ResponseEntity<OrganizationFilterTO> getOrganizationByFilter(@RequestBody OrganizationTO incoming) {
        List<Organization> filteredOrganizations = this.organizationService.filterOrganizations(
            incoming.username, 
            incoming.orgName, 
            incoming.description, 
            incoming.missionStatement, 
            incoming.imageURL, 
            incoming.address, 
            incoming.postalCode, 
            incoming.city, 
            incoming.password, 
            incoming.maxDistance, 
            incoming.websiteLink
        );
        
        List<OrganizationTO> organizationTOs = new ArrayList<OrganizationTO>();
        for (Organization organization : filteredOrganizations) {
            OrganizationTO to = new OrganizationTO(
                organization.getID(), 
                organization.getUsername(), 
                organization.getOrganizationName(), 
                organization.getDescription(), 
                organization.getMissionStatement(), 
                organization.getImageURL(),
                "postal", 
                "address", 
                "city", 
                organization.getPassword(), 
                organization.getMaxDistance(), 
                organization.getWebsiteLink()
            );
            organizationTOs.add(to);
        }

        return new ResponseEntity<OrganizationFilterTO>(new OrganizationFilterTO(organizationTOs), HttpStatus.OK);

    }
}
