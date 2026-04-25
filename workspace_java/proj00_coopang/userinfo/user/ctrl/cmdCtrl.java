package user.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dto.UserDTO;
import user.service.UserService;

@WebServlet("/user")
public class cmdCtrl extends HttpServlet { // cmd
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/user [doGet] 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		String cmd = request.getParameter("cmd");

		HttpSession session = request.getSession();
		
		// 로그인자 정보
		UserDTO ssdto = (UserDTO) session.getAttribute("loginDTO");
		
		if (cmd == null || cmd.isEmpty()) {
		    response.sendRedirect("coopang");
		    return;
		}

		switch (cmd) {
		case "signin":
		    request.getRequestDispatcher("signIn.jsp").forward(request, response);
		    return;

		case "loginPage":
		    request.getRequestDispatcher("login.jsp").forward(request, response);
		    return;

		case "insert":
		    insert(request, response);
		    return;

		case "login":
		    login(request, response);
		    return;

		case "list":
		    if (ssdto.getGrade() <= 3) {
		        list(request, response);
		        return;
		    }
		    break;

		case "detail":
		    detail(request, response);
		    return;

		case "logout":
		    logout(request, response);
		    return;

		case "delete":
		    delete(request, response);
		    return;

		case "update":
		    update(request, response);
		    return;

		case "modify":
		    modify(request, response);
		    return;
		}

		response.sendRedirect("coopang");
		
