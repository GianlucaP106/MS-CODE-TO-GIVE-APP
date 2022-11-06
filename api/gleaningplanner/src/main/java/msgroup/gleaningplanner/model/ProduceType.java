package msgroup.gleaningplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProduceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private CropType cropType;
    private String imageURL;
    
    public CropType getCropType() {
        return cropType;
    }
    public void setCropType(CropType cropType) {
        this.cropType = cropType;
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

    private enum CropType {
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
    
}
