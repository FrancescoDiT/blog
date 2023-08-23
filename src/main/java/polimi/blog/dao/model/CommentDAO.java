package polimi.blog.dao.model;

import java.util.List;

import polimi.blog.model.Comment;
import polimi.blog.model.Post;
import polimi.blog.model.User;

public interface CommentDAO {

	List<Comment> findAllComments();

	boolean addCommentToPost(Post p, Comment c);

	boolean addCommentToUser(Comment c, User u);

}
