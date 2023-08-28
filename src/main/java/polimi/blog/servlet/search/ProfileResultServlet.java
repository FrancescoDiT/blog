package polimi.blog.servlet.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polimi.blog.dao.DAOFactory;
import polimi.blog.model.User;

/**
 * Servlet implementation class ProfileResultServlet
 */
@WebServlet("/ProfileResultServlet")
public class ProfileResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().removeAttribute("counter");
		request.getRequestDispatcher("/WEB-INF/HomePage/HomePage.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> morePopular = DAOFactory.getDAOFactory().getUserDAO().getMorePopular();

		List<Long> counter = new ArrayList<>();
		try {
			request.getSession().setAttribute("morepopular", morePopular);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for(User u : morePopular) {
			counter.add(DAOFactory.getDAOFactory().getUserDAO().countAllMyFollowers(u));
		}
		
		try {
			request.getSession().setAttribute("counter", counter);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.getRequestDispatcher("/WEB-INF/SearchPages/ProfileResultPage.jsp").forward(request, response);

	}

}
