

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class FilterCoopang implements javax.servlet.Filter {

    public FilterCoopang() {
    	System.out.println("filtercoop 생성자 실행");
    }

	public void destroy() {
		System.out.println("filtercoop 소멸자 실행");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		long before = System.currentTimeMillis(); // 처음
		request.setCharacterEncoding("utf-8");
		System.out.println("Before filter");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String path = req.getServletPath();
		System.out.println( "ServletPath : " + path );
		
		// pass the request along the filter chain
		if(isExlude(path)) {
			System.out.println("filter login [Not Need]");
			chain.doFilter(request, response);
		} else { 
			
			System.out.println("filter login [Need]");
			
			HttpSession session = req.getSession(); // login session
			boolean loginChk = (boolean)session.getAttribute("login");
			
			if(loginChk) { // need login [pass]
				
				System.out.println("filter login [Checked]");
				chain.doFilter(request, response);
				
			} else { // need login [un pass]
				System.out.println("filter login [Fail] : [" + path + "]");
				resp.sendRedirect(req.getContextPath() + "/needLogin.jsp");
			}
		}
		
		System.out.println("After filter ");
		
		long after = System.currentTimeMillis(); // 처음
		System.out.println( path + " 걸린 시간 : " + (after-before));
	}

	/**
	 * @see FilterCoopang#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filtercoop init 실행 ~-* ");
	}
	
	private boolean isExlude(String path) {
		return // main
			   path.startsWith("/assets")
			|| path.equals("/main")
			|| path.equals("/main.jsp")
			|| path.equals("/needLogin.jsp")
			|| path.equals("/coopang")
				// user
			|| path.equals("/login.jsp")
			|| path.equals("/signIn.jsp")
			|| path.equals("/user")
				// item
			|| path.equals("/item_detail.jsp")
			|| path.equals("/itemList.jsp")
			|| path.equals("/item")
			;
	}

}
