package polimi.blog.dao.model;

import java.time.LocalDateTime;
import java.util.List;

import polimi.blog.model.Post;
import polimi.blog.model.User;

public interface UserDAO {

	List<User> findAllUsers();
	boolean signUp(String username, String email, String password, LocalDateTime creationDate);
	User loginEmail(String email, String password);
	List<User> mergeUser_followedUsers(User u);
	User mergeUser_Posts(User u);
	List<Post> findAllMyPostsByDate(User u);
	User addInfo(User u, String info);

	
}
