package polimi.blog.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import polimi.blog.dao.jpa.CommentDAOJpa;
import polimi.blog.dao.model.CommentDAO;
import polimi.blog.model.Post;
import polimi.blog.model.User;
import polimi.blog.model.Comment;

public class CommentDAOJpa implements CommentDAO{


	private static CommentDAOJpa instance = new CommentDAOJpa();
	
	private CommentDAOJpa() {};
	
	public static CommentDAOJpa getInstance() {
		return instance;
	}
	
	
	@Override
	public List<Comment> findAllComments() {
	    EntityManager em = DAOFactoryJpa.getManager();
	    TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
	    try {
	        List<Comment> comments = query.getResultList();
	        return comments;
	    } catch (NoResultException e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    return null;
	}


	
	public List<Comment> findAllMyComments(User u) {
	    EntityManager em = DAOFactoryJpa.getManager();    
	    try {
	        TypedQuery<Comment> query = em.createQuery("SELECT c FROM comments c WHERE c.user = :user", Comment.class);
	        query.setParameter("user", u);
	        List<Comment> comments = query.getResultList();
	        return comments;
	    } catch (NoResultException e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    return null;
	}


	
	public List<Comment> findAllCommentsOfPost(Post p) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    try {
	        TypedQuery<Comment> query = em.createQuery("SELECT c FROM comments c WHERE c.post = :post", Comment.class);
	        query.setParameter("post", p);
	        List<Comment> comments = query.getResultList();
	        return comments;
	    } catch (NoResultException e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    return null;
	}


	
	public boolean addCommentToPost(Post p, User u, Comment c) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    try {
	        em.getTransaction().begin();
	        p.getComments().add(c);
	        u.getComments().add(c);
	        em.persist(c);
	        em.getTransaction().commit();
	        return true;
	    } catch (RollbackException e) {
	        e.printStackTrace();
	        em.getTransaction().rollback();
	    } finally {
	        em.close();
	    }
	    return false;
	}
}

