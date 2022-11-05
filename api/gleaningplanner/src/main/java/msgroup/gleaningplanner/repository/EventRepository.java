package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    
    public Event findEventByID(int ID);

    public List<Event> findAllEventByEventName(String eventName);

    public List<Event> findAllEventByRequiredGleaners(int requiredGleaners);

    public List<Event> findAllEventByMaxGleaners(int maxGleaners);

    public List<Event> findAllEventByIsUrgentTrue();
}
