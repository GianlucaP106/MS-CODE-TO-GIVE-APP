package msgroup.gleaningplanner.controller.TransferObject;

public class VolunteerTO {
    public int ID;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String password;
    public String postalCode;
    public String address;
    public String city;
    public double latitude;
    public double longitude;

    
    public VolunteerTO(int iD, String username, String firstName, String lastName, String email, String phoneNumber,
            String postalCode, String address, String city, String password) {
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
    }
    
}
