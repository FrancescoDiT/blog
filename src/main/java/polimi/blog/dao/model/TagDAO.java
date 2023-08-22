package polimi.blog.dao.model;

import java.util.ArrayList;
import java.util.List;

import polimi.blog.model.Post;
import polimi.blog.model.Tag;

public interface TagDAO {

	List<Tag> findAllTag();

	boolean addTagToPost(Post p, List<Tag> t);

}
