package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage")
public class MyPage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		// 기존에 세션이 없으면 null
		// > 새로 만들지 않아서 다시 접속해도 null
		// 있으면 그걸 가져옴
		HttpSession session = request.getSession(false);

		if( session == null ) {
			System.out.println(" 서버 첫 방문. 로그인 창으로 이동합니다");
			
			response.getWriter().println("서버 첫 방문 <br>");
			response.getWriter().println("로그인도 안함 <br>");
			response.getWriter().println("로그인 페이지로 이동 <br>");
			
		} else {
			System.out.println( " 서버 켜고 첫 방문은 아님 ");
			Boolean login = (Boolean) session.getAttribute("login");
			if(login == null || login != true) {
				
				response.getWriter().println("서버 첫 방문은 아님 <br>");
				response.getWriter().println("로그인은 안함 <br>");
				response.getWriter().println("로그인 페이지로 이동 <br>");
//				response.sendRedirect("/proj00_coopang/user");
			} else if (!(login == null || login != true)) {
				response.getWriter().print("매우 사적이어서 로그인 해야만 올 수 있는 곳");
				response.getWriter().print("<br>");
				response.getWriter().print("userId : " + session.getAttribute("userId"));
				response.getWriter().print("<br>");
				
				// 1
				int level = (int) session.getAttribute("level");
				if ( level == 1 ) {
					response.getWriter().print("관리자");
				}
			} 
			
			
		}
	}

}
