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
    private ProduceType produceType;
    
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


    public ProduceType getProduceType() {
        return produceType;
    }


    public void setProduceType(ProduceType produceType) {
        this.produceType = produceType;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }
}
