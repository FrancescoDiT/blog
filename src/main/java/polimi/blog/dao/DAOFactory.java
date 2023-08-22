package polimi.blog.dao;

import polimi.blog.dao.model.UserDAO;
import polimi.blog.dao.model.PostDAO;
import polimi.blog.dao.model.TagDAO;
import polimi.blog.dao.model.CommentDAO;
import polimi.blog.dao.jpa.*;
public abstract class DAOFactory {

	public abstract UserDAO getUserDAO();
	public abstract PostDAO getPostDAO();
	public abstract TagDAO getTagDAO();
	public abstract CommentDAO getCommentDAO();
	
	public static DAOFactory getDAOFactory() {
		return new DAOFactoryJpa();
	}
	
}
 