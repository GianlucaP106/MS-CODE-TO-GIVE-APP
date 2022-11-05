package msgroup.gleaningplanner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.ProduceType;

@Repository
public interface ProduceTypeRepository extends CrudRepository<ProduceType, Integer> {
    
    ProduceType findProduceTypeByID(int ID);
}
