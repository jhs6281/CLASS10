package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginCtrl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if("1234".equals(request.getParameter("pw"))) {
			HttpSession session = request.getSession();
			session.setAttribute("login", "Y");
			System.out.println("/login 세션 등록완료");
			request.getRequestDispatcher("main").forward(request, response);
			return;
			
		} else {
			System.out.println("비밀번호 틀림");
			response.sendRedirect("login.jsp");
			return;
		}
		
	}

}
