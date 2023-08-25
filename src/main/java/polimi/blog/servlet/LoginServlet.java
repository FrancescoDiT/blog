package polimi.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polimi.blog.dao.DAOFactory;
import polimi.blog.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstCredential = request.getParameter("username");
		String password = request.getParameter("password");
		User u = DAOFactory.getDAOFactory().getUserDAO().loginEmail(firstCredential, password);

		if (firstCredential == null || firstCredential.isEmpty()) {
			try {
				request.setAttribute("username-error", "Empty field.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (password == null || password.isEmpty()) {
			try {
				request.setAttribute("password-error", "Empty field.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if (u == null) {
			request.setAttribute("general-error", "Wrong credentials. Please try again.");
		} else {
			try {
				request.getSession().setAttribute("user", u);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/HomePage/HomePage.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
