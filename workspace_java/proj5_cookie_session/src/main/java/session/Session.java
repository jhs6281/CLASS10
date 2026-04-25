package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class Session extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("/session doGet 실행");
	
		// 세션의 생명주기
		// 접속하면 30분(기본값) 생김
		
		
		// HttpSession - 톰캣 세션
		// 기존에 세션이 없으면 새로 만들어주고, 있다면 그것을 가져온다. ( new가 아닌 이유 )
		HttpSession session = request.getSession();
		
		// 기존에 세션이 없으면 null
		// 있으면 그걸 가져옴
		HttpSession session2 = request.getSession(false);
		
		
		
		
		session.setAttribute("k", "v"); // set
		session.getAttribute("k"); // get
		
		String id = session.getId();
		System.out.println( "getId() : " + id ); // 톰캣이 정해주는 아이디
		
		boolean isNew = session.isNew();
		System.out.println( "isNew() : " + isNew ); // 첫 접속인지
		
		// request라 forward로 보내야함
//		request.setAttribute("req", "req_v");
		
//		response.sendRedirect("session.jsp");
		
		String id2 = request.getParameter("id2");
		System.out.println("id2 test : " + id2);
		
		String level = request.getParameter("level");

		if("hs".equals(id2)) {
			session.setAttribute("login", true);
			session.setAttribute("userId", id2);
			session.setAttribute("level", 1);
			
		}
		
		
		//session.setAttribute("level", "1");
	}
}
