
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req") // search 와 같은 부분. / 서블렛에서 class와 같은 부분
public class RequestServlet extends HttpServlet {

	// get - 주로 조회할 때 사용된다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/req doGet 실행");
		
		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");
		
		String id = request.getParameter("id");
		System.out.println("id : " + id);

		String pw = request.getParameter("pw");
		System.out.println("pw : " + pw);

		// 없다면 null
		System.out.println(request.getParameter("pw2"));

		// 체크박스 type.
		// 여러개일 때는 맨 첫번째 값만 가져온다. item1
//		String item = request.getParameter("item");
//		System.out.println("item : " + item);

		System.out.println("-------------------");

		// 여러개일 때
		String[] items = request.getParameterValues("item");
//		System.out.println("0" + items.length);
		if (items != null) {
			for (String item : items) {
				System.out.println("item : " + item);
			}
		}
		
		// none 과 hidden도 전송 가능하다. (CSS는 무관하다)
		String none = request.getParameter("none");
		System.out.println( "none : " + none );
		String hidden = request.getParameter("hidden");
		System.out.println( "hidden : " + hidden );
		
		// 버튼은 전송 불가능하다.
		System.out.println("btn1 : " + request.getParameter("btn1"));
		System.out.println("btn2 : " + request.getParameter("btn2"));
		
		// select는 한 개의 값만 와서 getParameter로 충분
		// 1개도 배열로 올 수 있다는 것 연습한 것 뿐
		String[] select = request.getParameterValues("select");
		if (select != null) {
			for (String item : select) {
				System.out.println("롤 아이템 : " + item);
			}
		}
		
		System.out.println("radio1 : " + request.getParameter("radio1"));
		System.out.println("txtarea : " + request.getParameter("txtarea"));
		
		System.out.println("date1 : " + request.getParameter("date1"));
		
		response.getWriter().println("[{\"key\":1234}, {\"key2\":12345}]");
		
		
	}

	// Post - 주로 행동을 할 때 사용된다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/req doPost 실행");
		
		// 한글 깨짐 방지
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");
		
		System.out.println("id : " + request.getParameter("id2"));
	}

}
