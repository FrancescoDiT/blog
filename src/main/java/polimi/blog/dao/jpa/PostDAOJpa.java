package polimi.blog.dao.jpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import polimi.blog.dao.jpa.PostDAOJpa;
import polimi.blog.dao.model.PostDAO;
import polimi.blog.model.Post;
import polimi.blog.model.User;

public class PostDAOJpa implements PostDAO{


	private static PostDAOJpa instance = new PostDAOJpa();
	
	private PostDAOJpa() {};
	
	public static PostDAOJpa getInstance() {
		return instance;
	}

	@Override
	public List<Post> findAllPosts() {
	    EntityManager em = DAOFactoryJpa.getManager();
	    try {
	        TypedQuery<Post> query = em.createNamedQuery("Post.findAll",
	        		Post.class);
	        List<Post> posts = query.getResultList();
	        return posts;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return null;
	}

	
	@Override
	public boolean addPost(User u, Post p) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    EntityTransaction transaction = em.getTransaction();
	    try {
	        transaction.begin();
	        u = em.merge(u);
	        u.getPosts().add(p);
	        em.persist(p);
	        em.flush();
	        transaction.commit();
	        return true; 
	    } catch (RollbackException e) {
	        e.printStackTrace();
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return false;
	}

	@Override
	public Post mergePost(Post p) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    try {
	    	p = em.find(Post.class, p);
	        em.flush();
	        return p; 
	        
	    } catch (RollbackException e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return p;
	}
	

	@Override
	public Set<Post> findAllMyPosts(User u) {
	    EntityManager em = DAOFactoryJpa.getManager();

	    try {
	    	u = em.find(User.class, u.getId());
	        TypedQuery<Post> q = em.createQuery(
	        	  "SELECT p "
	            + "FROM posts p "
	            + "WHERE p.user = :userId",
	            Post.class);
	        q.setParameter("userId", u.getId());
	        return new LinkedHashSet<Post>(q.getResultList());
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return new LinkedHashSet<Post>(); 	
    }
	
	@Override
	public Set<Post> findAllMyPostsByDate(User u) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    try {
	        TypedQuery<Post> q = em.createQuery(	
	        		  "SELECT DISTINCT fup "
	        		+ "FROM users u "
	        		+ "LEFT JOIN u.followedUsers fu "
	        		+ "LEFT JOIN fu.posts fup "
	        		+ "WHERE u.id = :userIdKey "
	        		+ "AND fup.postDate > :LocalDateKey "
	        		+ "ORDER BY fup.postDate DESC",
	  	            Post.class);
	  	        q.setParameter("userIdKey", u.getId());
	  	        q.setParameter("LocalDateKey", LocalDateTime.now().minusDays(2));
	  	        
	        return new LinkedHashSet<Post>(q.getResultList());
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return new HashSet<>(); 
	}

	@Override
	public Post findPostById(int id) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    Post p = new Post();
	    try {
	    	return em.find(Post.class, id);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return new Post();
	}
	
	public List<Post> findAllMySavedPosts(User u) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    try {
	        TypedQuery<Post> q = em.createQuery(
	            "SELECT p "
	            + "FROM posts p "
	            + "JOIN p.savedByUsers u "
	            + "WHERE u.id = :userIdKey",
	            Post.class);
	        q.setParameter("userIdKey", u.getId());
	        return q.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return null; 
	}

	
	public boolean addSavedPost(Post p, User u) {
	    EntityManager em = DAOFactoryJpa.getManager();

	    try {
	        em.getTransaction().begin();
	        p.getUserSaved().add(u);
	        u.getPosts().add(p);
	        em.persist(u);
	        em.persist(p);
	        em.flush();
	        em.getTransaction().commit();
	        return true; 
	    } catch (RollbackException e) {
	        e.printStackTrace();
	        em.getTransaction().rollback();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return false;
	}

	


	
}
