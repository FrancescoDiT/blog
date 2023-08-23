package polimi.blog.servlet.post;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polimi.blog.dao.DAOFactory;
import polimi.blog.model.Comment;
import polimi.blog.model.Post;
import polimi.blog.model.User;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
;		
		Comment c = new Comment(request.getParameter("comment"), LocalDateTime.now());
		Post p = (Post) request.getSession().getAttribute("post");
		User u = (User) request.getSession().getAttribute("user");
		
		DAOFactory.getDAOFactory().getCommentDAO().addCommentToPost(p, c);
		DAOFactory.getDAOFactory().getCommentDAO().addCommentToUser(c, u);
		request.getRequestDispatcher("/WEB-INF/PostPages/PostPage.jsp").forward(request, response);
		
	}

}
