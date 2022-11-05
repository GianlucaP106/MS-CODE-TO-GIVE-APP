package msgroup.gleaningplanner.controller.TransferObject;

public class EventTO {
    public int farmId;
    public String eventName;
    public int neededGleaners;
    public int maxGleaners;
    public String description;
    public boolean isUrgent;
    public String date;



    public EventTO(int farmId, String eventName, int neededGleaners, int maxGleaners, String description,
             boolean isUrgent, String date) {
        this.farmId = farmId;
        this.eventName = eventName;
        this.neededGleaners = neededGleaners;
        this.description = description;
        this.isUrgent = isUrgent;
        this.date = date;
        this.maxGleaners = maxGleaners;
    }
    public EventTO() {}

    
}
