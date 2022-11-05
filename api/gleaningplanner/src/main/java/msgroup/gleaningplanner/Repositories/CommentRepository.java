package msgroup.gleaningplanner.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import msgroup.gleaningplanner.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{
    
    public Comment findCommentByID(int ID);
}
