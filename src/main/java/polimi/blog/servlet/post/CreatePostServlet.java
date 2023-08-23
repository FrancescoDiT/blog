package polimi.blog.servlet.post;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import polimi.blog.dao.DAOFactory;
import polimi.blog.model.Post;
import polimi.blog.model.Tag;
import polimi.blog.model.User;
import polimi.blog.utilities.TagParser;

/**
 * Servlet implementation class CreatePostServlet
 */
@WebServlet("/CreatePostServlet")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String tags = request.getParameter("tags");
		LocalDateTime date = LocalDateTime.now();
		List<Tag> tagList = new ArrayList<>();
		
		if (title == null || title.isEmpty()) {
			try {
				request.setAttribute("title-error", "empty field.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (content == null || content.isEmpty()) {
			try {
				request.setAttribute("content-error", "empty field.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			
			 if (tags != null && !tags.isEmpty()) {
				tagList = TagParser.parseTags(tags);
			 }
			
				User u = (User) request.getSession().getAttribute("user");
				Post p = new Post(title, content, date, u);
				DAOFactory.getDAOFactory().getPostDAO().addPost(u, p);
				
				tagList.forEach(t -> {DAOFactory.getDAOFactory().getTagDAO().addTagToPost(p, t);});
				
				request.getSession().setAttribute("post", p);
				request.getRequestDispatcher("/WEB-INF/PostPages/PostPage.jsp").forward(request, response);
				return;
			 }
		request.getRequestDispatcher("/WEB-INF/PostPages/CreatePostPage.jsp").forward(request, response);
		}

	}

