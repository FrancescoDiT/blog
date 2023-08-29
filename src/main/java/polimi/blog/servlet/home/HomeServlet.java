package polimi.blog.servlet.home;

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


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
    }
    
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
		
        u = DAOFactory.getDAOFactory().getUserDAO().mergeUser(u);
		
        Set<Post> posts = DAOFactory.getDAOFactory().getPostDAO().findAllMyPostsByDate(u); 
		
		try {
			request.getSession().setAttribute("posts", posts);
		}catch (Exception e) {
			System.out.println("ERROR SETTING POSTS TO SESSION");
		}

		Set<User> followedUsers = DAOFactory.getDAOFactory().getUserDAO().findAllWhoIFollow(u);
		
		try {
			request.getSession().setAttribute("followed_users", followedUsers); 
		}catch (Exception e){
			System.out.println("ERROR SETTING FOLLOWED USERS TO SESSION");
		}
		
		request.getRequestDispatcher("/WEB-INF/HomePage/HomePage.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
