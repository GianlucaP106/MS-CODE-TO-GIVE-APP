package msgroup.gleaningplanner.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            // call method to convert TODO
            newVolunteer.setUsername(username);
            newVolunteer.setLatitude(0);
            newVolunteer.setLongitude(0);
            
            return volunteerRepository.save(newVolunteer);
            
    }

    public List<Volunteer> filterVolunteers(
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

        List<Volunteer> filtered = new ArrayList<Volunteer>();

        if (ID != -1) {
            filtered.add(volunteerRepository.findVolunteerByID(ID));
            return filtered;
        }
        
        if (username != null) {
            filtered.add(volunteerRepository.findVolunteerByUsername(username));
            return filtered;
        }


        LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();


        List<String> incoming = Arrays.asList(firstName, lastName, email, phoneNumber, Double.toString(location.data.get(0).latitude), Double.toString(location.data.get(0).longitude));
        List<String> volunteerInfo;

        for (Volunteer volunteer : volunteerRepository.findAll()) {
            volunteerInfo = Arrays.asList(volunteer.getFirstName(), volunteer.getLastName(), volunteer.getEmail(), volunteer.getPhoneNumber(), Double.toString(volunteer.getLatitude()), Double.toString(volunteer.getLongitude()));
            for (int index = 0; index < incoming.size(); index++) {

                if (incoming.get(index) != null && 
                incoming.get(index).equals(volunteerInfo.get(index))) filtered.add(volunteer); 

            }
        }

        return filtered;

    }
    
}
