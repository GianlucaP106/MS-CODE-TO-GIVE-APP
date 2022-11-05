package msgroup.gleaningplanner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Producer;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Integer>{
    
    public Producer findProducerByID(int ID);
}
