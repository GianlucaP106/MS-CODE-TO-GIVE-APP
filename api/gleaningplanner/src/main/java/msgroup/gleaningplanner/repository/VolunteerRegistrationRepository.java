package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Volunteer;
import msgroup.gleaningplanner.model.VolunteerRegistration;

@Repository
public interface VolunteerRegistrationRepository extends CrudRepository<VolunteerRegistration, Integer>{
    
    public VolunteerRegistration findVolunteerRegistrationByID(int ID);

    public List<VolunteerRegistration> findAllVolunteerRegistrationByVolunteer(Volunteer volunteer);
    
    public List<VolunteerRegistration> findAllVolunteerRegistrationByVolunteerGroupNumber(int volunteerGroupNumber);

    public List<VolunteerRegistration> findAllVolunteerRegistrationByVolunteerGroupAcceptedTrue();

    public List<VolunteerRegistration> findAllVolunteerRegistrationByIsOwner(boolean value);

    public List<VolunteerRegistration> findAllVolunteerRegistrationByEventAccepted(boolean value);

    public List<VolunteerRegistration> findAllVolunteerRegistrationByEvent(Event event);

    public VolunteerRegistration findVolunteerRegistrationByEventAndVolunteer(Event event, Volunteer volunteer);

}
