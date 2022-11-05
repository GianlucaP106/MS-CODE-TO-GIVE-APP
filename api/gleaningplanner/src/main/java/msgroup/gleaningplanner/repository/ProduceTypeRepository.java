package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.ProduceType;

@Repository
public interface ProduceTypeRepository extends CrudRepository<ProduceType, Integer> {
    
    public ProduceType findProduceTypeByID(int ID);

    public List<ProduceType> findAllProduceTypeByName(String name);
}
