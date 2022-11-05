package msgroup.gleaningplanner.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.controller.TransferObject.VolunteerRegistrationTO.RegistrationRequest;
import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Volunteer;
import msgroup.gleaningplanner.model.VolunteerRegistration;
import msgroup.gleaningplanner.repository.EventRepository;
import msgroup.gleaningplanner.repository.VolunteerRegistrationRepository;
import msgroup.gleaningplanner.repository.VolunteerRepository;

@Service
public class VolunteerService {

    private VolunteerRepository volunteerRepository;
    private VolunteerRegistrationRepository volunteerRegistrationRepository;
    private LocationService locationService;
    private EventRepository eventrRepository;

    public VolunteerService(VolunteerRepository volunteerRepository, LocationService locationService, 
                            EventRepository eventrRepository, VolunteerRegistrationRepository volunteerRegistrationRepository) {

        this.volunteerRepository = volunteerRepository;
        this.locationService = locationService;
        this.eventrRepository = eventrRepository;
        this.volunteerRegistrationRepository = volunteerRegistrationRepository;
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
    Integer ID ,
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

        if (ID != null && ID != 0 && ID > 0) {
            filtered.add(volunteerRepository.findVolunteerByID(ID));
            return filtered;
        }
        
        if (username != null) {
            filtered.add(volunteerRepository.findVolunteerByUsername(username));
            return filtered;
        }
        String latitude = null;
        String longitude = null;
        if (address != null && postalCode != null && city != null) {
            LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();
            latitude = Double.toString(location.data.get(0).latitude);
            longitude = Double.toString(location.data.get(0).longitude);
        }



        List<String> incoming = Arrays.asList(firstName, lastName, email, phoneNumber, latitude , longitude, address, city, postalCode);
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

    public VolunteerRegistration registerToEvent(RegistrationRequest incoming){
        Volunteer volunteer = volunteerRepository.findVolunteerByID(incoming.volunteerID);
        Event event = eventrRepository.findEventByID(incoming.evemtID);

        VolunteerRegistration newRegistration = new VolunteerRegistration();
        newRegistration.setVolunteer(volunteer);
        newRegistration.setEvent(event);
        newRegistration.setVolunteerGroupAccepted(false); 
        newRegistration.setEventAccepted(false);
        newRegistration.setOwner(false);
        newRegistration.setVolunteerGroupNumber(0);

        volunteerRegistrationRepository.save(newRegistration);
        return newRegistration;
    }
}
