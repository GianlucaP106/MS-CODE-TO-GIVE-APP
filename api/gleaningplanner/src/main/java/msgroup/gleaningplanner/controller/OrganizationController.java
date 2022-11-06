package msgroup.gleaningplanner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.controller.TransferObject.OrganizationFilterTO;
import msgroup.gleaningplanner.controller.TransferObject.OrganizationRegistrationTO;
import msgroup.gleaningplanner.controller.TransferObject.OrganizationTO;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.model.OrganizationRegistration;
import msgroup.gleaningplanner.service.LocationService;
import msgroup.gleaningplanner.service.OrganizationService;

@RestController
public class OrganizationController {

    private OrganizationService organizationService;
    private LocationService locationService;

    public OrganizationController(OrganizationService organizationService, LocationService locationService) {
        this.organizationService = organizationService;
        this.locationService = locationService;
    }
 
    @PostMapping("/organization/register")
    public ResponseEntity<OrganizationTO> createOrganization(@RequestBody OrganizationTO incoming) {
        Organization newOrganization = organizationService.createOrganization(
            incoming.username,
            incoming.password,
            incoming.orgName,
            incoming.description,
            incoming.missionStatement,
            incoming.imageURL,
            incoming.address,
            incoming.city,
            incoming.postalCode,
            incoming.maxDistance,
            incoming.websiteLink
        );

        OrganizationTO out = new OrganizationTO(
            newOrganization.getID(), 
            newOrganization.getUsername(), 
            newOrganization.getOrganizationName(), 
            newOrganization.getDescription(), 
            newOrganization.getMissionStatement(), 
            newOrganization.getImageURL(), 
            newOrganization.getAddress(), 
            newOrganization.getPostalCode(),
            newOrganization.getCity(), 
            null, 
            newOrganization.getMaxDistance(), 
            newOrganization.getWebsiteLink(),
            newOrganization.getLongitude(), 
            newOrganization.getLatitude()
        );

        return new ResponseEntity<OrganizationTO>(out, HttpStatus.OK);
    }

    @PutMapping("organization/update")
    public ResponseEntity<OrganizationTO> updateOrganization(@RequestBody OrganizationTO incoming) {

        Organization newOrganization = organizationService.updateOrganization(
            incoming.id,
            incoming.username,
            incoming.password,
            incoming.orgName,
            incoming.description,
            incoming.missionStatement,
            incoming.imageURL,
            incoming.address,
            incoming.city,
            incoming.postalCode,
            incoming.maxDistance,
            incoming.websiteLink
        );
        
        OrganizationTO out = new OrganizationTO(
            newOrganization.getID(), 
            newOrganization.getUsername(), 
            newOrganization.getOrganizationName(), 
            newOrganization.getDescription(), 
            newOrganization.getMissionStatement(), 
            newOrganization.getImageURL(), 
            newOrganization.getAddress(), 
            newOrganization.getPostalCode(),
            newOrganization.getCity(), 
            null, 
            newOrganization.getMaxDistance(), 
            newOrganization.getWebsiteLink(),
            newOrganization.getLongitude(), 
            newOrganization.getLatitude()
        );

        return new ResponseEntity<OrganizationTO>(out, HttpStatus.OK);
    }

    @PostMapping("/organization/get-by-filter")
    public ResponseEntity<OrganizationFilterTO> getOrganizationByFilter(@RequestBody OrganizationTO incoming) {
        Set<Organization> filteredOrganizations = this.organizationService.filterOrganizations(
            incoming.id,
            incoming.username, 
            incoming.password, 
            incoming.orgName, 
            incoming.description, 
            incoming.missionStatement, 
            incoming.imageURL, 
            incoming.address, 
            incoming.city, 
            incoming.postalCode, 
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
                organization.getAddress(), 
                organization.getPostalCode(), 
                organization.getCity(), 
                organization.getPassword(), 
                organization.getMaxDistance(), 
                organization.getWebsiteLink(),
                organization.getLatitude(),
                organization.getLongitude()
            );
            organizationTOs.add(to);
        }

        return new ResponseEntity<OrganizationFilterTO>(new OrganizationFilterTO(organizationTOs), HttpStatus.OK);

    }

    @PostMapping("/organization/event-register")
    public ResponseEntity<OrganizationRegistrationTO> registerToEvent(@RequestBody OrganizationRegistrationTO incoming){
        OrganizationRegistration organizationRegistration = organizationService.registerToEvent(incoming);

        OrganizationRegistrationTO out = new OrganizationRegistrationTO(organizationRegistration.getID(), organizationRegistration.getOrganization(), organizationRegistration.getEvent());

        return new ResponseEntity<OrganizationRegistrationTO>(out, HttpStatus.OK);

    }
}
