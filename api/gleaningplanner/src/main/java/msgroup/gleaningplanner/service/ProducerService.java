package msgroup.gleaningplanner.service;

import javax.tools.DocumentationTool.Location;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.model.Producer;
import msgroup.gleaningplanner.repository.ProducerRepository;

@Service
public class ProducerService {
    
    private ProducerRepository producerRepository;
    
    private LocationService locationService;

    public ProducerService(ProducerRepository producerRepository, LocationService locationService) {
        this.locationService = locationService;
        this.producerRepository = producerRepository;
    }

    public Producer createProducer(String firstName,
    String lastName,
    String email,
    String username,
    String password,
    String phoneNumber,
    String address,
    String postalCode,
    String city){

        Producer newProducer = new Producer();
        newProducer.setEmail(email);
        newProducer.setFirstName(firstName);
        newProducer.setLastName(lastName);
        newProducer.setPassword(password);
        newProducer.setPhoneNumber(phoneNumber);

        LocationAPITO location =
                locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();

        newProducer.setUsername(username);
        newProducer.setLatitude(location.data.get(0).latitude);
        newProducer.setLongitude(location.data.get(0).longitude);
        newProducer.setAddress(address);
        newProducer.setCity(city);
        newProducer.setPostalCode(postalCode);

        return producerRepository.save(newProducer);
    }
}
