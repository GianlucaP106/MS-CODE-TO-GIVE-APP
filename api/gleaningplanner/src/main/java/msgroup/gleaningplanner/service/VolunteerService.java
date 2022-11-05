package msgroup.gleaningplanner.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.model.Volunteer;
import msgroup.gleaningplanner.repository.VolunteerRepository;

@Service
public class VolunteerService {

    private VolunteerRepository volunteerRepository;
    private LocationService locationService;

    public VolunteerService(VolunteerRepository volunteerRepository, LocationService locationService) {
        this.volunteerRepository = volunteerRepository;
        this.locationService = locationService;
    }

    public Volunteer createVolunteer(String firstName, 
        String lastName, 
        String email,
        String username, 
        String password, 
        String phoneNumber, 
        String address, 
        String postalCode, 
        String city) {

            Volunteer newVolunteer = new Volunteer();
            newVolunteer.setEmail(email);
            newVolunteer.setFirstName(firstName);
            newVolunteer.setLastName(lastName);
            newVolunteer.setPassword(password);
            newVolunteer.setPhoneNumber(phoneNumber);

            LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();

            newVolunteer.setUsername(username);
            newVolunteer.setLatitude(location.data.get(0).latitude);
            newVolunteer.setLongitude(location.data.get(0).longitude);
            newVolunteer.setAddress(address);
            newVolunteer.setCity(city);
            newVolunteer.setPostalCode(postalCode);
            return volunteerRepository.save(newVolunteer);
            
    }

    public Set<Volunteer> filterVolunteers(
    int ID ,
    String username,
    String firstName,
    String lastName,
    String email,
    String phoneNumber,
    String postalCode,
    String address,
    String city,
    String password) {

        Set<Volunteer> filtered = new HashSet<Volunteer>();

        if (ID != -1) {
            filtered.add(volunteerRepository.findVolunteerByID(ID));
            return filtered;
        }
        
        if (username != null) {
            filtered.add(volunteerRepository.findVolunteerByUsername(username));
            return filtered;
        }


        LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();


        List<String> incoming = Arrays.asList(firstName, lastName, email, phoneNumber, Double.toString(location.data.get(0).latitude), Double.toString(location.data.get(0).longitude), address, city, postalCode);
        List<String> volunteerInfo;

        for (Volunteer volunteer : volunteerRepository.findAll()) {
            volunteerInfo = Arrays.asList(volunteer.getFirstName(), volunteer.getLastName(), volunteer.getEmail(), volunteer.getPhoneNumber(), Double.toString(volunteer.getLatitude()), Double.toString(volunteer.getLongitude()), volunteer.getAddress(), volunteer.getCity(), volunteer.getPostalCode());
            boolean valid = true;
            for (int index = 0; index < incoming.size(); index++) {

                if (incoming.get(index) != null && !incoming.get(index).equals(volunteerInfo.get(index))) {
                    valid = false;
                }    
            }
            if (valid) filtered.add(volunteer);
        }

        return filtered;

    }
    
}
