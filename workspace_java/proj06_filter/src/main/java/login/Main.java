package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class Main extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String loginChk = (String) session.getAttribute("login");
		
		if("Y".equals(loginChk)) {
			System.out.println("/main [GET] 실행");
			
			request.setAttribute("passcode", "1234");
			request.setAttribute("암구호", "짜장면");
			
			// 숨기는 폴더 /WEB-INF/view
			request.getRequestDispatcher("/WEB-INF/view/secret.jsp").forward(request, response);
			
			
		} else {
			System.out.println("잘못된 접근입니다.");
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
