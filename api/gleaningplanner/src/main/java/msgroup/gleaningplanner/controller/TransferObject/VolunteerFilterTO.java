package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

public class VolunteerFilterTO {
    
    public List<VolunteerTO> volunteer;

    public VolunteerFilterTO(List<VolunteerTO> volunteers) {
        this.volunteer = volunteers;
    }
}
