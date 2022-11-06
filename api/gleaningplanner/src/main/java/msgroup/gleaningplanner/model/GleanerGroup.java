package msgroup.gleaningplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GleanerGroup extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String groupName;
    private int totalMembers;
    private String description;
    private String missionStatement;
    private String imageURL;
    private String region;
    
    private Integer participatedEvent;

    public GleanerGroup() {
        super();
    }
    
    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMissionStatement() {
        return missionStatement;
    }

    public void setMissionStatement(String missionStatement) {
        this.missionStatement = missionStatement;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getParticipatedEvent() {
        return participatedEvent;
    }

    public void setParticipatedEvent(Integer participatedEvent) {
        this.participatedEvent = participatedEvent;
    }

    
}
