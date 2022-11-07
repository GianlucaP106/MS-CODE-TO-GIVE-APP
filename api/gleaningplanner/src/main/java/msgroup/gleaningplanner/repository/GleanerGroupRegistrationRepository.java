package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.GleanerGroup;
import msgroup.gleaningplanner.model.GleanerGroupRegistration;

@Repository
public interface GleanerGroupRegistrationRepository extends CrudRepository<GleanerGroupRegistration, Integer>
{
    public GleanerGroupRegistration findGleanerGroupRegistrationByID(int ID);

    public List<GleanerGroupRegistration> findAllGleanerGroupRegistrationByGleanerGroup(GleanerGroup gleanerGroup);

    public List<GleanerGroupRegistration> findAllGleanerGroupRegistrationByEvent(Event event);
}
