package msgroup.gleaningplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Farm {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private long longitude;
    private long latitude;
    private String farmName;
    private double surfaceArea;
    private String address;
    private String city;
    private String postalCode;
    
    @ManyToOne
    private Producer producer;

    public Farm() {}

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public long getLongitude() {
        return longitude;
    }
    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
    public long getLatitude() {
        return latitude;
    }
    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
    public String getFarmName() {
        return farmName;
    }
    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }
    public double getSurfaceArea() {
        return surfaceArea;
    }
    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    
}
