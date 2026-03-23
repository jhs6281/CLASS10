
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

		System.out.println("/redirect doGet 실행");
		
		String text = request.getParameter("text");
		System.out.println("redirect text [GET] : " + text);
		
		request.setAttribute("item", "롱소드");
		response.getWriter().println("/redirect의 응답");
		
//		response.sendRedirect("/proj02_request/another?text="+text);
		response.sendRedirect("/proj02_request/another");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

		System.out.println("/redirect doPost 실행");
		
		String text = request.getParameter("text"); //리스너
		System.out.println("redirect text [POST] : " + text);
		
		request.setAttribute("item", "롱소드");
		response.getWriter().println("/redirect의 응답 [POST]");
		
		response.sendRedirect("/proj02_request/another?text="+text);
	}

}
