package polimi.blog.servlet.profile;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polimi.blog.dao.DAOFactory;
import polimi.blog.model.Post;
import polimi.blog.model.User;

/**
 * Servlet implementation class PersonalProfile
 */
@WebServlet("/PersonalProfileServlet")
public class PersonalProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		if(u==null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
		
		String info = (String) request.getParameter("info");		
		
		u = DAOFactory.getDAOFactory().getUserDAO().mergeUser(u);
		
		if(info != null) {
			info = info.trim();
			if(!info.isEmpty()) {
				u = DAOFactory.getDAOFactory().getUserDAO().addInfo(u, info);
			}
		}
			
		Long counter = DAOFactory.getDAOFactory().getUserDAO().countAllMyFollowers(u);
		
		try {
		request.getSession().setAttribute("counter", counter);
		}catch (Exception e) {
			System.out.println("ERROR SETTING COUNTER IN SESSION");
		}
		
		Set<Post> myPosts = DAOFactory.getDAOFactory().getPostDAO().findAllMyPosts(u);
		
		try {
			request.getSession().setAttribute("my_posts", myPosts);
		}catch (Exception e) {
			System.out.println("ERROR SETTING MYPOSTS IN SESSION");
		}
		
		request.getRequestDispatcher("/WEB-INF/ProfilePages/PersonalProfilePage.jsp").forward(request, response);

	}

}
