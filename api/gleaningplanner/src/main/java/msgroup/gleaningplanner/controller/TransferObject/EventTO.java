package msgroup.gleaningplanner.controller.TransferObject;

public class EventTO {
    public Integer ID;
    public Integer farmId;
    public String name;
    public Integer neededGleaners;
    public Integer maxGleaners;
    public String description;
    public Boolean isUrgent;
    public String date;



    public EventTO(Integer ID, Integer farmId, String eventName, Integer neededGleaners, Integer maxGleaners, String description,
        Boolean isUrgent, String date) {
        this.ID = ID;
        this.farmId = farmId;
        this.name = eventName;
        this.neededGleaners = neededGleaners;
        this.description = description;
        this.isUrgent = isUrgent;
        this.date = date;
        this.maxGleaners = maxGleaners;
    }
    public EventTO() {}

    
}
