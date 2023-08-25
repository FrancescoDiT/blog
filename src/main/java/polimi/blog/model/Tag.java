  package polimi.blog.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity(name = "tags")
@NamedQuery(name = "Tag.findAll", query = "SELECT t FROM tags t")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String name;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private List<Post> Posts = new ArrayList<>();

	public Tag() {}
	
	public Tag(String name) {
		super();
		this.name = name;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return Posts;
	}

	public void setPosts(List<Post> posts) {
		Posts = posts;
	}
	
}
