package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Farm;
import msgroup.gleaningplanner.model.GleanerGroup;
import msgroup.gleaningplanner.model.Image;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.model.Producer;
import msgroup.gleaningplanner.model.Volunteer;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer>{
    
    public Image findImageByID(int ID);

    public List<Image> findAllImageByVolunteer(Volunteer volunteer);

    public List<Image> findAllImageByOrganization(Organization organization);

    public List<Image> findAllImageByGleanerGroup(GleanerGroup gleaningGroup);

    public List<Image> findAllImageByProducer(Producer producer);

    public List<Image> findAllImageByFarm(Farm farm);
}
