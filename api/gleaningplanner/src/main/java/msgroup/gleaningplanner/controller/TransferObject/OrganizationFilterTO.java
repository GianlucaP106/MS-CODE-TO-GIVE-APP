package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

public class OrganizationFilterTO {
    
    public List<OrganizationTO> organization;

    public OrganizationFilterTO(List<OrganizationTO> organizations) {
        this.organization = organizations;
    }
}
