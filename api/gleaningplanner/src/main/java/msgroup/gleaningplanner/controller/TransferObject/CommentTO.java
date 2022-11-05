package msgroup.gleaningplanner.controller.TransferObject;


public class CommentTO {
    public String comment;
    public int organizationID;
    public int volunteerID;
    public int eventID;
    public int gleanerGroupID;
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

    
    
}
