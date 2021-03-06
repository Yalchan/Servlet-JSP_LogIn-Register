

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import repository.UserRepository;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/login")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = logInValidation(email,password);
			if(user!=null) {
				request.setAttribute("user", user);
				RequestDispatcher rd=request.getRequestDispatcher("user_page.jsp");  
		        rd.forward(request,response);	
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("invalid_log_in.html");  
		        rd.forward(request,response); 
			}
	}
		public User logInValidation(String email, String password) {
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user = UserRepository.getUser(user);
			return user;
		}

}
