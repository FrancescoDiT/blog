package polimi.blog.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polimi.blog.dao.DAOFactory;
import polimi.blog.model.User;
import polimi.blog.utilities.EmailValidator;
import polimi.blog.utilities.PasswordValidator;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedpassword");
		LocalDateTime creationDate = LocalDateTime.now();
		
		if (username == null || username.isEmpty()) {
			try {
				request.setAttribute("username-error", "empty field.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (username.length() > 32) {
			try {
				request.setAttribute("username-error", "username is too long.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (email == null || email.isEmpty()) {
			try {
				request.setAttribute("email-error", "empty field.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (!EmailValidator.isValidEmail(email)) {
			try {
				request.setAttribute("email-error", "email is not valid.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (password == null || password.isEmpty()) {
			try {
				request.setAttribute("password-error", "empty field.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (!PasswordValidator.isPasswordSecure(password)) {
			try {
				request.setAttribute("password-error", "password is not secure enough.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (repeatedPassword == null || repeatedPassword.isEmpty()) {
			try {
				request.setAttribute("repeatedpassword-error", "empty field.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (!password.equals(repeatedPassword)) {
			try {
				request.setAttribute("repeatedpassword-error", "not the same password.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (!DAOFactory.getDAOFactory().getUserDAO().signUp(username, email, password, creationDate)) {
			try {
				request.setAttribute("general-error", "Data already present.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			User u = new User(username,email,password,creationDate);
			try {
				request.getSession().setAttribute("user", u);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/PostPages/CreatePostPage.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("SignUp.jsp").forward(request, response);
	}
}
