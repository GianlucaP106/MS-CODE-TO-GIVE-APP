package msgroup.gleaningplanner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.GleanerGroup;

@Repository
public interface GleanerGroupRepository extends CrudRepository<GleanerGroup, Integer>{
    
    GleanerGroup findGleanerGroupByID(int ID);
}
