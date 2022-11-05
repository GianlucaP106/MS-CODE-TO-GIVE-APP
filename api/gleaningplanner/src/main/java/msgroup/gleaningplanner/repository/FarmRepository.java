package msgroup.gleaningplanner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Farm;

@Repository
public interface FarmRepository extends CrudRepository<Farm, Integer>{
    
    Farm findFarmByID(int ID);
}
