package msgroup.gleaningplanner.controller.TransferObject;


public class CommentTO {
    public String comment;
    public Integer organizationID;
    public Integer producerID;
    public Integer volunteerID;
    public Integer eventID;
    public Integer gleanerGroupID;
    public String authorType;


    public CommentTO(
        String comment, 
        int organizationID, 
        int volunteerID, 
        int eventID, 
        int gleanerGroupID,
        String authorType
    ) {
        this.comment = comment;
        this.organizationID = organizationID;
        this.volunteerID = volunteerID;
        this.eventID = eventID;
        this.gleanerGroupID = gleanerGroupID;
        this.authorType = authorType;
    }

    public CommentTO() {}


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }


    public Integer getOrganizationID() {
        return organizationID;
    }


    public void setOrganizationID(Integer organizationID) {
        this.organizationID = organizationID;
    }


    public Integer getVolunteerID() {
        return volunteerID;
    }


    public void setVolunteerID(Integer volunteerID) {
        this.volunteerID = volunteerID;
    }


    public Integer getEventID() {
        return eventID;
    }


    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }


    public Integer getGleanerGroupID() {
        return gleanerGroupID;
    }


    public void setGleanerGroupID(Integer gleanerGroupID) {
        this.gleanerGroupID = gleanerGroupID;
    }


    public String getAuthorType() {
        return authorType;
    }


    public void setAuthorType(String authorType) {
        this.authorType = authorType;
    }

    
    
}
