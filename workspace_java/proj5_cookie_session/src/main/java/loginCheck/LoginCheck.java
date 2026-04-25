package loginCheck;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.EmpDTO;

@WebServlet("/loginCheck")
public class LoginCheck extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		EmpDTO dto = new EmpDTO();
		dto.setEmpno(Integer.parseInt(request.getParameter("empno")));
		dto.setEname(request.getParameter("ename"));
	
		CheckService service = new CheckService();
		
		// db에서 로그인 한 dto를 받는다
		// 단 로그인 실패시 null -> 로그인 페이지
		EmpDTO result = service.select(dto);
		if ( result == null) {
			System.out.println("로그인 페이지");
			response.sendRedirect("loginCheck");
		} else {// 성공 시 세션 등록
			System.out.println("직업 : " + result.getJob());
			
			HttpSession session = request.getSession();
			session.setAttribute("dto", result);
			
			response.sendRedirect("list");
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
