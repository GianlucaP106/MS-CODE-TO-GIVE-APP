package msgroup.gleaningplanner.controller.TransferObject;

public class VolunteerTO {
    public Integer ID;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String postalCode;
    public String address;
    public String city;
    public String password;
    public Double latitude;
    public Double longitude;
    public Integer participatedEvents;

    public VolunteerTO() {}
    
    public VolunteerTO(int iD, String username, String firstName, String lastName, String email, String phoneNumber,
            String postalCode, String address, String city, double latitude, double longitude, String password, 
            Integer participatedEvents) {

        ID = iD;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.address = address;
        this.city = city;
        this.password = password;
        this.latitude = latitude;
        this.longitude = longitude;
        this.participatedEvents = participatedEvents;
    }

    public static class signInRequestVolunteer{
        public String username;
        public String password;
    }
    
}
