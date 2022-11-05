package msgroup.gleaningplanner.controller.TransferObject;

public class GleanerGroupTO {
    public String username;
    public String password;
    public String groupName;
    public String region;
    public String description;
    public String missionStatement;
    public String imageURl;

    public GleanerGroupTO(String username, String password,
    String groupName, String region, String description, 
    String missionStatement, String imageURL){
        this.username = username;
        this.password = password;
        this.groupName = groupName;
        this.region = region;
        this.description = description;
        this.missionStatement = missionStatement;
        this.imageURl = imageURL;
    }
}
