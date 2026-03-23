
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
		System.out.println("HelloServlet 생성자 실행");
	}

	@Override
	// protected -> 다른 패키지에서도 상속받은 것은 사용 가능
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// writer -> out.print / append에 넣어 전송
//		response.getWriter().append("<h1>Hello Servlet</h1>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		// getWriter() == out.print
		PrintWriter out = response.getWriter();
		out.println("<h1>");
		out.print("Hello Servlet");
		out.println("</h1>");

		for (int i = 0; i < 10; i++) {
			if (Math.random() < 0.5) {
				out.println(i);
				out.println("<br>");
			}
		}
	}

	@Override
	// doGet과 같은 것
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
