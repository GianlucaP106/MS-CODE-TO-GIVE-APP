package msgroup.gleaningplanner.controller.TransferObject;

public class ProducerTO {
    public Integer ID;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String password;
    public String city;
    public String address;
    public String postalCode;
    public double latitude;
    public double longitude;

    public ProducerTO(Integer id, String username, String firstName, String lastName, String email, String phoneNumber,
            String password, String city, String address, String postalCode, double latitude, double longitude ) {
        this.ID = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ProducerTO() {
    }

    public static class signInRequestProducer{
        public String username;
        public String password;
    }
    
}
