package msgroup.gleaningplanner.model;

import java.sql.Date;

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

    @ManyToOne
    private Gleaner gleaner;

    @ManyToOne
    private Organization organization;

    @ManyToOne
    private GleanerGroup gleanerGroup;

    @ManyToOne
    private Producer producer;

    @ManyToOne
    private Farm farm;

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

    public Gleaner getGleaner() {
        return gleaner;
    }

    public void setGleaner(Gleaner gleaner) {
        this.gleaner = gleaner;
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

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
    
}
