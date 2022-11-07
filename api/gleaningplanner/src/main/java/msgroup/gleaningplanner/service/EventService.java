package msgroup.gleaningplanner.service;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import msgroup.gleaningplanner.controller.TransferObject.EventTeamTO;
import msgroup.gleaningplanner.controller.TransferObject.EventTeamTO.EventTeam;
import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Farm;
import msgroup.gleaningplanner.model.GleanerGroup;
import msgroup.gleaningplanner.model.GleanerGroupRegistration;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.model.OrganizationRegistration;
import msgroup.gleaningplanner.model.Producer;
import msgroup.gleaningplanner.model.VolunteerRegistration;
import msgroup.gleaningplanner.repository.CommentRepository;
import msgroup.gleaningplanner.repository.EventRepository;
import msgroup.gleaningplanner.repository.FarmRepository;
import msgroup.gleaningplanner.repository.GleanerGroupRegistrationRepository;
import msgroup.gleaningplanner.repository.OrganizationRegistrationRepository;
import msgroup.gleaningplanner.repository.OrganizationRepository;
import msgroup.gleaningplanner.repository.ProducerRepository;
import msgroup.gleaningplanner.repository.VolunteerRegistrationRepository;

@Service
public class EventService {
    
    private EventRepository eventRepository;
    private FarmRepository farmRepository;
    private OrganizationRepository organizationRepository;
    private VolunteerRegistrationRepository volunteerRegistrationRepository;
    private OrganizationRegistrationRepository organizationRegistrationRepository;
    private GleanerGroupRegistrationRepository gleanerGroupRegistrationRepository;
    private ProducerRepository producerRepository;
    private CommentRepository commentRepository;

    public EventService(
        EventRepository eventRepository, 
        FarmRepository farmRepository,
        ProducerRepository producerRepository,
        VolunteerRegistrationRepository volunteerRegistrationRepository,
        OrganizationRegistrationRepository organizationRegistrationRepository,
        GleanerGroupRegistrationRepository gleanerGroupRegistrationRepository,
        OrganizationRepository organizationRepository,
        CommentRepository commentRepository
    ) {
        this.eventRepository = eventRepository;
        this.farmRepository = farmRepository;
        this.volunteerRegistrationRepository = volunteerRegistrationRepository;
        this.organizationRegistrationRepository = organizationRegistrationRepository;
        this.gleanerGroupRegistrationRepository = gleanerGroupRegistrationRepository;
        this.producerRepository = producerRepository;
        this.organizationRepository = organizationRepository;
        this.commentRepository = commentRepository;
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

        if (neededGleaners == null) neededGleaners = 0;
        
        
        String nGleaners = null;
        String urgent = null;
        String mGleaners = null;
        if (neededGleaners != null && neededGleaners > 0) nGleaners = Integer.toString(neededGleaners);
        if (isUrgent != null) urgent =  Boolean.toString(isUrgent);
        if (maxGleaners != null) mGleaners = Integer.toString(maxGleaners);


        List<String> incoming = Arrays.asList(eventName, nGleaners, description, urgent, strDate, mGleaners);
        for (String str : incoming) {
            System.out.println(str);
        }

        List<String> eventInfo;

        for (Event event : eventRepository.findAll()) {
            eventInfo = Arrays.asList(event.getEventName(), Integer.toString(event.getRequiredGleaners()), event.getDescription(), Boolean.toString(event.isUrgent()), dateFormat.format(event.getDate()), Integer.toString(event.getMaxGleaners()));
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

    public EventTeamTO getEventInfo(Integer iD) {
        EventTeamTO out = new EventTeamTO();
        Event event = eventRepository.findEventByID(iD);
        Farm farm = farmRepository.findFarmByID(event.getFarm().getID());
        Producer producer = producerRepository.findProducerByID(event.getFarm().getProducer().getID());

        // find all teams and their member
        List<VolunteerRegistration> volunteerReg =
                        volunteerRegistrationRepository.findAllVolunteerRegistrationByEvent(event);

        List<Integer> teamNumbers = new ArrayList<Integer>();
        List<EventTeam> teams = new ArrayList<>();

        for(VolunteerRegistration reg : volunteerReg) {
            // get the number for the team
            Integer groupNumber = reg.getVolunteerGroupNumber();

            // see if this team exists in the list
            if(!teamNumbers.contains(groupNumber)){

                // if not add it to the list
                teamNumbers.add(groupNumber);

                //create new event team
                EventTeam team = new EventTeam();

                // add the team number
                team.teamNumber = groupNumber;

                // add this person
                team.volunteers.add(reg.getVolunteer());

                //set if this team was accepted
                team.setIsTeamAccepted(reg.isEventAccepted());

                //add the team...lol
                teams.add(team);
            }else{
                for(EventTeam t : teams){
                    if(t.teamNumber == groupNumber){
                        // add this person
                        t.volunteers.add(reg.getVolunteer());
                    }
                }
            }
        }


        // find all orgs
        List<OrganizationRegistration> organizationsReg = 
                        organizationRegistrationRepository.findAllOrganizationRegistrationByEvent(event);

        Set<Organization> orgs = new HashSet<Organization>();

        for(OrganizationRegistration reg : organizationsReg){
            orgs.add(
                reg.getOrganization()
            );
        }


        // all gleaner groups
        List<GleanerGroupRegistration> groupsReg = 
                        gleanerGroupRegistrationRepository.findAllGleanerGroupRegistrationByEvent(event);

        Set<GleanerGroup> groups = new HashSet<GleanerGroup>();

        for(GleanerGroupRegistration grp: groupsReg){
            groups.add(
                grp.getGleanerGroup()
            );
        }

        out.event = event;
        out.producer = producer;        
        out.farm = farm;
        out.organizations = orgs;
        out.gleanerGroups = groups;
        out.teams = teams;
        out.comments = commentRepository.findAllCommentByEvent(event);

        return out;
    }
}
