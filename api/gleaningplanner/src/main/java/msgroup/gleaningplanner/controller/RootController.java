package msgroup.gleaningplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.service.LocationService;

@RestController
@RequestMapping("/")
public class RootController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/")
    public String greeting() {
        return "how are u";
    }

    @GetMapping("/testloc")
    public ResponseEntity<LocationAPITO> getLoc(){
        return locationService.transformToLatitudeLongitude(null, "H8P 1C6", "Montreal"); 
    }
}
