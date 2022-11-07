package msgroup.gleaningplanner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.AcceptenceTO;
import msgroup.gleaningplanner.controller.TransferObject.CommentTO;
import msgroup.gleaningplanner.controller.TransferObject.ProduceTO;
import msgroup.gleaningplanner.controller.TransferObject.ProducerFilterTO;
import msgroup.gleaningplanner.controller.TransferObject.ProducerTO;
import msgroup.gleaningplanner.controller.TransferObject.UserTypeTO;
import msgroup.gleaningplanner.controller.TransferObject.VolunteerTO;
import msgroup.gleaningplanner.controller.TransferObject.ProducerTO.signInRequestProducer;
import msgroup.gleaningplanner.model.Comment;
import msgroup.gleaningplanner.model.Produce;
import msgroup.gleaningplanner.model.Producer;
import msgroup.gleaningplanner.model.Volunteer;
import msgroup.gleaningplanner.repository.ProducerRepository;
import msgroup.gleaningplanner.service.ProducerService;

@RestController
public class ProducerController {
    private ProducerService producerService;
    private ProducerRepository producerRepository;

    public ProducerController(
        ProducerService producerService, 
        ProducerRepository producerRepository
    ) {
        this.producerService = producerService;
        this.producerRepository = producerRepository;
    }

    @PostMapping("/producer/register")
    public ResponseEntity<ProducerTO> createProducer(@RequestBody ProducerTO incoming){
        Producer newProducer = producerService.createProducer(incoming.firstName, incoming.lastName, incoming.email, 
            incoming.username, incoming.password, incoming.phoneNumber, incoming.address, incoming.postalCode, incoming.city);

        ProducerTO out = new ProducerTO(
            newProducer.getID(),
            newProducer.getUsername(), 
            newProducer.getFirstName(), 
            newProducer.getLastName(), 
            newProducer.getEmail(), 
            newProducer.getPhoneNumber(), 
            null, 
            newProducer.getCity(),
            newProducer.getAddress(), 
            newProducer.getPostalCode(), 
            newProducer.getLatitude(), 
            newProducer.getLongitude()
        );

        return new ResponseEntity<ProducerTO>(out, HttpStatus.OK);
    }

    @PostMapping("producer/sign-in")
    public ResponseEntity<ProducerTO> signIn(@RequestBody signInRequestProducer incoming) {
        Producer prod = producerService.verifySignIn(
            incoming.username,
            incoming.password
        );

        if(prod == null) return new ResponseEntity<ProducerTO>(new ProducerTO(), HttpStatus.BAD_REQUEST);

        ProducerTO out = new ProducerTO(
            prod.getID(),
            prod.getUsername(), 
            prod.getFirstName(), 
            prod.getLastName(), 
            prod.getEmail(), 
            prod.getPhoneNumber(), 
            null, 
            prod.getCity(),
            prod.getAddress(), 
            prod.getPostalCode(), 
            prod.getLatitude(), 
            prod.getLongitude()
        );
        
        return new ResponseEntity<ProducerTO>(out, HttpStatus.OK);                    
                                                    
    }
    

    @PutMapping("/producer/update")
    public ResponseEntity<ProducerTO> updateProducer(@RequestBody ProducerTO incoming) {

        Producer newProducer = producerService.updateProducer(  
            incoming.ID,
            incoming.firstName,
            incoming.lastName,
            incoming.email,
            incoming.username,
            incoming.password,
            incoming.phoneNumber,
            incoming.address,
            incoming.postalCode,
            incoming.city
        );
        ProducerTO out = new ProducerTO(
            newProducer.getID(),
            newProducer.getUsername(), 
            newProducer.getFirstName(), 
            newProducer.getLastName(), 
            newProducer.getEmail(), 
            newProducer.getPhoneNumber(), 
            null, 
            newProducer.getCity(),
            newProducer.getAddress(), 
            newProducer.getPostalCode(), 
            newProducer.getLatitude(), 
            newProducer.getLongitude()
        );
        
        return new ResponseEntity<ProducerTO>(out, HttpStatus.OK);                    
                                                    
    }

