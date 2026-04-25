package main;

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

@WebFilter("////")
public class filterPaging implements Filter {

    public filterPaging() {
    	System.out.println("filterPaging 생성자 실행");
    }

	public void destroy() {
		System.out.println("filterPaging 소멸자 실행");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		long before = System.currentTimeMillis(); // 처음
		System.out.println("filterPaging 실행 전");
		
		chain.doFilter(request, response);
		
		// 요청 한글 꺠짐 방지
		request.setCharacterEncoding("utf-8");
		
		// http만 사용하는 것이 아니라서 부모 형태로 받았음. 형 변환 필요.
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String path = req.getServletPath(); 
		System.out.println( "ServletPath : " + path );
		
		//if( isExclude(path) ) {
			System.out.println("filterPaging login [Not Need]");
			//chain.doFilter(request, response);
		//}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filterPaging init 실행 ~-* ");
	}
	
	private boolean isExclude(String path) {
		return
		   path.startsWith("/assets") // 시작하는 것이 assets
		|| path.equals("/list")
		|| path.equals("/emp.jsp")
		;
	}

}
