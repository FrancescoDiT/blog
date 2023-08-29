package polimi.blog.servlet.post;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polimi.blog.dao.DAOFactory;
import polimi.blog.model.Comment;
import polimi.blog.model.Post;
import polimi.blog.model.Tag;
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
		
		String post_id_string = request.getParameter("post_id");
		int post_id;
		Post p = new Post();
		
		if(post_id_string != null) {
			post_id = Integer.parseInt(post_id_string);
			p = DAOFactory.getDAOFactory().getPostDAO().findPostById(post_id);
		}

		if(p == null) {
			request.setAttribute("post-error", "There has been an error loading post, try again!");
			request.getRequestDispatcher("/WEB-INF/PostPages/PostPage.jsp").forward(request, response);
			return;
		}else {
			
			try {
				request.getSession().setAttribute("post", p);
			}catch (Exception e) {
				System.out.println("ERROR SETTING POST TO SESSION");
			}
			
		}
		Set<Tag> tags = new LinkedHashSet<>();
		
		try {
		 tags = DAOFactory.getDAOFactory().getTagDAO().findAllTagsOfPost(p);
		}catch (Exception e) {
			System.out.println("ERRORE PAZZO SGRAVATO DEL FINIMONDO ITERATIVO");
		}
		 
		 
		try {
			request.getSession().setAttribute("tags", tags);
		}catch (Exception e) {
			System.out.println("ERROR SETTING TAGS TO SESSION");
		}
		
		
		request.getRequestDispatcher("ReloadPostServlet").include(request, response);
		
	}



}
