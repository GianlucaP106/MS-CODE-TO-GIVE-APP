package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.GleanerGroup;

@Repository
public interface GleanerGroupRepository extends CrudRepository<GleanerGroup, Integer>{
    
    public GleanerGroup findGleanerGroupByID(int ID);

    public List<GleanerGroup> findGleanerGroupByGroupName(String groupName);

    public List<GleanerGroup> findAllGleanerGroupByTotalMembers(int totalMembers);

    public List<GleanerGroup> findAllGleanerGroupByLongitude(long longitude);

    public List<GleanerGroup> findAllGleanerGroupByLatitude(long latitude);

    public List<GleanerGroup> findAllGleanerGroupByRegion(String region);

    public GleanerGroup findGleanerGroupByUsername(String username);
}
