package msgroup.gleaningplanner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.model.Volunteer;
import msgroup.gleaningplanner.model.VolunteerRegistration;
import msgroup.gleaningplanner.repository.VolunteerRepository;

@Service
public class VolunteerService {

    private VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
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
            Volunteer volunteer = volunteerRepository.findVolunteerByID(ID);
            filtered.add(volunteer);
        }
        
        return filtered;


    }
    
}
