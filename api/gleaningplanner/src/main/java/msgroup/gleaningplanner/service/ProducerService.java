package msgroup.gleaningplanner.service;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.model.Producer;
import msgroup.gleaningplanner.repository.ProducerRepository;

@Service
public class ProducerService {
    
    private ProducerRepository producerRepository;

    public ProducerService(ProducerRepository producerRepository){
        this.producerRepository = producerRepository;
    }
    public Producer createProducer(String firstName,
    String lastName,
    String email,
    String username,
    String password,
    String phoneNumber){
        Producer newProducer = new Producer();
        newProducer.setEmail(email);
        newProducer.setFirstName(firstName);
        newProducer.setLastName(lastName);
        newProducer.setPassword(password);
        newProducer.setPhoneNumber(phoneNumber);
        newProducer.setUsername(username);

        return producerRepository.save(newProducer);
    }
}
