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
    public int maxDistance;
    public String websiteLink;
    public double longitude;
    public double latitude;

    public OrganizationTO(int id, String username, String orgName, String description, String missionStatement,
            String imageURL, String address, String postalCode, String city, String password, int maxDistance,
            String websiteLink, double longitude, double latitude) {
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
        this.longitude = longitude;
        this.latitude = latitude;
    }

    
    
}
