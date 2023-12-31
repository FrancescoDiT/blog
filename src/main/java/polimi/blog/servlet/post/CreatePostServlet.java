package polimi.blog.servlet.post;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
		request.getRequestDispatcher("/WEB-INF/PostPages/CreatePostPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String tags = request.getParameter("tags");
		LocalDateTime date = LocalDateTime.now();
		Set<Tag> tagList = new LinkedHashSet<>();
		
		User u = new User();
		try {
			u = (User) request.getSession().getAttribute("user");
		}catch (Exception e) {
			System.out.println("ERROR GETTING USER FROM SESSION");
		}
		
		if(u==null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
		
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
				tagList = new LinkedHashSet<Tag>(TagParser.parseTags(tags));
			 }
			 
				Post p = new Post(title, content, date, u);
				
				if(!DAOFactory.getDAOFactory().getPostDAO().addPost(u, p)) {
					request.getSession().setAttribute("post-error", "error: could not load the post.");
					request.getRequestDispatcher("/WEB-INF/PostPages/CreatePostPage.jsp").forward(request, response);
					
				} else {
				tagList.forEach(t -> {
					
					if(!DAOFactory.getDAOFactory().getTagDAO().addTagToPost(p, t)) {
						
							request.getSession().setAttribute("post-error", "error: could not load the post.");
							try {
								request.getSession().setAttribute("post-error", "error: could not load the post.");
								request.getRequestDispatcher("/WEB-INF/PostPages/CreatePostPage.jsp").forward(request, response);
								return;
							} catch (ServletException e) {
								// TODO Auto-generated catch block
								System.err.println("SERVLET EXCEPTION");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.err.println("IOEXCEPTION");
							}
						}
					});	
				
						try {
							request.getSession().setAttribute("post", p);
						}catch (Exception e) {
							System.err.println("ERROR SETTING POST TO SESSION");
						}
						
						try {
							request.getSession().setAttribute("tags", tagList);
						}catch (Exception e) {
							System.err.println("ERROR SETTING TAGS TO SESSION");
						}
						
						
						request.getRequestDispatcher("/WEB-INF/PostPages/PostPage.jsp").forward(request, response);
						return;
				}		
			 }
		request.getRequestDispatcher("/WEB-INF/PostPages/CreatePostPage.jsp").forward(request, response);
		}

	}

