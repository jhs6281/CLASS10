package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/set")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// 쿠키 생성
		Cookie c1 = new Cookie("name", "최민수");

		// 만료기간 지정
		// c1.setMaxAge( 10 ); // 초
		c1.setMaxAge(60 * 60 * 24); // 초

		// 웹브라우저에 쿠키 전송
		response.addCookie(c1);

		// 만료일이 없는 쿠키 (세션 쿠키)
		// setMaxAge를 설정하지 않거나, -1값을 넣는다면 생성됨.
		// 브라우저의 모든 탭을 종료하면 사라짐 (하나라도 살아있다면 무제한) 다른탭에서 없음
		Cookie c2 = new Cookie("dinner", "국밥");
		c2.setMaxAge(-1);
		response.addCookie(c2);

		
		// 팝업 안보기 생성
		Cookie c3 = new Cookie("popup", "N");
		c3.setMaxAge(15); // 초
		response.addCookie(c3);

	}

}
