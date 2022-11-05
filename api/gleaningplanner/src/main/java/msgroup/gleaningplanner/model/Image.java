package msgroup.gleaningplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    
    @ManyToOne
    private Volunteer volunteer;

    @ManyToOne
    private Organization organization;

    @ManyToOne
    private GleanerGroup gleanerGroup;

    @ManyToOne
    private Producer producer;

    @ManyToOne
    private Farm farm;

    @ManyToOne
    private Event event;

    private ImageType imageType; 

    private String imageURL;

    public Farm getFarm() {
        return farm;
    }
    public void setFarm(Farm farm) {
        this.farm = farm;
    }
    
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }

    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public ImageType getImageType() {
        return imageType;
    }
    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }
    public Volunteer getGleaner() {
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
    public Volunteer getVolunteer() {
        return volunteer;
    }
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }

}
