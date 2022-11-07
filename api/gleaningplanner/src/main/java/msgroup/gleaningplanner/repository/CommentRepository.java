package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.AuthorType;
import msgroup.gleaningplanner.model.Comment;
import msgroup.gleaningplanner.model.Event;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    
    public Comment findCommentByID(int ID);

    public List<Comment> findAllCommentByAuthorType(AuthorType authorType);

    public List<Comment> findAllCommentByEvent(Event event); 
}
