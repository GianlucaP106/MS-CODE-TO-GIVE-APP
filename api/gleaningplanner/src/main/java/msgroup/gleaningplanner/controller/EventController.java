package msgroup.gleaningplanner.controller;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.EventTO;
import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.service.EventService;

@RestController
public class EventController {
    
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
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


}
