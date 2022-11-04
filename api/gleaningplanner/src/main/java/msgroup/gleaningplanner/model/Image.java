package msgroup.gleaningplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    
    @ManyToOne
    private Gleaner gleaner;

    @ManyToOne
    private FoodBank foodBank;

    @ManyToOne
    private GleanerGroup gleanerGroup;

    @ManyToOne
    private Producer producer;

    @ManyToOne
    private Farm farm;

    private String imageURL;

    private String iamgeType; 

    public Farm getFarm() {
        return farm;
    }
    public void setFarm(Farm farm) {
        this.farm = farm;
    }
    
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }

    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public String getIamgeType() {
        return iamgeType;
    }
    public void setIamgeType(String iamgeType) {
        this.iamgeType = iamgeType;
    }

    
}
