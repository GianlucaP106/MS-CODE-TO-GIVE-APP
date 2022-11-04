package msgroup.gleaningplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class GleanerRegistration {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int ID;

    @OneToOne
    private Gleaner volunteer;

    
    private int volunteerGroup; 
    private boolean isOwner;
    
    @OneToOne
    private Event event;
    
    public GleanerRegistration() {}
    
    public int getID() {
        return ID;
    }
    
    public Gleaner getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Gleaner volunteer) {
        this.volunteer = volunteer;
    }
    
    public void setID(int iD) {
        ID = iD;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getVolunteerGroup() {
        return volunteerGroup;
    }

    public void setVolunteerGroup(int volunteerGroup) {
        this.volunteerGroup = volunteerGroup;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }

    
}
