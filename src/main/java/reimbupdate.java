

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class reimbupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public reimbupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Userdao userdao = new Userdao();
		HttpSession session = request.getSession(false);
		String id = request.getParameter("ID");
		int Id = Integer.parseInt(id);
		userdao.Acceptedrequest(Id);
		response.sendRedirect("loggedinuser.html");
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
