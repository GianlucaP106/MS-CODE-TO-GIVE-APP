package msgroup.gleaningplanner.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String eventName;

    private int requiredGleaners;
    private int maxGleaners;
    private String description;
    private boolean isUrgent;

    @OneToOne
    private Farm farm;

    private Date date;
    
    public Event() {}

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getRequiredGleaners() {
        return requiredGleaners;
    }

    public void setRequiredGleaners(int requiredGleaners) {
        this.requiredGleaners = requiredGleaners;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMaxGleaners() {
        return maxGleaners;
    }

    public void setMaxGleaners(int maxGleaners) {
        this.maxGleaners = maxGleaners;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

}
