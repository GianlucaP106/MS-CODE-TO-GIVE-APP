package msgroup.gleaningplanner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer>{
    
    Image findImageByID(int ID);
}
