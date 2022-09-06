
import login.User;
import login.Login;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		try {
			String fName = request.getParameter("fname");
			String lName = request.getParameter("lname");
			String email = request.getParameter("email");
			String id = request.getParameter("id");
			String mobile = request.getParameter("mobile");
			String dob = request.getParameter("dob");
			
			
			User user = new User(fName, lName, email, id, mobile, dob);
			Login log = user.generateCred();
			user.saveToDB();
			log.saveToDB();
			
			
			PrintWriter out = response.getWriter();
			out.print("Registration Successful! \nYour username is: " + log.getUsername() + "\nYour password is: " + log.getPassword());
			
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
			PrintWriter out = response.getWriter();
			out.print("Registration failed.");
		}
	}

}
