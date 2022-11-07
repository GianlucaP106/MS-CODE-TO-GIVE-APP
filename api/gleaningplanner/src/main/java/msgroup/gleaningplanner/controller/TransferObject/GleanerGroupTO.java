package msgroup.gleaningplanner.controller.TransferObject;

public class GleanerGroupTO {
    public Integer ID;
    public String username;
    public String password;
    public String groupName;
    public String region;
    public String address;
    public String city;
    public String postalCode;
    public String description;
    public String missionStatement;
    public String imageURL;
    public Double longitude;
    public Double latitude;

    public GleanerGroupTO() {}

    public GleanerGroupTO(Integer id, String username, String password, 
        String groupName, String region, String address, String city, 
        String postalCode, String description, String missionStatement, 
        String imageURL, Double latitude, Double longitude){

        this.ID = id;
        this.username = username;
        this.password = password;
        this.groupName = groupName;
        this.region = region;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.description = description;
        this.missionStatement = missionStatement;
        this.imageURL = imageURL;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static class signInRequestGleanerGroup{
        public String username;
        public String password;
    }
}
