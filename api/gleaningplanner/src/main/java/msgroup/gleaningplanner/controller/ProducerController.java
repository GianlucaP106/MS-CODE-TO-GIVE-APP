
package msgroup.gleaningplanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import msgroup.gleaningplanner.controller.TransferObject.ProducerFilterTO;
import msgroup.gleaningplanner.controller.TransferObject.ProducerTO;
import msgroup.gleaningplanner.model.Producer;
import msgroup.gleaningplanner.service.ProducerService;

@RestController
public class ProducerController {
    private ProducerService producerService;

    public ProducerController(ProducerService producerService){
        this.producerService = producerService;
    }

    @PostMapping("/producer/register")
    public ResponseEntity<ProducerTO> createProducer(@RequestBody ProducerTO incoming){
        Producer newProducer = producerService.createProducer(incoming.firstName, incoming.lastName, incoming.email, incoming.username, incoming.password, incoming.phoneNumber);
        ProducerTO out = new ProducerTO(newProducer.getUsername(), newProducer.getFirstName(), newProducer.getLastName(), newProducer.getEmail(), newProducer.getPhoneNumber(), null);
        return new ResponseEntity<ProducerTO>(out, HttpStatus.OK);
    }
}


/*String username, String firstName,
String lastName, String email, String phoneNumber, 
String password*/