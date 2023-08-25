package polimi.blog.dao.model;

import java.util.List;

import polimi.blog.model.Post;
import polimi.blog.model.User;

public interface PostDAO {

	List<Post> findAllPosts();

	boolean addPost(User u, Post p);

	Post mergePost(Post p);

}
