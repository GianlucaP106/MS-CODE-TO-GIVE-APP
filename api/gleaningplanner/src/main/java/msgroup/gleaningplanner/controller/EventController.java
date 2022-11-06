package msgroup.gleaningplanner.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.EventTO;
import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.repository.EventRepository;
import msgroup.gleaningplanner.service.EventService;

@RestController
public class EventController {
    
    private EventService eventService;
    private EventRepository eventRepository;

    public EventController(EventService eventService, EventRepository eventRepository) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
    }

    @PostMapping("/event/create")
    public ResponseEntity<EventTO> createEvent(@RequestBody EventTO incoming) {
        Event newEvent = eventService.createEvent(
            incoming.eventName,
            incoming.neededGleaners,
            incoming.maxGleaners,
            incoming.description, 
            incoming.isUrgent,
            incoming.farmId,
            Date.valueOf(incoming.date)
        );

        if (newEvent != null) {
            return new ResponseEntity<EventTO>(
                new EventTO(
                    newEvent.getID(),
                    newEvent.getEventName(),
                    newEvent.getRequiredGleaners(),
                    newEvent.getMaxGleaners(),
                    newEvent.getDescription(),
                    newEvent.isUrgent(),
                    newEvent.getDate().toString()
                ), HttpStatus.OK);   
        }

        return new ResponseEntity<EventTO>(new EventTO(), HttpStatus.BAD_REQUEST);
    }


    @GetMapping("event/all")
    public List<EventTO> getAllEvents() {
        List<EventTO> events = new ArrayList<EventTO>();

        for(Event event : eventRepository.findAll()){
            events.add(new EventTO(
                event.getID(),
                event.getEventName(),
                event.getRequiredGleaners(),
                event.getMaxGleaners(),
                event.getDescription(),
                event.isUrgent(),
                event.getDate().toString()
            ));
        }

        return events;
    }

}
