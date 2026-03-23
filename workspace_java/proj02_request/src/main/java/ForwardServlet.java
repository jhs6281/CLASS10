
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/forward의 doGet 실행");

		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

		String text = request.getParameter("text");
		System.out.println("text : " + text);

		response.getWriter().println("/another의 응답");

		// setAttribute
		request.setAttribute("item", "롱소드");

//		RequestDispatcher dispatcher = request.getRequestDispatcher("another");
//		dispatcher.forward(request, response);
		// 한 줄로 축약 가능
		request.getRequestDispatcher("another").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/forward의 doPost 실행");

		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

//		String text = request.getParameter("text");
//		System.out.println("text : " + text);

		// response 관련된 함수 -> 덮어쓰기 당해서 없어진다.
		response.getWriter().println("/forward의 응답"); // 없어짐

//		RequestDispatcher dispatcher = request.getRequestDispatcher("another");
//		dispatcher.forward(request, response);
		request.getRequestDispatcher("another").forward(request, response);
	}

}
