
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import enums.TypeSkill;
import model.Address;
import model.UserSkill;
import repository.UserRepository;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = this.createUser(request, response);
		if (!UserRepository.contains(user)) {
			UserRepository.addUser(user);
			RequestDispatcher rd = request.getRequestDispatcher("register_success.html");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("register_failed.html");
			rd.forward(request, response);

		}
	}

	private User createUser(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		user.setFirstName(request.getParameter("first_name"));
		user.setSecondName(request.getParameter("second_name"));
		user.setFamilyName(request.getParameter("last_name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setAddress(new Address(request.getParameter("city"),request.getParameter("street")));
		user.setJobName(request.getParameter("job"));
		user.setDescription(request.getParameter("description"));
		user.setPhoneNumber(request.getParameter("phone_number"));
		user.setSkills(makeSkillList());
		return user;
	}
	
	private List<UserSkill> makeSkillList(){
		List<UserSkill> skills = new ArrayList<>();
		UserSkill skillOne = new UserSkill("Driving",TypeSkill.PROFESSIONAL);
		UserSkill skillTwo = new UserSkill("Swiming",TypeSkill.PROFESSIONAL);
		UserSkill skillThree = new UserSkill("Coding",TypeSkill.PROFESSIONAL);
		UserSkill skillFour = new UserSkill("Speaking",TypeSkill.SOCIAL);
		UserSkill skillFive = new UserSkill("Chating",TypeSkill.SOCIAL);
		skills.add(skillOne);
		skills.add(skillThree);
		skills.add(skillTwo);
		skills.add(skillFour);
		skills.add(skillFive);
		return skills;
	}
}
