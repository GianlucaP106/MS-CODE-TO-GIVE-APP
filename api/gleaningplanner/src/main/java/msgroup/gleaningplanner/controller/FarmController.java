package msgroup.gleaningplanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.FarmTO;
import msgroup.gleaningplanner.controller.TransferObject.FarmTO.FarmObjectDTO;
import msgroup.gleaningplanner.model.Farm;
import msgroup.gleaningplanner.repository.FarmRepository;
import msgroup.gleaningplanner.repository.ProducerRepository;
import msgroup.gleaningplanner.service.FarmService;

@RestController
public class FarmController {

    private FarmService farmService;
    private FarmRepository farmRepository; 
    private ProducerRepository producerRepository;
    
    public FarmController(FarmService farmService, FarmRepository farmRepository, ProducerRepository producerRepository){
        this.farmService = farmService;
        this.farmRepository = farmRepository;
        this.producerRepository = producerRepository;
    }

    @PostMapping("/farm/producer-create-farm")
    public ResponseEntity<FarmTO> createFarm(@RequestBody FarmTO incoming){
        Farm newFarm = farmService.createFarm(incoming);
        FarmTO out = new FarmTO(
            newFarm.getProducer().getID(),
            new FarmObjectDTO(newFarm.getID(), newFarm.getFarmName(), newFarm.getAddress(), newFarm.getPostalCode(), newFarm.getCity(), newFarm.getLongitude(), newFarm.getLatitude(), newFarm.getSurfaceArea()),
            null
        );
        return new ResponseEntity<FarmTO>(out, HttpStatus.OK);
    }

}
