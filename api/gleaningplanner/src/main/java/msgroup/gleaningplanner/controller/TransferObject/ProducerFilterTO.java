package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

public class ProducerFilterTO {
    
    public List<ProducerTO> producers;

    public ProducerFilterTO(List<ProducerTO> producers) {
        this.producers = producers;
    }
}