		// 비로그인
//		if (cmd == null) { // 로그인 페이지 이동
//			response.sendRedirect("coopang");
//		} else if (cmd.equals("signin")) { // 회원가입 페이지 이동
//			request.getRequestDispatcher("signIn.jsp").forward(request, response);
//		} else if (cmd.equals("loginPage")) { // 회원가입 페이지 이동
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		} else if (cmd.equals("insert")) { // 회원 가입 DB 저장
//			insert(request, response);
//		} else if (cmd.equals("login")) { // 로그인
//			login(request, response);
//		} 
//		  // 로그인 필요
//		  // 관리자
//		  else if (cmd.equals("list") && ssdto.getGrade() <= 3) { 
//			 System.out.println("관리자 로그인 : " + ssdto.getGrade());
//			 list(request, response);
//		} // 일반 회원
//		  else if (cmd.equals("detail")) { // 마이페이지
//			detail(request, response);
//		} else if (cmd.equals("logout")) { // 로그아웃
//			logout(request, response);
//		} else if (cmd.equals("delete")) { // 회원삭제
//			delete(request, response);
//		} else if (cmd.equals("update")) { // 회원수정 페이지
//			update(request, response);
//		} else if (cmd.equals("modify")) { // 회원수정
//			modify(request, response);
//		} 

		
//		if (cmd != null && (cmd.equals("detail") || cmd.equals("logout") || cmd.equals("delete") || cmd.equals("update")
//				|| cmd.equals("modify") || cmd.equals("list"))) {
//			needLogin = true;
//		}

//		if (needLogin) {

//			if (loginflag != null && loginflag) {

		
		
		
		
		
//			} else if (loginflag == null || !loginflag) {
		
//				response.sendRedirect("needLogin.jsp");
//				return;
//			}
//		}

	}

	// 회원 lsit
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("/user/list 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		UserDTO userdto = new UserDTO();

		UserService service = new UserService();

		request.setAttribute("userInfo", service.select(userdto));
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}

	// insert 회원가입
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("insert 실행");

		response.setContentType("text/html; charset=utf-8;");

		// Listen
		String user_nickname = request.getParameter("user_nickname");
		String user_email = request.getParameter("user_email");
		String user_name = request.getParameter("user_name");
		String user_tel = request.getParameter("user_tel");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_pwchk = request.getParameter("pwcheck");
		String user_addr = request.getParameter("user_addr");

		if (user_pw.equals(user_pwchk)) {
			System.out.println("비밀번호 일치");

			// DTO
			UserDTO userdto = new UserDTO();

			userdto.setUser_nickname(user_nickname);
			userdto.setUser_email(user_email);
			userdto.setUser_name(user_name);
			userdto.setUser_tel(user_tel);
			userdto.setUser_id(user_id);
			userdto.setUser_pw(user_pw);
			userdto.setUser_addr(user_addr);

			UserService service = new UserService();
			List list = service.select(userdto);
			
			if ( list.size() > 0 ) {
				UserDTO result = (UserDTO) list.get(0); // 중복검사
				String id = result.getUser_id();
				System.out.println(id);

				if (userdto.getUser_id().equals(id)) { // 중복된 아이디
					System.out.println("id 중복됨");
					response.sendRedirect("user?cmd=signin&msg=1");
					return;
				} else {
					// Service > DAO
					System.out.println("회원가입이 완료되었습니다.");
					service.insert(userdto); // 회원가입 성공
					request.getRequestDispatcher("user?cmd=loginPage").forward(request, response);
				}
			}
		} else { // 비밀번호 확인 불일치
			response.sendRedirect("user?cmd=signin&msg=2");
		}

	}

	// login
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/user/login 실행");

		response.setContentType("text/html; charset=utf-8;");

		// Listen
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		// DTO
		UserDTO userdto = new UserDTO();

		userdto.setUser_email(email);
		userdto.setUser_pw(pw);

		// Service > DAO
		UserService service = new UserService();
		List<UserDTO> userInfo = service.select(userdto); // 로그인 유저 정보 셋

		if (userInfo.size() == 0) {
			System.out.println("이메일 or 비밀번호 불일치");
			String msg = "user?cmd=loginPage&msg=1";
			response.sendRedirect(msg);
		} else if (userInfo.get(0).getUser_num() > 0) { // 로그인 성공

			HttpSession session = request.getSession();
			session.setAttribute("login", true);
			session.setAttribute("userInfo", userInfo.get(0));

			System.out.println("/login session dto : " + userInfo.get(0));
			response.sendRedirect("coopang");

		}
	}

	// detail
	protected void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/user/detail 실행");

		// a태그 - get 파라미터
		int num = Integer.parseInt(request.getParameter("num"));

		// DTO - 해당 정보 특정용 num 세팅
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_num(num);

		// Service > DAO - selectOne
		UserService service = new UserService();
		List userInfo = service.select(userDTO);

		// Forward > DTO
		request.setAttribute("userInfo", userInfo);
		request.getRequestDispatcher("mypage.jsp").forward(request, response);

	}

	// update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/user/updateGet [doGet] 실행");

		// a태그 - get 파라미터
		int num = Integer.parseInt(request.getParameter("num"));

		// DTO - 해당 정보 특정용 num 세팅
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_num(num);

		// Service > DAO - selectOne
		UserService service = new UserService();
		List userInfo = service.select(userDTO);

		// Forward > DTO
		request.setAttribute("userInfo", userInfo);
		request.getRequestDispatcher("modify.jsp").forward(request, response);

	}

	// modify
	protected void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/user/modify 실행");

		response.setContentType("text/html; charset=utf-8;");

		UserDTO userdto = new UserDTO();

		int num = Integer.parseInt(request.getParameter("num"));

		if (request.getParameter("user_pw") != null
				&& request.getParameter("user_pw").equals(request.getParameter("pw_chk"))) {

			userdto.setUser_num(num);
			userdto.setUser_nickname(request.getParameter("user_nickname"));
			userdto.setUser_email(request.getParameter("user_email"));
			userdto.setUser_name(request.getParameter("user_name"));
			userdto.setUser_tel(request.getParameter("user_tel"));
			userdto.setUser_id(request.getParameter("user_id"));
			userdto.setUser_pw(request.getParameter("user_pw"));
			userdto.setUser_pw(request.getParameter("pw_chk"));
			userdto.setUser_addr(request.getParameter("user_addr"));
			userdto.setHiredate(Date.valueOf(request.getParameter("hiredate")));
			userdto.setGrade(Integer.parseInt(request.getParameter("grade")));

			UserService service = new UserService();

			HttpSession session = request.getSession();
			session.setAttribute("userInfo", service.modify(userdto)); // 갱신
			System.out.println("세션이 수정되었습니다. ");
			response.sendRedirect("coopang");

		} else { // 비밀번호 != 비밀번호 확인
			response.sendRedirect("user?cmd=update&num=" + num + "&msg=1");
		}
	}

	// user delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/user/delete 실행");

		UserDTO userdto = new UserDTO();
		userdto.setUser_num(Integer.parseInt(request.getParameter("num")));

		System.out.println("test: " + request.getParameter("num"));

		UserService service = new UserService();
		service.delete(userdto);

		response.sendRedirect("coopang");

	}

	// logout
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.sendRedirect("coopang");
		session.invalidate();
	}

	// Post
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
