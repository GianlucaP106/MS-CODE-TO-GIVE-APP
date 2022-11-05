package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Integer>{
    
    public Organization findOrganizationByID(int ID);

    public List<Organization> findAllOrganizationByOrganizationName(String organizationName);
    
    public List<Organization> findAllOrganizationByLongitude(long longitude);

    public List<Organization> findAllOrganizationByLatitude(long latitude);

    public List<Organization> findAllOrganizationByMaxDistance(int maxDistance);

    public Organization findOrganizationByUsername(String username);
}
