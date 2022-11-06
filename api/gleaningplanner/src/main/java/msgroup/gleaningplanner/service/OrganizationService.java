package msgroup.gleaningplanner.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.DocumentationTool.Location;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.model.OrganizationRegistration;
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
        Double maxDistance, 
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

    public Set<Organization> filterOrganizations(
        Integer id,
        String username, 
        String password,
        String orgName, 
        String description, 
        String missionStatement, 
        String imageURL, 
        String address, 
        String city, 
        String postalCode,
        Double maxDistance, 
        String websiteLink
    ) {

        Set<Organization> filtered = new HashSet<Organization>();
        
        if (id != null && id > 0) {
            filtered.add(organizationRepository.findOrganizationByID(id));
            return filtered;
        }

        if (username != null) {
            filtered.add(organizationRepository.findOrganizationByUsername(username));
            return filtered;
        }
        
        String longitude = null;
        String latitude = null;
        if (address != null && postalCode != null && city != null) {
            LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();
            latitude = Double.toString(location.data.get(0).latitude);
            longitude = Double.toString(location.data.get(0).longitude);
        }

        String mD = null;
        if (maxDistance != null) {
            mD = Double.toString(maxDistance);
        }

        List<String> incoming = Arrays.asList(orgName, description, missionStatement, imageURL, address, city, postalCode, mD, websiteLink, latitude, longitude);
        List<String> organizationInfo;
        
        for (Organization organization : organizationRepository.findAll()) {
            organizationInfo = Arrays.asList(organization.getOrganizationName(), organization.getDescription(), organization.getMissionStatement(), organization.getImageURL(), organization.getAddress(), organization.getCity(), organization.getPostalCode(), Double.toString(organization.getMaxDistance()), organization.getWebsiteLink(), latitude, longitude);
            boolean valid = true;
            for (int index = 0; index < incoming.size(); index++) {
                
                if (incoming.get(index) != null && 
                !incoming.get(index).equals(organizationInfo.get(index))) valid = false;
            }

            if (valid) filtered.add(organization);
        }

        return filtered;
    }

    public Organization updateOrganization(
        Integer id,
        String username, 
        String password,
        String orgName, 
        String description, 
        String missionStatement, 
        String imageURL, 
        String address, 
        String city, 
        String postalCode,
        Double maxDistance, 
        String websiteLink
    ) {

        Organization newOrganization = organizationRepository.findOrganizationByID(id);

        if (description != null){
            newOrganization.setDescription(description);
        }
        if (imageURL != null) {
            newOrganization.setImageURL(imageURL);
        }
        if (maxDistance != null){
            newOrganization.setMaxDistance(maxDistance);
        }
        if (missionStatement != null) {
            newOrganization.setMissionStatement(missionStatement);
        }
        if (orgName != null) {
            newOrganization.setOrganizationName(orgName);
        }
        if (password != null) {
            newOrganization.setPassword(password);
        }
        if (username != null){
            newOrganization.setUsername(username);
        }
        if (websiteLink != null){
            newOrganization.setWebsiteLink(missionStatement);
        }
        if (address != null && postalCode != null && city != null){
            newOrganization.setAddress(address);
            newOrganization.setPostalCode(postalCode);
            newOrganization.setCity(city);

            LocationAPITO locationAPITO = locationService.transformToLatitudeLongitude(newOrganization.getAddress(), newOrganization.getPostalCode(), newOrganization.getCity()).getBody();
            newOrganization.setLatitude(locationAPITO.data.get(0).latitude);
            newOrganization.setLongitude(locationAPITO.data.get(0).longitude);
        }

        return organizationRepository.save(newOrganization);
    }

    public OrganizationRegistration registerEvent() {
        return new OrganizationRegistration();
    }
}
