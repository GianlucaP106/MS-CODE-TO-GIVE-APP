
package msgroup.gleaningplanner.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.service.ProducerService;
import msgroup.gleaningplanner.controller.TransferObject.ProducerTO;
import msgroup.gleaningplanner.model.Producer;

@RestController

public class ProducerController {
    private ProducerService producerService;

    public ProducerController(ProducerService producerService){
        this.producerService = producerService;
    }

    @PostMapping("/producer/register")
    public void createProducer(@RequestBody ProducerTO incoming){
        Producer newProducer = producerService.createProducer(incoming.firstName, incoming.lastName, incoming.email, incoming.username, incoming.password, incoming.phoneNumber);
        return;
    }
}
