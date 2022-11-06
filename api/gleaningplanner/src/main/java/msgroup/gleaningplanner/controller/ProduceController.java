package msgroup.gleaningplanner.controller;

import msgroup.gleaningplanner.model.Produce;
import msgroup.gleaningplanner.model.Produce.CropType;
import msgroup.gleaningplanner.service.ProduceService;
import msgroup.gleaningplanner.service.ProducerService;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {
    
    private ProduceService produceService;

    public ProduceController (ProduceService produceService){
        this.produceService = produceService;
    }

    @PostMapping("/produce/get-event")
    public ResponseEntity<Set<Integer>> getEventByCropType(@RequestBody String cropType){

        CropType type = CropType.Apples;
        for (CropType crop : CropType.values()) {
            if (crop.toString().equals(cropType)) {
                type = crop;
                break;
            }
        }

        var eventList = produceService.getEventByCrop(type);

        return new ResponseEntity<Set<Integer>> (eventList, HttpStatus.OK);
    }

    @PostMapping("/produce/get-organizationRegistration")
    public ResponseEntity<Set<Integer>> getOrganizationRegistrationByCropType(@RequestBody String cropType){

        CropType type = CropType.Apples;
        for (CropType crop : CropType.values()) {
            if (crop.toString().equals(cropType)) {
                type = crop;
                break;
            }
        }

        var organizationRegistrationList = produceService.getOrganizationRegistrationByCrop(type);

        return new ResponseEntity<Set<Integer>> (organizationRegistrationList, HttpStatus.OK);
    }
}
