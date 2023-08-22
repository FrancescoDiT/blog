package polimi.blog.dao.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import polimi.blog.dao.jpa.UserDAOJpa;
import polimi.blog.dao.model.UserDAO;
import polimi.blog.model.User;

public class UserDAOJpa implements UserDAO{


	private static UserDAOJpa instance = new UserDAOJpa();
	
	private UserDAOJpa() {};
	
	public static UserDAOJpa getInstance() {
		return instance;
	}

	@Override
	public List<User> findAllUsers() {
	    EntityManager em = DAOFactoryJpa.getManager();
	    TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
	    
	    try {
	        List<User> users = query.getResultList();
	        return users;
	    } catch (NoResultException e) {
	        e.printStackTrace();
	        return null; 
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	}

	
	@Override
	public boolean signUp(String username, String email, String password, LocalDateTime creationDate) {
	    User u = new User(username, email, password, creationDate);
	    EntityManager em = DAOFactoryJpa.getManager();
	    EntityTransaction et = em.getTransaction();
	    try {
	        et.begin();
	        em.persist(u);
	        et.commit();
	        return true;
	    } catch (RollbackException e) {
	        if (et.isActive()) {
	            et.rollback(); 
	        e.printStackTrace();
	        }
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return false;
	}

	
	@Override
	public User loginEmail(String email, String password) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    try {
	        TypedQuery<User> q = em.createQuery(
	        		"SELECT u FROM users u WHERE (u.username = :emailKey OR u.email = :emailKey) AND u.password = :passwordKey",
	        		User.class);
	        q.setParameter("emailKey", email);
	        q.setParameter("passwordKey", password);
	        return q.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	}
	
	
	public User findABlogger(String username) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    try {
	        Query q = em.createQuery("SELECT u FROM users u WHERE u.username = :usernameKey");
	        q.setParameter("usernameKey", username);
	        return (User) q.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	}
	
	public boolean subToBlogger(User fr, User fd) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    EntityTransaction transaction = em.getTransaction();
	    try {
	        transaction.begin();
	        fr.getFollowedUsers().add(fd);
	        fd.getFollowingUsers().add(fr);
	        em.persist(fd);
	        em.persist(fr);
	        transaction.commit();
	        return true;
	    } catch (Exception e) {
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return false;
	}

	
	public List<User> findAllMyFollowers(User u) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    TypedQuery<User> q = em.createQuery(
	        "SELECT u FROM users u JOIN u.followingUsers fu WHERE fu.id = :userIdKey",
	        User.class);
	    q.setParameter("userIdKey", u.getId());
	    
	    try {
	        return q.getResultList();
	    } catch (NoResultException e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return null;
	}
	
	public int countAllMyFollowers(User u) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    TypedQuery<Long> q = em.createQuery(
	        "SELECT COUNT(u) FROM users u JOIN u.followingUsers fu WHERE fu.id = :userIdKey",
	        Long.class);
	    q.setParameter("userIdKey", u.getId());
	    try {
	        Long result = q.getSingleResult();
	        return result.intValue();
	    } catch (NoResultException e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return -1;
	}

	
	public List<User> findAllWhoIFollow(User u) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    TypedQuery<User> q = em.createQuery(
	        "SELECT u FROM users u JOIN u.followedUsers fu WHERE fu.id = :userIdKey",
	        User.class);
	    q.setParameter("userIdKey", u.getId());
	    try {
	        List<User> result = q.getResultList();
	        return result;
	    } catch (NoResultException e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	    return null;
	}

	
	public int countAllWhoIFollow(User u) {
	    EntityManager em = DAOFactoryJpa.getManager();
	    TypedQuery<Long> q = em.createQuery(
	        "SELECT COUNT(u) FROM users u JOIN u.followedUsers fu WHERE fu.id = :userIdKey",
	        Long.class);
	    q.setParameter("userIdKey", u.getId());
	    try {
	        Long result = q.getSingleResult();
	        return result.intValue();
	    } catch (NoResultException e) {
	        e.printStackTrace();
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }  
	    return -1;
	}

	
	

	

	
}