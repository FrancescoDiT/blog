package polimi.blog.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import polimi.blog.dao.*;
import polimi.blog.dao.model.CommentDAO;
import polimi.blog.dao.model.PostDAO;
import polimi.blog.dao.model.TagDAO;
import polimi.blog.dao.model.UserDAO;

public class DAOFactoryJpa extends DAOFactory{

	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		return UserDAOJpa.getInstance();
	}

	@Override
	public PostDAO getPostDAO() {
		// TODO Auto-generated method stub
		return PostDAOJpa.getInstance();
	}

	@Override
	public TagDAO getTagDAO() {
		// TODO Auto-generated method stub
		return TagDAOJpa.getInstance();
	}

	@Override
	public CommentDAO getCommentDAO() {
		// TODO Auto-generated method stub
		return CommentDAOJpa.getInstance();
	}

	public static EntityManager getManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog");
		return emf.createEntityManager();
	}
}
