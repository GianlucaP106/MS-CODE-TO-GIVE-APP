package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.model.Produce;
import msgroup.gleaningplanner.model.ProduceType;

@Repository
public interface ProduceRepository extends CrudRepository<Produce, Integer> {
    
    public Produce findProduceByID(int ID);

    public List<Produce> findAllProduceByProduceType(ProduceType produceType);

    public List<Produce> findAllProduceByAmount(double amount);

    public List<Produce> findAllProduceByEvent(Event event);

    public List<Produce> findAllProduceByOrganization(Organization organization);
}
