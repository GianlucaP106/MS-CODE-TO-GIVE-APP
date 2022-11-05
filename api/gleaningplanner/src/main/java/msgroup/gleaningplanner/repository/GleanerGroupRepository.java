package msgroup.gleaningplanner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.GleanerGroup;

@Repository
public interface GleanerGroupRepository extends CrudRepository<GleanerGroup, Integer>{
    
    public GleanerGroup findGleanerGroupByID(int ID);
}
