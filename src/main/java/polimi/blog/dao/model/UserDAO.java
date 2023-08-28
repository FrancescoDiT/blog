package polimi.blog.dao.model;

import java.time.LocalDateTime;
import java.util.List;

import polimi.blog.model.Post;
import polimi.blog.model.User;

public interface UserDAO {

	List<User> findAllUsers();
	boolean signUp(String username, String email, String password, LocalDateTime creationDate);
	User loginEmail(String email, String password);
	List<Post> findAllMyPostsByDate(User u);
	User addInfo(User u, String info);
	User mergeUser(User u);
	List<User> getMorePopular();
	Long countAllMyFollowers(User u);
	User getUserByUsername(String username);
	boolean subToBlogger(User fr, User fd);
	boolean unsubToBlogger(User fr, User fd);
	boolean checkSub(User fr, User fd);

	
}
