package polimi.blog.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import polimi.blog.dao.jpa.TagDAOJpa;
import polimi.blog.dao.model.TagDAO;
import polimi.blog.model.Post;
import polimi.blog.model.Tag;

public class TagDAOJpa implements TagDAO{


	private static TagDAOJpa instance = new TagDAOJpa();
	
	private TagDAOJpa() {};
	
	public static TagDAOJpa getInstance() {
		return instance;
	}
	
	@Override
	public List<Tag> findAllTag() {
	    EntityManager em = DAOFactoryJpa.getManager();

	    try {
	        TypedQuery<Tag> query = em.createNamedQuery("Tag.findAll", Tag.class);
	        List<Tag> tags = query.getResultList();
	        return tags;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return null;
	}
	
	public Tag findATag(String name) {
	    EntityManager em = DAOFactoryJpa.getManager();

	    try {
	        TypedQuery<Tag> q = em.createQuery(
	            "SELECT t FROM tags t WHERE t.name = :tagNameKey",
	            Tag.class);
	        q.setParameter("tagNameKey", name);
	        return q.getSingleResult();
	    } catch (NoResultException e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }

	    return null;
	}
	
	
	@Override
	public boolean addTagToPost(Post p, Tag t) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    
	    try {
	        em.getTransaction().begin();
	        TypedQuery<Tag> query = em.createQuery("SELECT t FROM tags t WHERE t.name = :tagName", Tag.class);
	        query.setParameter("tagName", t.getName());
	        List<Tag> existingTags = query.getResultList();
	        
	        if (existingTags.isEmpty()) {
	            em.persist(t);
	        } else {
	            t = existingTags.get(0);
	            t = em.merge(t);
	        }
	        p.getTags().add(t);

	        em.flush();
	        em.getTransaction().commit();
	        return true;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        em.getTransaction().rollback();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return false;
	}


	
	public List<Tag> findAllTagsOfPost(Post p) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    try {
	        TypedQuery<Tag> q = em.createQuery(
	            "SELECT t FROM tags t JOIN t.posts p WHERE p = :post",
	            Tag.class);
	        q.setParameter("post", p);
	        return q.getResultList();
	    } catch (NoResultException e) {
	        e.printStackTrace();
	        return null; 
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	}
	
	public List<Post> findAllPostOfTag(Tag t){
		
	    EntityManager em = DAOFactoryJpa.getManager();
	    try {
	        TypedQuery<Post> q = em.createQuery(
	            "SELECT p FROM posts p JOIN p.tags t WHERE t = :tagKey",
	            Post.class);
	        q.setParameter("tagKey", t);
	        return q.getResultList();
	    } catch (NoResultException e) {
	        e.printStackTrace();
	        return null; 
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
		
	}
	
}
