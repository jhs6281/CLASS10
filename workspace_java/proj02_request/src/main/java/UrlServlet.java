
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/url")
public class UrlServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/url doGet 실행");
		
		
		// ip 주소를 가져오기
		// localhost 0:0:0:0:0:0:0:1 ==> [::1] ipV6
		// 127.0.0.1 ipV4
		String ip = request.getRemoteAddr();
		System.out.println("ip: " + ip);
		
		String 종한ip = "192.168.0.98";
		
		// 접근 method 확인 GET / POST
		System.out.println("getMethod: " + request.getMethod());

		// 검색한 주소명 : http://192.168.0.25:8080/proj02_request/url
		// QueryString은 제외
		System.out.println("getRequestURL: " + request.getRequestURL());
		
		// QeryString ?다음값 : a=b
		System.out.println("getQueryString: " + request.getQueryString());
		
		// 파일의 절대 경로 : proj02_request/url
		System.out.println("getRequestURL: " + request.getRequestURI());

		// 최상위 폴더 : proj02_request
		// 프로젝트를 구분하는 주소
		System.out.println("getContextPath: " + request.getContextPath());

		// ContextPath를 제외한 뒤 주소
		System.out.println("getContextPath: " + request.getServletPath());
		
		
	}
}
