package signInController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signInDAO.SignInDAO;
import signInDTO.SignInDTO;
import signInService.SignInService;

@WebServlet("/signIn")
public class SignInController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/signIn [doGet 실행]");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/signIn [doPost 실행]");
		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

		// 회원가입 페이지로부터 데이터 받아왔다.
		// (방어 코딩 필요)
		// if 빈 칸이 아닐 때
		// if 숫자
		int empno = Integer.parseInt(request.getParameter("empno"));
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hiredate");

		System.out.println("추가된 튜플 : id: " + id + ", pw: " + pw + ", email:" + email + ", empno:" + empno + ", hireDate:" + hireDate + " ");

		// 데이터 받기 성공 > 어디로 보낼 지?

		// 회원가입.html -> DB
		SignInDTO dto = new SignInDTO();

		SignInDAO dao = new SignInDAO();
		dao.insertDB(id, pw, email, empno, hireDate);

		SignInService service = new SignInService();
		// DB에서 json 형태로 바꾼 것 가져오기
		String toJson = service.toJson();

		//PrintWriter out = response.getWriter();
		//out.println(toJson); // 작성
		
		
		// 회원가입 완료 페이지로 redirect
		response.sendRedirect("/proj00_exam/sign.html");
		
		// 보안 문제 뭐시기로 안됨
		
	}
	
	

}
