package msgroup.gleaningplanner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.controller.TransferObject.OrganizationFilterTO;
import msgroup.gleaningplanner.controller.TransferObject.OrganizationTO;
import msgroup.gleaningplanner.model.Organization;
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
        Organization newOrganization = organizationService.getOrganizationById(incoming.id);
        if (incoming.description != null){
            newOrganization.setDescription(incoming.description);
        }
        if (incoming.imageURL != null) {
            newOrganization.setImageURL(incoming.imageURL);
        }
        if (incoming.maxDistance != -1){
            newOrganization.setMaxDistance(incoming.maxDistance);
        }
        if (incoming.missionStatement != null) {
            newOrganization.setMissionStatement(incoming.missionStatement);
        }
        if (incoming.orgName != null) {
            newOrganization.setOrganizationName(incoming.orgName);
        }
        if (incoming.password != null) {
            newOrganization.setPassword(incoming.password);
        }
        if (incoming.username != null){
            newOrganization.setUsername(incoming.username);
        }
        if (incoming.websiteLink != null){
            newOrganization.setWebsiteLink(incoming.missionStatement);
        }
        if (incoming.address != null && incoming.postalCode != null && incoming.city != null){
            newOrganization.setAddress(incoming.address);
            newOrganization.setPostalCode(incoming.postalCode);
            newOrganization.setCity(incoming.city);

            LocationAPITO locationAPITO = locationService.transformToLatitudeLongitude(newOrganization.getAddress(), newOrganization.getPostalCode(), newOrganization.getCity()).getBody();
            newOrganization.setLatitude(locationAPITO.data.get(0).latitude);
            newOrganization.setLongitude(locationAPITO.data.get(0).longitude);
        }
        OrganizationTO out = new OrganizationTO(newOrganization.getID(), newOrganization.getUsername(), newOrganization.getOrganizationName(), 
        newOrganization.getDescription(), newOrganization.getMissionStatement(), 
        newOrganization.getImageURL(), "POSTAL", "address", "city", null, 
        newOrganization.getMaxDistance(), newOrganization.getWebsiteLink(),
        newOrganization.getLongitude(), newOrganization.getLatitude());

        
        return new ResponseEntity<OrganizationTO>(out, HttpStatus.OK);
    }

    // @GetMapping("/organization/get-by-filter")
    // public ResponseEntity<OrganizationFilterTO> getOrganizationByFilter(@RequestBody OrganizationTO incoming) {
    //     List<Organization> filteredOrganizations = this.organizationService.filterOrganizations(
    //         incoming.username, 
    //         incoming.orgName, 
    //         incoming.description, 
    //         incoming.missionStatement, 
    //         incoming.imageURL, 
    //         incoming.address, 
    //         incoming.postalCode, 
    //         incoming.city, 
    //         incoming.password, 
    //         incoming.maxDistance, 
    //         incoming.websiteLink
    //     );
        
    //     List<OrganizationTO> organizationTOs = new ArrayList<OrganizationTO>();
    //     for (Organization organization : filteredOrganizations) {
    //         OrganizationTO to = new OrganizationTO(
    //             organization.getID(), 
    //             organization.getUsername(), 
    //             organization.getOrganizationName(), 
    //             organization.getDescription(), 
    //             organization.getMissionStatement(), 
    //             organization.getImageURL(),
    //             "postal", 
    //             "address", 
    //             "city", 
    //             organization.getPassword(), 
    //             organization.getMaxDistance(), 
    //             organization.getWebsiteLink()
    //         );
    //         organizationTOs.add(to);
    //     }

    //     return new ResponseEntity<OrganizationFilterTO>(new OrganizationFilterTO(organizationTOs), HttpStatus.OK);

    // }
}
