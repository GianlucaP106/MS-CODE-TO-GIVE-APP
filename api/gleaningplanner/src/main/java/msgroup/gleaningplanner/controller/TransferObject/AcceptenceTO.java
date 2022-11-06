package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

public class AcceptenceTO {
    public int eventID;
    public int groupNumber;
    List<VolunteerTO> volunteers;


    public AcceptenceTO(int eventID, int groupNumber, List<VolunteerTO> volunteers) {
        this.eventID = eventID;
        this.groupNumber = groupNumber;
        this.volunteers = volunteers;
    }


    public int getEventID() {
        return eventID;
    }


    public void setEventID(int eventID) {
        this.eventID = eventID;
    }


    public int getGroupNumber() {
        return groupNumber;
    }


    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }


    public List<VolunteerTO> getVolunteers() {
        return volunteers;
    }


    public void setVolunteers(List<VolunteerTO> volunteers) {
        this.volunteers = volunteers;
    }

    

    
}
