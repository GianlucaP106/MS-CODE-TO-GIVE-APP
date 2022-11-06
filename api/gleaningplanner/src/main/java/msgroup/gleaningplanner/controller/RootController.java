package msgroup.gleaningplanner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import msgroup.gleaningplanner.controller.TransferObject.CommentListTO;
import msgroup.gleaningplanner.controller.TransferObject.LocationAPITO;
import msgroup.gleaningplanner.model.Comment;
import msgroup.gleaningplanner.repository.CommentRepository;
import msgroup.gleaningplanner.service.LocationService;

@RestController
@RequestMapping("/")
public class RootController {

    private LocationService locationService;
    private CommentRepository commentRepository;

    public RootController(
        LocationService locationService, 
        CommentRepository commentRepository
    ) {
        this.locationService = locationService;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/comment/getall")
    public ResponseEntity<CommentListTO> getAllComments() {
        Iterable<Comment> comments = commentRepository.findAll();
        List<Comment> commentList = new ArrayList<Comment>();
        for (Comment comment : comments) {
            commentList.add(comment);
        }
        CommentListTO out = new CommentListTO(commentList);
        return new ResponseEntity<CommentListTO>(out, HttpStatus.OK);
    }

    // @GetMapping("/")
    // public String greeting() {
    //     return "how are u";
    // }

    // @GetMapping("/testloc")
    // public ResponseEntity<LocationAPITO> getLoc(){
    //     return locationService.transformToLatitudeLongitude(null, "H8P 1C6", "Montreal"); 
    // }


}
