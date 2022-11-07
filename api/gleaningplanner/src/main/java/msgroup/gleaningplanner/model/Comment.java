package msgroup.gleaningplanner.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private Date date;

    private String comment;

    private AuthorType authorType;

    @ManyToOne
    private Volunteer volunteer;

    @ManyToOne
    private Organization organization;

    @ManyToOne
    private GleanerGroup gleanerGroup;

    @ManyToOne
    private Producer producer;

    @ManyToOne
    private Event event;

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public GleanerGroup getGleanerGroup() {
        return gleanerGroup;
    }

    public void setGleanerGroup(GleanerGroup gleanerGroup) {
        this.gleanerGroup = gleanerGroup;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public AuthorType getAuthorType() {
        return authorType;
    }

    public void setAuthorType(AuthorType authorType) {
        this.authorType = authorType;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
}
