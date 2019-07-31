

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

public class reimb extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public reimb() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				Userdao userdao = new Userdao();
				HttpSession session = request.getSession(false);
				String name = (String) session.getAttribute("name");
				String pass = (String) session.getAttribute("pass");
				User loggedin =	userdao.getUser(name,pass);
				session.setAttribute("Authority", loggedin.getAuthority());
				if(loggedin.getAuthority() == 1) {
				List<Reimburstment> reim = userdao.getAllnamed(loggedin.getUsername());
				generatewrite(response,reim);
				}
				else if(loggedin.getAuthority() == 2) {
				List<Reimburstment> reim = userdao.getAll();
				generatewrite(response,reim);
				}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void generatewrite(HttpServletResponse response, List<Reimburstment> reim) {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try {
			response.getWriter().write(generateReimbJson(reim));
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


}
