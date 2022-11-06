package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

public class EventFilterTO {
    
    public List<EventTO> event;

    public EventFilterTO(List<EventTO> events) {
        this.event = events;
    }
}
