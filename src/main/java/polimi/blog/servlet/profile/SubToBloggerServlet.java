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
 * Servlet implementation class SubToBloggerServlet
 */
@WebServlet("/SubToBloggerServlet")
public class SubToBloggerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubToBloggerServlet() {
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
		User u = (User) request.getSession().getAttribute("user");
		User b = (User) request.getSession().getAttribute("searcheduser");
		boolean subcheck = DAOFactory.getDAOFactory().getUserDAO().checkSub(u, b);
		System.out.println("STATO SUB................. :"+subcheck);
		
		if(subcheck) {
			DAOFactory.getDAOFactory().getUserDAO().unsubToBlogger(u, b);
			System.out.println("TOLGO IL FOLLOWER................");
			request.getRequestDispatcher("/WEB-INF/ProfilePages/ProfilePage.jsp").forward(request, response);
			return;
		} else { 
			DAOFactory.getDAOFactory().getUserDAO().subToBlogger(u, b);
			System.out.println("AGGIUNGO IL FOLLOWER................");
			request.getRequestDispatcher("/WEB-INF/ProfilePages/ProfilePage.jsp").forward(request, response);
			return;
		}
	}

}
