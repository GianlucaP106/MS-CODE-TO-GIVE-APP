package msgroup.gleaningplanner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.GleanerGroupRegistration;

@Repository
public interface GleanerGroupRegistrationRepository extends CrudRepository<GleanerGroupRegistration, Integer>
{
    public GleanerGroupRegistration findGleanerGroupRegistrationByID(int ID);
}
