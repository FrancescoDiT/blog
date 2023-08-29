package polimi.blog.dao.model;

import java.util.List;
import java.util.Set;

import polimi.blog.model.Comment;
import polimi.blog.model.Post;
import polimi.blog.model.User;

public interface CommentDAO {

	List<Comment> findAllComments();
	boolean addComment(Comment c, User u, Post p);
	Set<Comment> findAllCommentsOfPost(Post p);

}
