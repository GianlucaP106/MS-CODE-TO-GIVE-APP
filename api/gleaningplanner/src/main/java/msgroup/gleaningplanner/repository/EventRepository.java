package msgroup.gleaningplanner.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Farm;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    
    public Event findEventByID(int ID);

    public List<Event> findAllEventByEventName(String eventName);

    public List<Event> findAllEventByRequiredGleaners(int requiredGleaners);

    public List<Event> findAllEventByMaxGleaners(int maxGleaners);

    public List<Event> findAllEventByIsUrgentTrue();

    public List<Event> findAllEventByDate(Date date);

    public List<Event> findAllEventByFarm(Farm farm);
}
