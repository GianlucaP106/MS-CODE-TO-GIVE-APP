package msgroup.gleaningplanner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRegistration extends CrudRepository<VolunteerRegistration, Integer>{
    
    VolunteerRegistration findVolunteerRegistrationByID(int ID);
}
