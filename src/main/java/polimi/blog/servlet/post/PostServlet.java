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
		Post p = (Post) request.getSession().getAttribute("post");
		User u = (User) request.getSession().getAttribute("user");
		String content = request.getParameter("comment");
		
		if(content == null || content.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/PostPages/PostPage.jsp").forward(request, response);
			return;
			
		}else {
			Comment c = new Comment(content, LocalDateTime.now(), u, p);
			DAOFactory.getDAOFactory().getCommentDAO().addComment(c, u, p);
			request.getSession().setAttribute("post", p);
		}
		
		request.getRequestDispatcher("/WEB-INF/PostPages/PostPage.jsp").forward(request, response);
		
	}

}
