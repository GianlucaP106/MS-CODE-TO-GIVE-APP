package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

import msgroup.gleaningplanner.model.Comment;

public class CommentListTO {
    
    public List<Comment> comments;

    public CommentListTO(List<Comment> comments) {
        this.comments = comments;
    }
}
