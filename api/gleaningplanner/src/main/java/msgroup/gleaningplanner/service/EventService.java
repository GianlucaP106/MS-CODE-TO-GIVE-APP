package msgroup.gleaningplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.repository.EventRepository;

@Service
public class EventService {
    
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
}
