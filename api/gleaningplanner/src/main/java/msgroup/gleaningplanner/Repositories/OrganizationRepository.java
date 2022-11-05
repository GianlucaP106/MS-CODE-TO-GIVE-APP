package msgroup.gleaningplanner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Integer>{
    
    Organization findOrganizationByID(int ID);
}
