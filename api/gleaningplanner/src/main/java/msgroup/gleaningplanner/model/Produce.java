package msgroup.gleaningplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private CropType cropType;
    
    // if organization then this is limitation
    // if event, then this is available  
    private double amount;

    @ManyToOne
    private Event event;  // event and organization cannot both be not null

    @ManyToOne 
    private OrganizationRegistration organizationRegistration;
    
    public Produce() {}

    public int getID() {
        return ID;
    }
    
    public void setID(int iD) {
        ID = iD;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public OrganizationRegistration getOrganizationRegistration() {
        return organizationRegistration;
    }

    public void setOrganizationRegistration(OrganizationRegistration organizationRegistration) {
        this.organizationRegistration = organizationRegistration;
    }

    public enum CropType {
        Alfalfa,
        Lentils,
        Peas,
        Soybeans,
        Wheat,
        Corn,
        Flax,
        Linola,
        Rye,
        Sorghum,
        Canary_Seed,
        Canola,
        Millet,
        Mustard,
        Barley,
        Buckwheat,
        Oats,
        Sunflower,
        Coriander,
        Crested_Wheat_Grass,
        Brome_Grass,
        Apples,
        Lima_Beans_Unshelled,
        Pole_Beans,
        Snap_Beans,
        Shelled_Corn,
        Corn_in_ear,
        Cowpeas,
        Cucumbers,
        Eggplant,
        English_Peas_In_Hull,
        Muscadines,
        Mustard_Greens,
        Onions,
        Peaches,
        Field_Peas,
        Sweet_Potatoes_Fresh,
        Sweet_Potatoes_Dry,
        Spinach,
        Tomatoes,
        Turnips,
        Turnip_Greens_Dry,
        Turnip_Greens_Wet,
        Squash,
        Cantaloupe, 
        Grapes_With_Stem,
        Pears,
        Plums,
        Wax_Beans,
        White_Beans,
        Beets,
        Bran,
        Carrots,
        Cotton_Seed,
        Cranberries,
        Gooseberries,
        Hickory_Nuts,
        Lime,
        Malt,
        Parsnips,
        Irish_Potatoes,
        Rutabaga,
        Spelt,
        Walnuts
    }


    public CropType getCropType() {
        return cropType;
    }

    public void setCropType(CropType cropType) {
        this.cropType = cropType;
    }
    
}
