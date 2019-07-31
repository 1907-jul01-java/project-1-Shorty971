

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;


public class loginchecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public loginchecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Userdao userdao = new Userdao();
	    
		String name = req.getParameter("Username");
		String pass = req.getParameter("Password");
		
		HttpSession session = req.getSession(false);
		session = req.getSession();
		User loggedin =	userdao.getUser(name,pass);
		if(loggedin != null) {
			session.setAttribute("name", name);
			session.setAttribute("pass", pass);
			resp.sendRedirect("loggedinuser.html"); 
		}
		else {
			resp.sendRedirect("/proj1/index.html");
			
		}
	}
}