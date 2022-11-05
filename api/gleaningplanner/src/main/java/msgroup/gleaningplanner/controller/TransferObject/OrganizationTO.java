package msgroup.gleaningplanner.controller.TransferObject;

public class OrganizationTO {
    public Integer id;
    public String username;
    public String orgName;
    public String description;
    public String missionStatement;
    public String imageURL;
    public String address;
    public String postalCode;
    public String city;
    public String password;
    public Double maxDistance;
    public String websiteLink;
    public Double longitude;
    public Double latitude;

    public OrganizationTO(Integer id, String username, String orgName, String description, String missionStatement,
            String imageURL, String address, String postalCode, String city, String password, Double maxDistance,
            String websiteLink, Double latitude, Double longitude) {
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
