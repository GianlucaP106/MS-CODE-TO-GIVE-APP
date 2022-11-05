package msgroup.gleaningplanner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.VolunteerRegistration;

@Repository
public interface VolunteerRegistrationRepository extends CrudRepository<VolunteerRegistration, Integer>{
    
    public VolunteerRegistration findVolunteerRegistrationByID(int ID);
}
