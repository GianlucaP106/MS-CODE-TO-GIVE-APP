package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

public class AcceptenceTO {
    public Integer eventID;
    public Integer groupNumber;
    public Integer volunteerID;
    List<VolunteerTO> volunteers;


    public AcceptenceTO(
        int eventID, 
        int groupNumber, 
        int volunteerID, 
        List<VolunteerTO> volunteers
    ) {
        this.eventID = eventID;
        this.groupNumber = groupNumber;
        this.volunteers = volunteers;
        this.volunteerID = volunteerID;
    }


    public AcceptenceTO(
        Integer eventID, 
        Integer groupNumber, 
        List<VolunteerTO> out
    ) {
        this.eventID = eventID;
        this.groupNumber = groupNumber;
        this.volunteers = out;
    }


    public Integer getEventID() {
        return eventID;
    }


    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }


    public Integer getGroupNumber() {
        return groupNumber;
    }


    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }


    public Integer getVolunteerID() {
        return volunteerID;
    }


    public void setVolunteerID(Integer volunteerID) {
        this.volunteerID = volunteerID;
    }


    public List<VolunteerTO> getVolunteers() {
        return volunteers;
    }


    public void setVolunteers(List<VolunteerTO> volunteers) {
        this.volunteers = volunteers;
    }


    

    
}
