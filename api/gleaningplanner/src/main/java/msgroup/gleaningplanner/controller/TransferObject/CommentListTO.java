package msgroup.gleaningplanner.controller.TransferObject;

import java.util.List;

import msgroup.gleaningplanner.model.Comment;

public class CommentListTO {
    
    private Iterable<Comment> comments;

    public CommentListTO(Iterable<Comment> comments) {
        this.comments = comments;
    }
}
