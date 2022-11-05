package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Farm;
import msgroup.gleaningplanner.model.Producer;

@Repository
public interface FarmRepository extends CrudRepository<Farm, Integer>{
    
    public Farm findFarmByID(int ID);

    public List<Farm> findAllFarmByFarmName(String farmName);

    public List<Farm> findAllFarmByProducer(Producer producer);
}
