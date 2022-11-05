package msgroup.gleaningplanner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.AuthorType;
import msgroup.gleaningplanner.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{
    
    public Comment findCommentByID(int ID);

    public List<Comment> findCommentByAuthorType(AuthorType authorType);
}
