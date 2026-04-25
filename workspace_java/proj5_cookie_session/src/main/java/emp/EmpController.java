package emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/emp")
public class EmpController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 너무 폐쇄적인 공간이라 로그인 안하면 안 보여줌.
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		HttpSession session = request.getSession();
		
		EmpDTO empDTO = (EmpDTO)session.getAttribute("dto");
		if(empDTO == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		// 로그인 확인 .
		// emp 목록 조회 list에 차곡차곡 담기
		// 받아온 list를 목록 표시용 jsp로 보내고 표시 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
