package msgroup.gleaningplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class GleanerGroupRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @OneToOne
    private GleanerGroup gleanerGroup;

    @OneToOne
    private Event event;

    private boolean eventApproved;

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public GleanerGroup getGleanerGroup() {
        return gleanerGroup;
    }

    public void setGleanerGroup(GleanerGroup gleanerGroup) {
        this.gleanerGroup = gleanerGroup;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isEventApproved() {
        return eventApproved;
    }

    public void setEventApproved(boolean eventApproved) {
        this.eventApproved = eventApproved;
    }

    
}
