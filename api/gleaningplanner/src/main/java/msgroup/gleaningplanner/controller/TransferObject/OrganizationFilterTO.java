package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

public class OrganizationFilterTO {
    
    public List<OrganizationTO> organizations;

    public OrganizationFilterTO(List<OrganizationTO> organizations) {
        this.organizations = organizations;
    }
}
