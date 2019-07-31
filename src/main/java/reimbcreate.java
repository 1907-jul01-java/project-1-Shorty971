

import java.io.IOException;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class reimbcreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// TODO Auto-generated method stub
		String reimbtype = request.getParameter("type");
		String reimbvalue =  request.getParameter("amount");
		System.out.print(reimbvalue);
		Userdao userdao = new Userdao();
		HttpSession session = request.getSession(false);
		Random rand = new Random(); 
        int id = rand.nextInt(1000); 
        String name = (String) session.getAttribute("name");
		System.out.println("howdy");
		
		int value = Integer.parseInt(reimbvalue);
		
	//	Enumeration<String> auth =  session.getAttributeNames();
		int auth = (Integer) session.getAttribute("Authority");
        if(auth == 1) {
		Reimburstment reim = new Reimburstment(id, name, value, reimbtype, "Pending");
		userdao.makereim(reim);
		response.sendRedirect("loggedinuser.html");
        }
		else if(auth == 2) {
			}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
