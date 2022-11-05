package msgroup.gleaningplanner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Produce;

@Repository
public interface ProduceRepository extends CrudRepository<Produce, Integer> {
    
    public Produce findProduceByID(int ID);
}
