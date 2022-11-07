package msgroup.gleaningplanner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.CommentTO;
import msgroup.gleaningplanner.controller.TransferObject.OrganizationFilterTO;
import msgroup.gleaningplanner.controller.TransferObject.OrganizationRegistrationTO;
import msgroup.gleaningplanner.controller.TransferObject.OrganizationTO;
import msgroup.gleaningplanner.controller.TransferObject.ProduceTO;
import msgroup.gleaningplanner.controller.TransferObject.OrganizationRegistrationTO.OrganizationRegistrationRequest;
import msgroup.gleaningplanner.controller.TransferObject.OrganizationTO.signInRequestOrg;
import msgroup.gleaningplanner.model.Comment;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.model.OrganizationRegistration;
import msgroup.gleaningplanner.model.Produce;
import msgroup.gleaningplanner.service.OrganizationService;

@RestController
public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
 
    @PostMapping("/organization/register")
    public ResponseEntity<OrganizationTO> createOrganization(@RequestBody OrganizationTO incoming) {
        Organization newOrganization = organizationService.createOrganization(
            incoming.username,
            incoming.password,
            incoming.name,
            incoming.description,
            incoming.missionStatement,
            incoming.imageURL,
            incoming.address,
            incoming.city,
            incoming.postalCode,
            incoming.maxDistance,
            incoming.websiteLink,
            incoming.phoneNumber
        );

        OrganizationTO out = new OrganizationTO(
            newOrganization.getID(), 
            newOrganization.getUsername(), 
            newOrganization.getOrganizationName(), 
            newOrganization.getDescription(), 
            newOrganization.getMissionStatement(), 
            newOrganization.getImageURL(), 
            newOrganization.getAddress(), 
            newOrganization.getPostalCode(),
            newOrganization.getCity(), 
            null, 
            newOrganization.getMaxDistance(), 
            newOrganization.getWebsiteLink(),
            newOrganization.getLongitude(), 
            newOrganization.getLatitude(),
            newOrganization.getParticipatedEvent(),
            newOrganization.getPhoneNumber()
        );

        return new ResponseEntity<OrganizationTO>(out, HttpStatus.OK);
    }


    @PostMapping("organization/sign-in")
    public ResponseEntity<OrganizationTO> signIn(@RequestBody signInRequestOrg incoming) {
        Organization org = organizationService.verifySignIn(
            incoming.username, 
            incoming.password
        );

        if(org == null) return new ResponseEntity<OrganizationTO>(new OrganizationTO(), HttpStatus.BAD_REQUEST);

        OrganizationTO out = new OrganizationTO(
            org.getID(), 
            org.getUsername(), 
            org.getOrganizationName(), 
            org.getDescription(), 
            org.getMissionStatement(), 
            org.getImageURL(), 
            org.getAddress(), 
            org.getPostalCode(),
            org.getCity(), 
            null, 
            org.getMaxDistance(), 
            org.getWebsiteLink(),
            org.getLongitude(), 
            org.getLatitude(),
            org.getParticipatedEvent(),
            org.getPhoneNumber()
        );

        return new ResponseEntity<OrganizationTO>(out, HttpStatus.OK);
    }

    @PutMapping("organization/update")
    public ResponseEntity<OrganizationTO> updateOrganization(@RequestBody OrganizationTO incoming) {

        Organization newOrganization = organizationService.updateOrganization(
            incoming.ID,
            incoming.username,
            incoming.password,
            incoming.name,
            incoming.description,
            incoming.missionStatement,
            incoming.imageURL,
            incoming.address,
            incoming.city,
            incoming.postalCode,
            incoming.maxDistance,
            incoming.websiteLink
        );
        
        OrganizationTO out = new OrganizationTO(
            newOrganization.getID(), 
            newOrganization.getUsername(), 
            newOrganization.getOrganizationName(), 
            newOrganization.getDescription(), 
            newOrganization.getMissionStatement(), 
            newOrganization.getImageURL(), 
            newOrganization.getAddress(), 
            newOrganization.getPostalCode(),
            newOrganization.getCity(), 
            null, 
            newOrganization.getMaxDistance(), 
            newOrganization.getWebsiteLink(),
            newOrganization.getLongitude(), 
            newOrganization.getLatitude(),
            newOrganization.getParticipatedEvent(),
            newOrganization.getPhoneNumber()
        );

        return new ResponseEntity<OrganizationTO>(out, HttpStatus.OK);
    }

    @PostMapping("/organization/get-by-filter")
    public ResponseEntity<OrganizationFilterTO> getOrganizationByFilter(@RequestBody OrganizationTO incoming) {
        Set<Organization> filteredOrganizations = this.organizationService.filterOrganizations(
            incoming.ID,
            incoming.username, 
            incoming.password, 
            incoming.name, 
            incoming.description, 
            incoming.missionStatement, 
            incoming.imageURL, 
            incoming.address, 
            incoming.city, 
            incoming.postalCode, 
            incoming.maxDistance, 
            incoming.websiteLink
        );
        
        List<OrganizationTO> organizationTOs = new ArrayList<OrganizationTO>();
        for (Organization organization : filteredOrganizations) {
            OrganizationTO to = new OrganizationTO(
                organization.getID(), 
                organization.getUsername(), 
                organization.getOrganizationName(), 
                organization.getDescription(), 
                organization.getMissionStatement(), 
                organization.getImageURL(),
                organization.getAddress(), 
                organization.getPostalCode(), 
                organization.getCity(), 
                organization.getPassword(), 
                organization.getMaxDistance(), 
                organization.getWebsiteLink(),
                organization.getLatitude(),
                organization.getLongitude(),
                organization.getParticipatedEvent(),
                organization.getPhoneNumber()
            );
            organizationTOs.add(to);
        }

        return new ResponseEntity<OrganizationFilterTO>(new OrganizationFilterTO(organizationTOs), HttpStatus.OK);
    }


    @PostMapping("/organization/comment-event/")
    public ResponseEntity<CommentTO> postCommentEvent(@RequestBody CommentTO incoming) {
        Comment comment = organizationService.postCommentEvent(
            incoming.comment,
            incoming.authorType,
            incoming.organizationID, 
            incoming.eventID
        );

        CommentTO out = new CommentTO();
        out.setAuthorType(comment.getAuthorType().toString());
        out.setComment(comment.getComment());
        out.setOrganizationID(comment.getOrganization().getID());
        out.setEventID(comment.getEvent().getID());

        return new ResponseEntity<CommentTO>(out, HttpStatus.OK);


    }

    @PostMapping("/organization/event-register")
    public ResponseEntity<OrganizationRegistrationTO> registerToEvent(@RequestBody OrganizationRegistrationRequest incoming){
        OrganizationRegistration organizationRegistration = organizationService.registerToEvent(incoming.eventID, incoming.organizationID);

        OrganizationRegistrationTO out = new OrganizationRegistrationTO(organizationRegistration.getID(), organizationRegistration.getOrganization(), organizationRegistration.getEvent());

        return new ResponseEntity<OrganizationRegistrationTO>(out, HttpStatus.OK);

    }

    @GetMapping("/organization/all")
    public List<OrganizationTO> getAllOrganization() {
        return organizationService.getAll();
    }

    @PostMapping("/organization/registration-add-produce")
    public ResponseEntity<Produce> addProduceToReg(@RequestBody ProduceTO incoming){
        Produce produce = organizationService.addProduceToRegistration(
            incoming.eventID, 
            incoming.organizationID, 
            incoming.produceType, 
            incoming.amount
        );

        return new ResponseEntity<Produce>(produce, HttpStatus.OK);
    }
}
