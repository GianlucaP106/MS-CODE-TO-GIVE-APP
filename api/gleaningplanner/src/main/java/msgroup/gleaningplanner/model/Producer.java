package msgroup.gleaningplanner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producer extends User{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    public Producer() {
        super();
    }

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
