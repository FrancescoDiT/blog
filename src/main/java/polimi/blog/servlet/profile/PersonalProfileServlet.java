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
		
		User u = (User) request.getSession().getAttribute("user");
		String info = (String) request.getAttribute("info");
		
		if(info != null) {
		u = DAOFactory.getDAOFactory().getUserDAO().addInfo(u, info);
			}
		u = DAOFactory.getDAOFactory().getUserDAO().mergeUser_Posts(u);
		request.getSession().setAttribute("user", u);
		
		request.getRequestDispatcher("/WEB-INF/ProfilePages/PersonalProfilePage.jsp").forward(request, response);

	}

}
