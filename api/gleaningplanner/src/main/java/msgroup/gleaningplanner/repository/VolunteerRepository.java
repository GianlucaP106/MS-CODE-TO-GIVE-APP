package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Volunteer;

@Repository
public interface VolunteerRepository extends CrudRepository<Volunteer, Integer> {
    public Volunteer findVolunteerByID(int ID);

}