    @PostMapping("/producer/get-by-filter")
    public ResponseEntity<ProducerFilterTO> getProducerByFilter(@RequestBody ProducerTO incoming){
        Set<Producer> filteredProducers = this.producerService.filterProducers(
            incoming.ID,
            incoming.firstName,
            incoming.lastName,
            incoming.email,
            incoming.username,
            incoming.password,
            incoming.phoneNumber,
            incoming.address,
            incoming.postalCode,
            incoming.city
        );

        List<ProducerTO> producerTOs = new ArrayList<ProducerTO>();
        for (Producer producer : filteredProducers) {
            ProducerTO to = new ProducerTO(
                producer.getID(),
                producer.getFirstName(),
                producer.getLastName(),
                producer.getEmail(),
                producer.getUsername(),
                producer.getPhoneNumber(),
                null,
                producer.getCity(),
                producer.getAddress(),
                producer.getPostalCode(),
                producer.getLatitude(),
                producer.getLongitude()
            );
            producerTOs.add(to);
        }

        return new ResponseEntity<ProducerFilterTO>(new ProducerFilterTO(producerTOs), HttpStatus.OK);
    }


    @PostMapping("/producer/accept/volunteer-group")
    public ResponseEntity<AcceptenceTO> acceptVolunteerGroup(@RequestBody AcceptenceTO incoming) {
        List<Volunteer> accpetedVolunteers = producerService.acceptVolunteerGroup(
            incoming.getEventID(), 
            incoming.getGroupNumber()
        );

        List<VolunteerTO> out = new ArrayList<VolunteerTO>();
        for (Volunteer volunteer : accpetedVolunteers) {
            out.add(new VolunteerTO(
                volunteer.getID(), 
                volunteer.getUsername(), 
                volunteer.getFirstName(), 
                volunteer.getLastName(), 
                volunteer.getEmail(), 
                volunteer.getPhoneNumber(), 
                volunteer.getPostalCode(), 
                volunteer.getAddress(), 
                volunteer.getCity(), 
                volunteer.getLatitude(), 
                volunteer.getLongitude(), 
                null,
                volunteer.getParticipatedEvent()
            ));
        }

        return new ResponseEntity<AcceptenceTO>(
            new AcceptenceTO(
                incoming.getEventID(), 
                incoming.getGroupNumber(), 
                out
            ), 
            HttpStatus.OK
        );
    }

    @PostMapping("/producer/add-produce-to-event")
    public ResponseEntity<Produce> addProduceToEvent(
        @RequestBody ProduceTO incoming 
    ) {
        Produce newProduce = producerService.addProduceToEvent(
            incoming.eventID, 
            incoming.produceType, 
            incoming.amount
        );
        return new ResponseEntity<Produce>(
            newProduce, 
            HttpStatus.OK
        );
    }

    @GetMapping("/producer/all")
    public List<ProducerTO> getProducers(){
        List<ProducerTO> producers = new ArrayList<ProducerTO>();
        for(Producer producer : producerRepository.findAll()){
            producers.add(new ProducerTO(
                producer.getID(),
                producer.getFirstName(),
                producer.getLastName(),
                producer.getEmail(),
                producer.getUsername(),
                producer.getPhoneNumber(),
                null,
                producer.getAddress(),
                producer.getPostalCode(),
                producer.getCity(),
                producer.getLatitude(),
                producer.getLongitude()
            ));
        }
        return producers;
    }

    @PostMapping("/producer/comment-event/")
    public ResponseEntity<CommentTO> postCommentEvent(@RequestBody CommentTO incoming) {
        Comment comment = producerService.postCommentEvent(
            incoming.producerID,
            incoming.eventID,
            incoming.comment,
            incoming.authorType
        );

        CommentTO out = new CommentTO();
        out.setAuthorType(comment.getAuthorType().toString());
        out.setComment(comment.getComment());
        out.setOrganizationID(comment.getProducer().getID());
        out.setEventID(comment.getEvent().getID());

        return new ResponseEntity<CommentTO>(out, HttpStatus.OK);
    }

    @PostMapping("/producer/get-by-farm")
    public ResponseEntity<ProducerTO> getProducerByFarm(@RequestBody UserTypeTO id ) {
        Producer producer = producerService.getProducerByFarm(id.getID());
        return new ResponseEntity<ProducerTO>(
            new ProducerTO(
                producer.getID(),
                producer.getUsername(),
                producer.getFirstName(),
                producer.getLastName(),
                producer.getEmail(),
                producer.getPhoneNumber(),
                null,
                producer.getCity(),
                producer.getAddress(),
                producer.getPostalCode(),
                producer.getLatitude(),
                producer.getLongitude()
            ),
            HttpStatus.OK
        );
    }
}