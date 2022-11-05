package msgroup.gleaningplanner.controller.TransferObject;

public class VolunteerRegistrationTO{

    public Integer ID;
    public Integer volunteerID;
    public Integer evemtID;
    public Integer volunteerGroupNumber;
    public Boolean volunteerGroupAccepted;
    public Boolean isOwner;
    public Boolean eventAccepted;

    public VolunteerRegistrationTO(Integer iD, Integer volunteerID, Integer evemtID, Integer volunteerGroupNumber,
            Boolean volunteerGroupAccepted, Boolean isOwner, Boolean eventAccepted) {
        ID = iD;
        this.volunteerID = volunteerID;
        this.evemtID = evemtID;
        this.volunteerGroupNumber = volunteerGroupNumber;
        this.volunteerGroupAccepted = volunteerGroupAccepted;
        this.isOwner = isOwner;
        this.eventAccepted = eventAccepted;
    }
    
    public static class RegistrationRequest{
        public Integer volunteerID;
        public Integer evemtID;
    }
}
