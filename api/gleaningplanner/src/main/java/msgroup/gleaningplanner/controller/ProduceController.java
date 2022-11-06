package msgroup.gleaningplanner.controller;

import msgroup.gleaningplanner.service.ProduceService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {
    
    private ProduceService ProduceService;

    public ProduceController (ProduceService ProduceService){
        this.ProduceService = ProduceService;
    }
    
}
