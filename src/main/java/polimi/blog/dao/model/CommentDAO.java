package polimi.blog.dao.model;

import java.util.List;

import polimi.blog.model.Comment;

public interface CommentDAO {

	List<Comment> findAllComments();

}
