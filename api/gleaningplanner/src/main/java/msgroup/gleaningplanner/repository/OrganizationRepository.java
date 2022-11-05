package msgroup.gleaningplanner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Integer>{
    
    public Organization findOrganizationByID(int ID);
}
