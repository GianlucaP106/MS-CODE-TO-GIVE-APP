package msgroup.gleaningplanner.service;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Farm;
import msgroup.gleaningplanner.model.GleanerGroupRegistration;
import msgroup.gleaningplanner.model.OrganizationRegistration;
import msgroup.gleaningplanner.model.User;
import msgroup.gleaningplanner.model.VolunteerRegistration;
import msgroup.gleaningplanner.repository.EventRepository;
import msgroup.gleaningplanner.repository.FarmRepository;
import msgroup.gleaningplanner.repository.GleanerGroupRegistrationRepository;
import msgroup.gleaningplanner.repository.OrganizationRegistrationRepository;
import msgroup.gleaningplanner.repository.ProducerRepository;
import msgroup.gleaningplanner.repository.VolunteerRegistrationRepository;

@Service
public class EventService {
    
    private EventRepository eventRepository;
    private FarmRepository farmRepository;
    private ProducerRepository producerRepository;
    private VolunteerRegistrationRepository volunteerRegistrationRepository;
    private OrganizationRegistrationRepository organizationRegistrationRepository;
    private GleanerGroupRegistrationRepository gleanerGroupRegistrationRepository;

    public EventService(
        EventRepository eventRepository, 
        FarmRepository farmRepository,
        ProducerRepository producerRepository,
        VolunteerRegistrationRepository volunteerRegistrationRepository,
        OrganizationRegistrationRepository organizationRegistrationRepository,
        GleanerGroupRegistrationRepository gleanerGroupRegistrationRepository
    ) {
        this.eventRepository = eventRepository;
        this.farmRepository = farmRepository;
        this.producerRepository = producerRepository;
        this.volunteerRegistrationRepository = volunteerRegistrationRepository;
        this.organizationRegistrationRepository = organizationRegistrationRepository;
        this.gleanerGroupRegistrationRepository = gleanerGroupRegistrationRepository;
    }

    public Event createEvent(
        String eventName,
        int requiredGleaners,
        int maxGleaners,
        String description,
        boolean isUrgent,
        int farmID,
        Date date
    ) {
        Event event = new Event();
        Farm associatiedFarm = farmRepository.findFarmByID(farmID);
        if (associatiedFarm == null) return null;

        event.setFarm(associatiedFarm);
        event.setDate(date);
        event.setDescription(description);
        event.setMaxGleaners(maxGleaners);
        event.setRequiredGleaners(requiredGleaners);
        event.setUrgent(isUrgent);
        event.setEventName(eventName);

        return eventRepository.save(event);
        

    }

    public Set<Event> filterEvents(
        Integer ID,
        Integer farmId,
        String eventName,
        Integer neededGleaners,
        String description,
        Boolean isUrgent,
        String date,
        Integer maxGleaners
    ) {

        Set<Event> filtered = new HashSet<Event>();

        if (ID != null && ID > 0) {
            filtered.add(eventRepository.findEventByID(ID));
            return filtered;
        }
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        String strDate = null;
        if (date != null) {
            strDate = dateFormat.format(date);
        }
        
        List<String> incoming = Arrays.asList(Integer.toString(farmId), eventName, Integer.toString(neededGleaners), description, Boolean.toString(isUrgent), strDate, Integer.toString(maxGleaners));
        List<String> eventInfo;

        for (Event event : eventRepository.findAll()) {
            eventInfo = Arrays.asList(Integer.toString(event.getFarm().getID()), event.getEventName(), Integer.toString(event.getRequiredGleaners()), event.getDescription(), Boolean.toString(event.isUrgent()), dateFormat.format(event.getDate()), Integer.toString(event.getMaxGleaners()));
            boolean valid = true;
            for (int index = 0; index < incoming.size(); index++) {

                if (incoming.get(index) != null && !incoming.get(index).equals(eventInfo.get(index))) {
                    valid = false;
                }    
            }
            if (valid) filtered.add(event);
        }

        return filtered;
    }

    public List<Event> getEventByUser(int id, String userType) {
        List<Event> events = new ArrayList<Event>();

        for (Event event : eventRepository.findAll()) {

            if (userType.equals("producer")) {

                if (event.getFarm().getProducer().getID() == id) {
                    events.add(event);
                }

            }else if (userType.equals("volunteer")) {

                for (VolunteerRegistration reg : volunteerRegistrationRepository
                    .findAllVolunteerRegistrationByEvent(event)) {
                        if (reg.getVolunteer().getID() == id) {
                            events.add(event);
                        }
                }

            }else if (userType.equals("organization")) {

                for (OrganizationRegistration reg : organizationRegistrationRepository
                    .findAllOrganizationRegistrationByEvent(event)) {
                        if (reg.getOrganization().getID() == id) {
                            events.add(event);
                        }
                }
            }else {

                for (GleanerGroupRegistration reg : gleanerGroupRegistrationRepository.findAll()) {
                    if (reg.getEvent().equals(event) && reg.getGleanerGroup().getID() == id) {
                        events.add(event);
                    }
                }
            }
        }
        return events;

    }
}
