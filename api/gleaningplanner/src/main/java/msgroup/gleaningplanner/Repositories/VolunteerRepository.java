package msgroup.gleaningplanner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Volunteer;

@Repository
public interface VolunteerRepository extends CrudRepository<Volunteer, Integer>{
    
    Volunteer findVolunteerByID(int ID);
}
