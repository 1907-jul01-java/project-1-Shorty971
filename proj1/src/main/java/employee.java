

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

public class employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public employee() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Userdao userdao = new Userdao();
	    
		HttpSession session = request.getSession(false);
		String name = (String) session.getAttribute("name");
		String pass = (String) session.getAttribute("pass");
		User loggedin =	userdao.getUser(name,pass);
		List<Reimburstment> reim = userdao.getAllnamed(loggedin.getUsername());
		generatewrite(response,loggedin);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void generatewrite(HttpServletResponse response, User use) {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try {
			response.getWriter().write(generateUserJson(use));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private String generateReimbJson( List<Reimburstment> reim) {
		// TODO Auto-generated method stub
		List<Reimburstment> curlist = reim;
		String userstring = new Gson().toJson(curlist);
		System.out.println(userstring);
		return userstring;
	}
	private String generateUserJson(User loggedin) {
		// TODO Auto-generated method stub
		User curuser = loggedin;
		String userstring = new Gson().toJson(loggedin);
		System.out.println(userstring);
		return userstring;
	}


}
