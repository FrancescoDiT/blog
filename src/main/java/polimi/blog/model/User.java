package polimi.blog.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM users u")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = true)
	private String info;
	
	@Column(nullable = false)
	private LocalDateTime creationDate;
	
	@ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
	@JoinTable(name = "posts_saved", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name =  "post_id"))
	private List<Post> savedPosts = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "users_follows", joinColumns = @JoinColumn(name = "follower_id"), inverseJoinColumns = @JoinColumn(name =  "following_id"))
	private List<User> followedUsers = new ArrayList<>();  //quelli che tu segui
	
    @ManyToMany(mappedBy = "followedUsers", fetch = FetchType.LAZY)
    private List<User> followingUsers = new ArrayList<>(); //quelli che ti seguono
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<>();

	public User() {}
	
	public User(String username) {
		this.username = username;
	}
	
	public User(String username, String info) {
		this.username = username;
		this.info = info;
	}

	public User(String username, String email, String password, LocalDateTime creationDate) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
	}
	
	public User(String username, String email, String password, LocalDateTime creationDate, String info) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.info = info;
	}
	
	public User(String username, String email, String password, LocalDateTime creationDate, Post post) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.savedPosts.add(post);
	}
	
	public User(String username, String email, String password, LocalDateTime creationDate, User user, boolean check) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		if(check) { 
			this.followedUsers.add(user);
				} else {
					this.followingUsers.add(user);
				}
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public List<Post> getSavedPosts() {
		return savedPosts;
	}

	public void setSavedPosts(List<Post> savedPosts) {
		this.savedPosts = savedPosts;
	}

	public List<User> getFollowedUsers() {
		return followedUsers;
	}

	public void setFollowedUsers(List<User> followedUsers) {
		this.followedUsers = followedUsers;
	}

	public List<User> getFollowingUsers() {
		return followingUsers;
	}

	public void setFollowingUsers(List<User> followingUsers) {
		this.followingUsers = followingUsers;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	

}