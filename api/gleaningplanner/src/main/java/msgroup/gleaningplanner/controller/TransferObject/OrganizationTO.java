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

    
    public OrganizationTO(int id, String username, String orgName, String description, String missionStatement, String imageURL,
            String postalCode, String address, String city, String password, int maxDistance, String websiteLink) {
        this.id = id;
        this.username = username;
        this.orgName = orgName;
        this.description = description;
        this.missionStatement = missionStatement;
        this.imageURL = imageURL;
        this.postalCode = postalCode;
        this.address = address;
        this.city = city;
        this.password = password;
        this.maxDistance = maxDistance;
        this.websiteLink = websiteLink;
    }
    
}
