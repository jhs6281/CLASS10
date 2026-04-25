package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cookie/get")

public class GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		boolean isPopup = true;
		
		// 만약 쿠키가 하나도 없는 경우 null / 모든 쿠키 가져오기
		Cookie[] cookies = request.getCookies();
		
		
		if(cookies != null) {
			for( Cookie c : cookies ) {
				String name = c.getName();
				String value = c.getValue();
				
				System.out.printf("%s, %s\n", name, value);
				
				// 15초 동안 
				if("popup".equals(c.getName())
						&& "N".equals(c.getValue())) {
					isPopup = false; 
				}
			}
		}
		
		if(isPopup) {
			response.getWriter().print("팝업");
		}
		
	 	
	}


}
