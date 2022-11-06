package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

public class EventFilterTO {
    
    public List<EventTO> events;

    public EventFilterTO(List<EventTO> events) {
        this.events = events;
    }
}
