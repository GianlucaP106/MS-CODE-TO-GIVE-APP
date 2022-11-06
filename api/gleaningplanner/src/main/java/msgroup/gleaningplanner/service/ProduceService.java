package msgroup.gleaningplanner.service;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.repository.ProduceRepository;

@Service
public class ProduceService {
    
    private ProduceRepository produceRepository;

    // look for organization
        // -> produce -> organizationRegistration -> organization -> id 
        // get all produce by crop type
        // go through all produce that have org registration 
        // get org id
        // Set<Integer> ordReg 

    // look for event
        // get all produce by crop type
        //Ex: all produce with X as crop type
        // go through all produce that have event
        // get event id
        // Set<Integer> eventID from ^ produce
}
