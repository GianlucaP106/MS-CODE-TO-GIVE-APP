package msgroup.gleaningplanner.service;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.repository.OrganizationRepository;

@Service
public class OrganizationService {

    private OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization createOrganization(String username, 
        String password,
        String orgName, 
        String description, 
        String missionStatement, 
        String imageURL, 
        String address, 
        String city, 
        String postalCode,
        int maxDistance, 
        String websiteLink) {

            Organization newOrganization= new Organization();
            newOrganization.setUsername(username);
            newOrganization.setPassword(password);
            newOrganization.setOrganizationName(orgName);
            newOrganization.setDescription(description);
            newOrganization.setMissionStatement(missionStatement);
            newOrganization.setMaxDistance(maxDistance);
            newOrganization.setWebsiteLink(websiteLink);
            newOrganization.setImageURL(imageURL);
            // call method to convert TODO
            newOrganization.setLatitude(0);
            newOrganization.setLongitude(0);
            
            return organizationRepository.save(newOrganization);
            
    }
}
