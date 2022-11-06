package msgroup.gleaningplanner.controller.TransferObject;

public class GleanerGroupRegistrationTO {

     private Integer ID;
     private Integer gleanerGroupID;
     private Integer eventID;
     private Boolean eventApproved;

     public static class GleanerGroupRegistrationRequest{
          public Integer gleanerGroupID;
          public Integer eventID;
     }

     public GleanerGroupRegistrationTO(Integer iD, Integer gleanerGroupID, Integer eventID, Boolean eventApproved) {
          ID = iD;
          this.gleanerGroupID = gleanerGroupID;
          this.eventID = eventID;
          this.eventApproved = eventApproved;
     } 

   

}
