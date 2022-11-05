package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

public class VolunteerFilterTO {
    
    public List<VolunteerTO> volunteers;

    public VolunteerFilterTO(List<VolunteerTO> volunteers) {
        this.volunteers = volunteers;
    }
}
