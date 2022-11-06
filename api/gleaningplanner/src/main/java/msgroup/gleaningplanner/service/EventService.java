package msgroup.gleaningplanner.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Farm;
import msgroup.gleaningplanner.repository.EventRepository;
import msgroup.gleaningplanner.repository.FarmRepository;

@Service
public class EventService {
    
    private EventRepository eventRepository;
    private FarmRepository farmRepository;

    public EventService(EventRepository eventRepository, FarmRepository farmRepository) {
        this.eventRepository = eventRepository;
        this.farmRepository = farmRepository;
    }

    public Event createEvent(
        String eventName,
        int requiredGleaners,
        int maxGleaners,
        String description,
        boolean isUrgent,
        int farmID,
        Date date
    ) {
        Event event = new Event();
        Farm associatiedFarm = farmRepository.findFarmByID(farmID);
        if (associatiedFarm == null) return null;

        event.setFarm(associatiedFarm);
        event.setDate(date);
        event.setDescription(description);
        event.setMaxGleaners(maxGleaners);
        event.setRequiredGleaners(requiredGleaners);
        event.setUrgent(isUrgent);
        event.setEventName(eventName);

        return eventRepository.save(event);
        

    }


}
