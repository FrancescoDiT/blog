package polimi.blog.dao.model;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import polimi.blog.model.Post;
import polimi.blog.model.User;

public interface UserDAO {

	List<User> findAllUsers();
	boolean signUp(String username, String email, String password, LocalDateTime creationDate);
	User loginEmail(String email, String password);
	User addInfo(User u, String info);
	User mergeUser(User u);
	List<User> getMorePopular();
	Long countAllMyFollowers(User u);
	User getUserByUsername(String username);
	boolean subToBlogger(User fr, User fd);
	boolean unsubToBlogger(User fr, User fd);
	boolean checkSub(User fr, User fd);
	List<User> findAllMyFollowers(User u);
	Set<User> findAllWhoIFollow(User u);

	
}
