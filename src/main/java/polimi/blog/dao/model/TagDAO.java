package polimi.blog.dao.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import polimi.blog.model.Post;
import polimi.blog.model.Tag;

public interface TagDAO {

	List<Tag> findAllTag();

	boolean addTagToPost(Post p, Tag t);

	Set<Tag> findAllTagsOfPost(Post p);

}
