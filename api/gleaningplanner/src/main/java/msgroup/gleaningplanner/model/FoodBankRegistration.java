package msgroup.gleaningplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FoodBankRegistration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @OneToOne
    private FoodBank foodBank;

    @OneToOne
    private Event event;

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public FoodBank getFoodBank() {
        return foodBank;
    }

    public void setFoodBank(FoodBank foodBank) {
        this.foodBank = foodBank;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    
}
