package msgroup.gleaningplanner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.GleanerGroupRegistration;

@Repository
public interface GleanerGroupRegistrationRepository extends CrudRepository<GleanerGroupRegistration, Integer>
{
    GleanerGroupRegistration findGleanerGroupRegistrationByID(int ID);
}
