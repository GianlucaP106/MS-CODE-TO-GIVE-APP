package msgroup.gleaningplanner.controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.EventFilterTO;
import msgroup.gleaningplanner.controller.TransferObject.EventTO;
import msgroup.gleaningplanner.controller.TransferObject.EventTeamTO;
import msgroup.gleaningplanner.controller.TransferObject.UserTypeTO;
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
    public ResponseEntity<EventTO> createEvent(@RequestBody EventTO incoming) throws ParseException {
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter1.parse(incoming.date);

        Event newEvent = eventService.createEvent(
            incoming.name,
            incoming.neededGleaners,
            incoming.maxGleaners,
            incoming.description, 
            incoming.isUrgent,
            incoming.farmId,
            date
        );

        if (newEvent != null) {
            return new ResponseEntity<EventTO>(
                new EventTO(
                    newEvent.getID(),
                    newEvent.getFarm().getID(),
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
    public List<EventTO> getAllEventTOs() {
        List<EventTO> events = new ArrayList<EventTO>();
        for(Event event : eventRepository.findAll()){
            events.add(new EventTO(
                event.getID(),
                event.getFarm().getID(),
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


    @GetMapping("/event/all/withfarm")
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<Event>();
        for (Event event : eventRepository.findAll()) {
            events.add(event);
        }
        return events;
    }

    @PostMapping("/event/get-by-filter")
    public ResponseEntity<EventFilterTO> getEventbyFilter(@RequestBody EventTO incoming) {
                
        Set<Event> filteredEvents = this.eventService.filterEvents(
            incoming.ID,
            incoming.farmId,
            incoming.name,
            incoming.neededGleaners,
            incoming.description,
            incoming.isUrgent,
            incoming.date,
            incoming.maxGleaners
        );

        List<EventTO> eventTOs = new ArrayList<EventTO>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        for (Event event : filteredEvents) {
            if (event != null) {
                EventTO to = new EventTO(
                    event.getID(),
                    event.getFarm().getID(),
                    event.getEventName(),
                    event.getRequiredGleaners(),
                    event.getMaxGleaners(),
                    event.getDescription(),
                    event.isUrgent(),
                    dateFormat.format(event.getDate())
                );
                
                eventTOs.add(to);
            }

        }
        
        return new ResponseEntity<EventFilterTO>(new EventFilterTO(eventTOs), HttpStatus.OK);
    }

    @PostMapping("/event/get-event-by-user")
    public ResponseEntity<EventFilterTO> getEventByUser(@RequestBody UserTypeTO userType) {
        System.out.println(userType.getID());
        System.out.println(userType.getUserType());
        List<Event> events = eventService.getEventByUser(userType.getID(), userType.getUserType());
        List<EventTO> eventTOs = new ArrayList<>();
        for (Event event : events) {
            eventTOs.add(new EventTO(
                event.getID(),
                event.getFarm().getID(),
                event.getEventName(),
                event.getRequiredGleaners(),
                event.getMaxGleaners(),
                event.getDescription(),
                event.isUrgent(),
                event.getDate().toString()
            ));
        }
        return new ResponseEntity<EventFilterTO>(
            new EventFilterTO(eventTOs),
            HttpStatus.OK
        );

    }


    @PostMapping("/event/detail-event-info")
    public ResponseEntity<EventTeamTO> getTeams(@RequestBody EventTO incoming){
       EventTeamTO out = eventService.getEventInfo(incoming.ID);
       return new ResponseEntity<EventTeamTO>(out, HttpStatus.OK);
    }

}
