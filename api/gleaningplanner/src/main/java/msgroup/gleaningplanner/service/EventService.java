package msgroup.gleaningplanner.service;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Set<Event> filterEvents(
        Integer ID,
        Integer farmId,
        String eventName,
        Integer neededGleaners,
        String description,
        Boolean isUrgent,
        String date,
        Integer maxGleaners
    ) {

        Set<Event> filtered = new HashSet<Event>();

        if (ID != null && ID > 0) {
            filtered.add(eventRepository.findEventByID(ID));
            return filtered;
        }
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String strDate = null;
        if (date != null) {
            strDate = dateFormat.format(date);
        }
        
        List<String> incoming = Arrays.asList(Integer.toString(farmId), eventName, Integer.toString(neededGleaners), description, Boolean.toString(isUrgent), strDate, Integer.toString(maxGleaners));
        List<String> eventInfo;

        for (Event event : eventRepository.findAll()) {
            eventInfo = Arrays.asList(Integer.toString(event.getFarm().getID()), event.getEventName(), Integer.toString(event.getRequiredGleaners()), event.getDescription(), Boolean.toString(event.isUrgent()), dateFormat.format(event.getDate()), Integer.toString(event.getMaxGleaners()));
            boolean valid = true;
            for (int index = 0; index < incoming.size(); index++) {

                if (incoming.get(index) != null && !incoming.get(index).equals(eventInfo.get(index))) {
                    valid = false;
                }    
            }
            if (valid) filtered.add(event);
        }

        return filtered;
    }
}
