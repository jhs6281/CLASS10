package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     * 생성자
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("LoginFilter 생성자 실행");
    }

	/**
	 * @see Filter#destroy()
	 * 소멸자
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("LoginFilter 소멸자 실행");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here 서블릿 실행 전
		long before = System.currentTimeMillis(); // 처음
		System.out.println("doFilter 실행 전");
		
		// 요청 한글 꺠짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답 한글 깨짐 방지 + 응답의 형식이 html이다
		// 모든 text를 html로 return 하기 때문에, 
		// json, file download 등을 인식할 수 없다.
		// jsp에는 기본적으로 있어서 필요할 때 사용하자. 
		// response.setContentType("text/html; charset=utf-8;");
		
		// http만 사용하는 것이 아니라서 부모 형태로 받았음. 형 변환 필요.
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String path = req.getServletPath(); // 
		System.out.println( "ServletPath : " + path );
		
//		if(path.equals("/login.jsp") 
//				|| path.indexOf("/assets") != -1 // index에 있다면 (파일명이 /assets라면? : 만들지 마...) 
//				|| path.startsWith("/assets") // 시작하는 것이 assets
//				|| path.endsWith(".css") // 설정 많이 필요 js, img, 등등 
//				|| path.equals("/login") 
//				) { // 로그인 필터링
			// 세션 없이 진행
		if( isExclude(path) ) {
			System.out.println("filter login [Not Need]");
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			String login = (String)session.getAttribute("login");
			
			if("Y".equals(login)) {
				// 로그인
				System.out.println("filter login [OK]");
				chain.doFilter(request, response);
				
			} else {
				// 로그인 아님
				System.out.println("filter login [FAIL] : [" + path + "]");
				resp.sendRedirect( req.getContextPath() + "/login.jsp"); // 주소 주의
			}
			
		}
		
		System.out.println( "doFilter 실행 후" );
		
		long after = System.currentTimeMillis(); // 처음
		System.out.println( path + " 걸린 시간 : " + (after-before));
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 * init
	 * 생성자 실행 후 바로 실행
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("LoginFilter init 실행 ~-* ");
	}
	
	private boolean isExclude(String path) {
		return
		   path.equals("/login.jsp")
		|| path.indexOf("/assets") != -1 // index에 있다면 (파일명이 /assets라면? : 만들지 마...) 
		|| path.startsWith("/assets") // 시작하는 것이 assets
		|| path.endsWith(".css") // 설정 많이 필요 js, img, 등등 
		|| path.equals("/login")
		|| path.equals("/delay")
		;
	}

}
