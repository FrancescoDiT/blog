package polimi.blog.servlet.profile;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polimi.blog.dao.DAOFactory;
import polimi.blog.model.User;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User u = (User) request.getSession().getAttribute("user");
		User su;
		String username = (String) request.getParameter("username");
		if(u.getUsername().equals(username)) {
			request.getSession().setAttribute("counter", DAOFactory.getDAOFactory().getUserDAO().countAllMyFollowers(u));
			request.getRequestDispatcher("/WEB-INF/ProfilePages/PersonalProfilePage.jsp").forward(request, response);
			request.getSession().removeAttribute("username");
			return;
		}else {
			su = DAOFactory.getDAOFactory().getUserDAO().getUserByUsername(username); //gestisci no result exception
			request.getSession().setAttribute("searcheduser", su);
			request.getSession().setAttribute("counter", DAOFactory.getDAOFactory().getUserDAO().countAllMyFollowers(su));
			request.getSession().setAttribute("checksub", DAOFactory.getDAOFactory().getUserDAO().checkSub(u, su));
			request.getRequestDispatcher("/WEB-INF/ProfilePages/ProfilePage.jsp").forward(request, response);

		}
		
	}

}
