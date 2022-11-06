package msgroup.gleaningplanner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.FarmFIlters;
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
    
    public FarmController(FarmService farmService, FarmRepository farmRepository, ProducerRepository producerRepository){
        this.farmService = farmService;
        this.farmRepository = farmRepository;
    }

    @PostMapping("/farm/producer-create-farm")
    public ResponseEntity<FarmTO> createFarm(@RequestBody FarmTO incoming){
        Farm newFarm = farmService.createFarm(
            incoming.producerID,
            incoming.farm.name,
            incoming.farm.surfaceArea,
            incoming.farm.city,
            incoming.farm.address,
            incoming.farm.postalCode
        );
        FarmTO out = new FarmTO(
            newFarm.getProducer().getID(),
            new FarmObjectDTO(newFarm.getID(), newFarm.getFarmName(), newFarm.getAddress(), newFarm.getPostalCode(), newFarm.getCity(), newFarm.getLongitude(), newFarm.getLatitude(), newFarm.getSurfaceArea())
        );
        return new ResponseEntity<FarmTO>(out, HttpStatus.OK);
    }

    @PostMapping("/farm/get-by-filter")
    public ResponseEntity<FarmFIlters> getFarmByFilter(@RequestBody FarmObjectDTO incoming){
        Set<Farm> filteredFarms = farmService.filterFarm(
            incoming.ID,
            incoming.name,
            incoming.address,
            incoming.postalCode,
            incoming.city,
            incoming.radius,
            incoming.surfaceArea
        );

        if(filteredFarms.size() <= 0) {
            return new ResponseEntity<FarmFIlters>(new FarmFIlters(), HttpStatus.NO_CONTENT);
        }
       
        List<FarmObjectDTO> farmTO_list = new ArrayList<FarmObjectDTO>();

        for(Farm farm : filteredFarms){
            if(farm != null){
                FarmObjectDTO farmDTO = new FarmObjectDTO(
                    farm.getID(),
                    farm.getFarmName(),
                    farm.getAddress(),
                    farm.getPostalCode(),
                    farm.getCity(),
                    farm.getLongitude(),
                    farm.getLatitude(),
                    farm.getSurfaceArea()
                );
                farmTO_list.add(farmDTO);
            }
        }

        FarmFIlters out = new FarmFIlters();
        out.farm = farmTO_list;

        return new ResponseEntity<FarmFIlters>(out , HttpStatus.OK);
    }

    @GetMapping("/farm/all")
    public List<FarmTO> getAllEvents() {
        List<FarmTO> farms = new ArrayList<FarmTO>();

        for(Farm farm : farmRepository.findAll()){
            farms.add(new FarmTO(
            farm.getProducer().getID(),
            new FarmObjectDTO(
                farm.getID(),
                farm.getFarmName(), 
                farm.getAddress(), 
                farm.getPostalCode(), 
                farm.getCity(), 
                farm.getLongitude(), 
                farm.getLatitude(), 
                farm.getSurfaceArea()
            )));
        }

        return farms;
    }

}
