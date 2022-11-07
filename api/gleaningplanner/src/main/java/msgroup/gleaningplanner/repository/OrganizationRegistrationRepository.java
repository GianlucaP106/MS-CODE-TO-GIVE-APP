package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.model.OrganizationRegistration;

@Repository
public interface OrganizationRegistrationRepository extends CrudRepository<OrganizationRegistration, Integer>{
    
    public OrganizationRegistration findOrganizationRegistrationByID(int ID);

    public List<OrganizationRegistration> findAllOrganizationRegistrationByOrganization(Organization organization);

    public List<OrganizationRegistration> findAllOrganizationRegistrationByEvent(Event event);

    public OrganizationRegistration findOrganizationRegistrationByEventAndOrganization(Event event, Organization organization);

}
