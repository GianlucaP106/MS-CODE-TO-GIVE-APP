package msgroup.gleaningplanner.service;

import java.util.ArrayList;
import java.util.List;

import javax.tools.DocumentationTool.Location;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.repository.OrganizationRepository;

@Service
public class OrganizationService {

    private OrganizationRepository organizationRepository;

    private LocationService locationService;

    public OrganizationService(OrganizationRepository organizationRepository, LocationService locationService) {
        this.organizationRepository = organizationRepository;
        this.locationService = locationService;
    }

    public Organization createOrganization(
        String username, 
        String password,
        String orgName, 
        String description, 
        String missionStatement, 
        String imageURL, 
        String address, 
        String city, 
        String postalCode,
        double maxDistance, 
        String websiteLink) {

            LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();

            Organization newOrganization= new Organization();
            newOrganization.setUsername(username);
            newOrganization.setPassword(password);
            newOrganization.setOrganizationName(orgName);
            newOrganization.setDescription(description);
            newOrganization.setMissionStatement(missionStatement);
            newOrganization.setMaxDistance(maxDistance);
            newOrganization.setWebsiteLink(websiteLink);
            newOrganization.setImageURL(imageURL);
            // setting long and lat
            newOrganization.setLatitude(location.data.get(0).latitude);
            newOrganization.setLongitude(location.data.get(0).longitude);
            newOrganization.setAddress(address);
            newOrganization.setCity(city);
            newOrganization.setPostalCode(postalCode);
            
            return organizationRepository.save(newOrganization);
            
    }

    public Organization getOrganizationById(int id) {
        return organizationRepository.findOrganizationByID(id);
    }

    public List<Organization> filterOrganizations(
        int id,
        String username, 
        String password,
        String orgName, 
        String description, 
        String missionStatement, 
        String imageURL, 
        String address, 
        String city, 
        String postalCode,
        int maxDistance, 
        String websiteLink
    ) {

        List<Organization> filtered = new ArrayList<Organization>();
        
        if (id != -1) {
            Organization organization = organizationRepository.findOrganizationByID(id);
            filtered.add(organization);
        }
        return filtered;
    }
}
