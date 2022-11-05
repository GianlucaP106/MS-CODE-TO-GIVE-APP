package msgroup.gleaningplanner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    
    Event findEventByID(int ID);
}
