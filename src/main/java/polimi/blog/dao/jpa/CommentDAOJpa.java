package polimi.blog.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	    	if(em.isOpen()) {
	        em.close();
	    	}
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
	    	if(em.isOpen()) {
	        em.close();
	    	}
	    }
	    return null;
	}


	@Override
	public List<Comment> getAllCommentsOfPost(Post p) {
		EntityManager em = DAOFactoryJpa.getManager();
	    try {
	    	em.getTransaction().begin();
	    	p = em.merge(p);
	        TypedQuery<Comment> query = em.createQuery("SELECT c FROM comments c WHERE c.post = :postKey ORDER BY c.date DESC", Comment.class);
	        query.setParameter("postKey", p.getId());
	        List<Comment> comments = query.getResultList();
	        em.flush();
            em.getTransaction().commit();
        
	        return comments;
	    } catch (NoResultException e) {
	        e.printStackTrace();
	    } finally {
	    	if(em.isOpen()) {
	        em.close();
	    	}
	    }
	    return new ArrayList<Comment>();
	}

	
	
	@Override
	public boolean addComment(Comment c, User u, Post p) {	
		EntityManager em = DAOFactoryJpa.getManager();
        try {
            em.getTransaction().begin();
	        p = em.merge(p);
            u = em.merge(u);
            u.getComments().add(c);
            p.getComments().add(c);
	        em.persist(c);
	        em.flush();
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
	    	if(em.isOpen()) {
            em.close();
	    	}
        }
	}
}

