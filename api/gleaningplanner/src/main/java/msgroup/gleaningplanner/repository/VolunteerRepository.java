package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Volunteer;

@Repository
public interface VolunteerRepository extends CrudRepository<Volunteer, Integer> {
    public Volunteer findVolunteerByID(int ID);
    public Volunteer findVolunteerByUsername(String Username);

    public List<Volunteer> findAllVolunteerByFirstName(String firstName);

    public List<Volunteer> findAllVolunteerByLastName(String lastName);

    public Volunteer findVolunteerByEmail(String email);

    public Volunteer findVolunteerByPhoneNumber(String phoneNumber);

    public List<Volunteer> findAllVolunteerByLatitude(String latitude);

    public List<Volunteer> findAllVolunteerByLongitude(String longitude);
}
