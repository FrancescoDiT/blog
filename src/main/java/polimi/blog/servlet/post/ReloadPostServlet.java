package polimi.blog.servlet.post;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

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
 * Servlet implementation class OverridePostServlet
 */
@WebServlet("/ReloadPostServlet")
public class ReloadPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReloadPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		try {
			u = (User) request.getSession().getAttribute("user");
		}catch (Exception e) {
			System.out.println("ERROR GETTING USER FROM SESSION");
		}
		
		if(u == null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
		
		Post p = new Post();
		
		try {
			p = (Post) request.getSession().getAttribute("post");
		}catch (Exception e) {
			System.out.println("ERROR GETTING POST FROM SESSION");
		}
		
		String content = request.getParameter("comment");
		
		if(content == null || content.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/PostPages/PostPage.jsp").forward(request, response);
			return;
			
		}else {
			Comment c = new Comment(content, LocalDateTime.now(), u, p);
			DAOFactory.getDAOFactory().getCommentDAO().addComment(c, u, p);
			try {
			request.getSession().setAttribute("post", p);
			}catch (Exception e) {
				System.out.println("ERROR SETTING POST TO SESSION");
			}
			
			Set<Comment> comments = DAOFactory.getDAOFactory().getCommentDAO().findAllCommentsOfPost(p);
			
			try {
				request.getSession().setAttribute("comments", comments);
			}catch (Exception e) {
				System.out.println("ERROR SETTING COMMENTS TO SESSION");
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/PostPages/PostPage.jsp").forward(request, response);

		
	}

}
