package msgroup.gleaningplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class VolunteerRegistration {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int ID;

    @OneToOne
    private Volunteer volunteer;
    
    /**
     * This variable represents the group number of a volunteer
     */
    private int volunteerGroupNumber; 

    /**
     * untill this boolean is true, the admin of a group has not yet accepted the 
     * request of this volunteer 
     */
    private boolean volunteerGroupAccepted;

    /**
     * this means that the volunteer is the owner of the volunteerNumber group you currently have
     */
    private boolean isOwner;

    /**
     * this variable shows if the producer has accepted this member and its group to join the gleaning event
     */
    private boolean eventAccepted;
    
    @OneToOne
    private Event event;
    
    public VolunteerRegistration() {}
    
    public int getID() {
        return ID;
    }
    
    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
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

    public boolean isOwner() {
        return isOwner;
    }

    public int getVolunteerGroupNumber() {
        return volunteerGroupNumber;
    }

    public void setVolunteerGroupNumber(int volunteerGroupNumber) {
        this.volunteerGroupNumber = volunteerGroupNumber;
    }

    public void setOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }

    public boolean isVolunteerGroupAccepted() {
        return volunteerGroupAccepted;
    }

    public void setVolunteerGroupAccepted(boolean volunteerGroupAccepted) {
        this.volunteerGroupAccepted = volunteerGroupAccepted;
    }

    public boolean isEventAccepted() {
        return eventAccepted;
    }

    public void setEventAccepted(boolean eventAccepted) {
        this.eventAccepted = eventAccepted;
    }
    
}
