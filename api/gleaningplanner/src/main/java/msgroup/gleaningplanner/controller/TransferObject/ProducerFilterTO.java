package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

public class ProducerFilterTO {
    
    public List<ProducerTO> producer;

    public ProducerFilterTO(List<ProducerTO> producers) {
        this.producer = producers;
    }
}
