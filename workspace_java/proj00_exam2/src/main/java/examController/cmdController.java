package examController;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examDTO.SignInDTO;
import examService.SignInService;

@WebServlet("/signIn")
public class cmdController extends HttpServlet {

	// cmd
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/signIn [doGet] 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		String cmd = request.getParameter("cmd");
		
		// null == 회원관리
		if (cmd == null) {
			selectGet(request, response);
		} else if (cmd.equals("insert")) {
			insertGet(request, response);
		} else if (cmd.equals("detail")) {
			detail(request, response);
		} else if (cmd.equals("update")) {
			updateGet(request, response);
		} else if (cmd.equals("modify")) {
			modify(request, response);
		} else if (cmd.equals("delete")) {
			delete(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// select
	protected void selectGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("select [doGet] 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		SignInDTO siDTO = new SignInDTO();

		// Service > DAO
		SignInService siService = new SignInService();
		request.setAttribute("DBlist", siService.select(siDTO));

		request.getRequestDispatcher("userManager.jsp").forward(request, response);

	}

	// insert
	protected void insertGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("insert [doGet] 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// Listen
		int empno = Integer.parseInt(request.getParameter("empno"));
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String hDate = request.getParameter("hireDate");

		// DTO
		SignInDTO siDTO = new SignInDTO();

		siDTO.setEmpno(empno);
		siDTO.setId(id);
		siDTO.setPw(pw);
		siDTO.setEmail(email);

		try {
			Date hireDate = Date.valueOf(hDate);
			siDTO.setHireDate(hireDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Service > DAO
		SignInService siService = new SignInService();
		siService.insert(siDTO);

		response.sendRedirect("userManager");
	}

	// detail
	protected void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("detail [doGet] 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// signIn a태그 - get 파라미터
		int num = Integer.parseInt(request.getParameter("num"));

		// DTO - 해당 정보 특정용 num 세팅
		SignInDTO siDTO = new SignInDTO();
		siDTO.setNum(num);

		// Service > DAO - selectOne
		SignInService siService = new SignInService();
		List list = siService.select(siDTO);

		// Forward > list
		request.setAttribute("list", list);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	// updateGet
	protected void updateGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("updateGet [doGet] 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// signIn a태그 - get 파라미터
		int num = Integer.parseInt(request.getParameter("num"));

		// DTO - 해당 정보 특정용 num 세팅
		SignInDTO siDTO = new SignInDTO();
		siDTO.setNum(num);
		
		// Service > DAO - selectOne
		SignInService siService = new SignInService();
		List list = siService.select(siDTO);

		// Forward > list
		request.setAttribute("list", list);
		request.getRequestDispatcher("modify.jsp").forward(request, response);

	}

	// modify
	protected void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("modify [doGet] 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		SignInDTO siDTO = new SignInDTO();
		siDTO.setNum(Integer.parseInt(request.getParameter("num")));
		siDTO.setEmpno(Integer.parseInt(request.getParameter("empno")));
		siDTO.setId(request.getParameter("id"));
		siDTO.setPw(request.getParameter("pw"));
		siDTO.setEmail(request.getParameter("email"));
		siDTO.setHireDate(Date.valueOf(request.getParameter("hireDate")));
		siDTO.setWorking(Integer.parseInt(request.getParameter("working")));

		// Service > DAO - updateDB
		SignInService siService = new SignInService();
		siService.update(siDTO);
		
		response.sendRedirect("/proj00_exam2/signIn");

	}

	// delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("delete [doGet] 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		List list = new ArrayList();
		String[] items = request.getParameterValues("num");
		
		for(String num : items) { 
			SignInDTO siDTO = new SignInDTO();
			siDTO.setNum(Integer.parseInt(num));
			list.add(siDTO);
		}
		
		// Service
		SignInService siService = new SignInService();
		siService.delete(list);
		
		response.sendRedirect("delete.jsp");

	}

}
