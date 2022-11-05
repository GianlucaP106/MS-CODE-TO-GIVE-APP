package msgroup.gleaningplanner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.OrganizationRegistration;

@Repository
public interface OrganizationRegistrationRepository extends CrudRepository<OrganizationRegistration, Integer>{
    
    public OrganizationRegistration findOrganizationRegistrationByID(int ID);
}
