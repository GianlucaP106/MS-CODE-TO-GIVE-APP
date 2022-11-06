package msgroup.gleaningplanner.controller.TransferObject;

import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Organization;

public class OrganizationRegistrationTO {
    public Integer ID;
    public Organization organization;
    public Event event;

    public OrganizationRegistrationTO(Integer id, Organization organization, Event event) {
        this.ID = id;
        this.organization = organization;
        this.event = event;
    }

    public static class OrganizationRegistrationRequest{
        public Integer organizationID;
        public Integer eventID;
   }
}
