package msgroup.gleaningplanner.controller.TransferObject;

public class OrganizationTO {
    public int id;
    public String username;
    public String orgName;
    public String description;
    public String missionStatement;
    public String imageURL;
    public String address;
    public String postalCode;
    public String city;
    public String password;
    public double maxDistance;
    public String websiteLink;
    public double longitude;
    public double latitude;

    public OrganizationTO(int id, String username, String orgName, String description, String missionStatement,
            String imageURL, String address, String postalCode, String city, String password, double maxDistance,
            String websiteLink, double latitude, double longitude) {
        this.id = id;
        this.username = username;
        this.orgName = orgName;
        this.description = description;
        this.missionStatement = missionStatement;
        this.imageURL = imageURL;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.password = password;
        this.maxDistance = maxDistance;
        this.websiteLink = websiteLink;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    
    
}
