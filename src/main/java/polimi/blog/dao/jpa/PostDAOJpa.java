package polimi.blog.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import polimi.blog.dao.jpa.PostDAOJpa;
import polimi.blog.dao.model.PostDAO;
import polimi.blog.model.Comment;
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
	    try {
	        em.getTransaction().begin();
	        u.getPosts().add(p);
	        em.persist(p);
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

	
	public List<Post> findAllMySavedPosts(User u) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    try {
	        TypedQuery<Post> q = em.createQuery(
	            "SELECT p FROM posts p JOIN p.savedByUsers u WHERE u.id = :userIdKey",
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

	
	public List<Post> findAllMyPosts(User u) {
	    EntityManager em = DAOFactoryJpa.getManager();

	    try {
	        TypedQuery<Post> q = em.createQuery(
	            "SELECT p FROM posts p WHERE p.user = :user",
	            Post.class);
	        q.setParameter("user", u);
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

	
}
