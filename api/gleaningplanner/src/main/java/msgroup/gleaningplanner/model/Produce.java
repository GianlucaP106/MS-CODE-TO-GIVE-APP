package msgroup.gleaningplanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Produce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @OneToOne
    private ProduceType producerType;
    
    // if foodbank then this is limitation
    // if event, then this is available  
    private double amount;

    @ManyToOne
    private Event event;  // event and foodbank cannot both be not null

    @ManyToOne 
    private FoodBank foodBank;
    
    public Produce() {}


    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }


    public ProduceType getProducerType() {
        return producerType;
    }


    public void setProducerType(ProduceType producerType) {
        this.producerType = producerType;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }
}
