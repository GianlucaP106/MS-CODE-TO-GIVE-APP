package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Producer;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Integer>{
    
    public Producer findProducerByID(int ID);

    public List<Producer> findAllProducerByFirstName(String firstName);

    public List<Producer> findAllProducerByLastName(String lastName);

    public Producer findProducerByEmail(String email);

    public Producer findProducerByPhoneNumber(String phoneNumber);

    public Producer findProducerByUsername(String username);
}
