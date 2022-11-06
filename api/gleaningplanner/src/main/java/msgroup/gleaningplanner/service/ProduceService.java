package msgroup.gleaningplanner.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.model.Produce;
import msgroup.gleaningplanner.repository.EventRepository;
import msgroup.gleaningplanner.repository.OrganizationRegistrationRepository;
import msgroup.gleaningplanner.repository.ProduceRepository;

@Service
public class ProduceService {
    
    private ProduceRepository produceRepository;
    private EventRepository eventRepository;
    private OrganizationRegistrationRepository organizationRegistrationRepository;

    public ProduceService (
        ProduceRepository produceRepository,
        EventRepository eventRepository,
        OrganizationRegistrationRepository organizationRegistrationRepository
    ){
        this.produceRepository = produceRepository;
        this.eventRepository = eventRepository;
        this.organizationRegistrationRepository = organizationRegistrationRepository;
    }

    public Set<Integer> getOrganizationRegistrationByCrop(Produce.CropType cropType){
        Set<Integer> orgIDs = new HashSet<Integer>();
        var list_Produce = produceRepository.findAllProduceByCropType(cropType);
        for (var produceInList : list_Produce){
            if (produceInList.getOrganizationRegistration() != null){
                var orgReg = produceInList.getOrganizationRegistration();
                orgIDs.add(orgReg.getID());
            }
        }
        return orgIDs;
    }

    public Set<Integer> getEventByCrop(Produce.CropType cropType){
        Set<Integer> eventIDs = new HashSet<Integer>();
        var list_Produce = produceRepository.findAllProduceByCropType(cropType);
        for (var produceInList : list_Produce){
            if (produceInList.getEvent()!= null){
                var event = produceInList.getEvent();
                eventIDs.add(event.getID());
            }
        }
        return eventIDs;
    }

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
