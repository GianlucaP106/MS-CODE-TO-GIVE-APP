package msgroup.gleaningplanner.service;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.controller.TransferObject.FarmTO;
import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.controller.TransferObject.FarmTO.FarmObjectDTO;
import msgroup.gleaningplanner.model.Farm;
import msgroup.gleaningplanner.model.Producer;
import msgroup.gleaningplanner.repository.FarmRepository;
import msgroup.gleaningplanner.repository.ProducerRepository;

@Service
public class FarmService {

    private FarmRepository farmRepository; 
    private ProducerRepository producerRepository;
    private LocationService locationService;

    public FarmService(LocationService locationService, FarmRepository farmRepository, ProducerRepository producerRepository){
        this.farmRepository = farmRepository;
        this.producerRepository = producerRepository;
        this.locationService = locationService;
    }

    public Farm createFarm(FarmTO incoming) {
        Producer producer = producerRepository.findProducerByID(incoming.producerID);
        if(producer == null) return null;

        FarmObjectDTO incomingFarm = incoming.farm;
        if(incomingFarm == null) return null;

        Farm newFarm = new Farm();
        newFarm.setProducer(producer);
        newFarm.setFarmName(incomingFarm.farmName);
        newFarm.setSurfaceArea(incomingFarm.surfaceArea);
        newFarm.setCity(incomingFarm.city);
        newFarm.setAddress(incomingFarm.address);
        newFarm.setAddress(incomingFarm.postalCode);

        LocationAPITO location = locationService.transformToLatitudeLongitude(newFarm.getAddress(), newFarm.getPostalCode(), newFarm.getCity()).getBody();
    
        newFarm.setLatitude(location.data.get(0).latitude);
        newFarm.setLongitude(location.data.get(0).longitude);

        return farmRepository.save(newFarm);
    }

}
