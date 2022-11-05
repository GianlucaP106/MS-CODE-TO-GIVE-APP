package msgroup.gleaningplanner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRegistration extends CrudRepository<OrganizationRegistration, Integer>{
    
    public OrganizationRegistration findOrganizationRegistrationByID(int ID);
}