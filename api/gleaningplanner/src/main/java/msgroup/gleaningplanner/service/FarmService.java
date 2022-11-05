package msgroup.gleaningplanner.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        newFarm.setPostalCode(incomingFarm.postalCode);

        LocationAPITO location = locationService.transformToLatitudeLongitude(newFarm.getAddress(), newFarm.getPostalCode(), newFarm.getCity()).getBody();
    
        newFarm.setLatitude(location.data.get(0).latitude);
        newFarm.setLongitude(location.data.get(0).longitude);

        return farmRepository.save(newFarm);
    }

    public Set<Farm> filterFarm(
        Integer id,
        String farmName,
        String address,
        String postalCode,
        String city,
        Double radius, 
        Double surface
    ){
        Set<Farm> filtered = new HashSet<Farm>();

        // use radius value if not null
        if(radius != null && address != null && postalCode != null && city != null){
            System.out.println("THIS HAPPENED");
            LocationAPITO location = locationService.transformToLatitudeLongitude(address, postalCode, city).getBody();
            for(Farm farm : farmRepository.findAll() ){
               double distance = 
                    locationService.distanceBetweenTwoPoints(
                        farm.getLatitude(), location.data.get(0).latitude,
                        farm.getLongitude(), location.data.get(0).longitude);
                
                System.out.println(distance);

                if(distance <= radius){
                    filtered.add(farm);
                }
            }

            return filtered;
        }

        if(id != null && id != 0){
            filtered.add(farmRepository.findFarmByID(id));
            return filtered;
        }

        List<String> incoming = 
            Arrays.asList(farmName, address, postalCode, city);

        List<String> farmInfo;

        for(Farm farm : farmRepository.findAll()){
            boolean valid = true;
            farmInfo = Arrays.asList(farm.getFarmName(), farm.getAddress(), farm.getPostalCode(), farm.getCity());
            for(int index = 0; index < incoming.size(); index++){
                String incomingData = incoming.get(index);

                System.out.println(farmInfo.get(index));
                System.out.println(incomingData);

                if(incomingData != null && !incomingData.equals(farmInfo.get(index))){
                    valid = false;
                }
            }

            if(valid) filtered.add(farm);
        }

        // use surface filter 
        if(surface != null) {
            for(Farm farm : filtered){
                if(farm.getSurfaceArea() < surface){
                    filtered.remove(farm);
                }
            }
        }

        return  filtered;
    }

}
