package msgroup.gleaningplanner.controller.TransferObject;

public class OrganizationTO {
    public Integer ID;
    public String username;
    public String name;
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
    public Integer participatedEvent;
    public String phoneNumber;

    public OrganizationTO() {}

    public OrganizationTO(Integer id, String username, String orgName, String description, String missionStatement,
            String imageURL, String address, String postalCode, String city, String password, Double maxDistance,
            String websiteLink, Double latitude, Double longitude, Integer participateEvent, String phoneNumber) {
        this.ID = id;
        this.username = username;
        this.name = orgName;
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
        this.participatedEvent = participateEvent;
        this.phoneNumber = phoneNumber;
    }
    

    public static class signInRequestOrg{
        public String username;
        public String password;
    }
}
