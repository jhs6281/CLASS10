package userCtrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userdto.UserDTO;
import userservice.UserService;

@WebServlet("/user")
public class UserCtrl extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("/user [doGet]");
		
		String cmd = request.getParameter("cmd");
		UserDTO userDTO = new UserDTO();
		
		if (cmd == null || cmd.isEmpty()) { // 접근 제한
			request.getRequestDispatcher("login.jsp").forward(request, response);
		    return;
		} 

		switch (cmd) {
		case "signin":
		    request.getRequestDispatcher("signIn.jsp").forward(request, response);
		    return;
//
//		case "loginPage":
//		    request.getRequestDispatcher("login.jsp").forward(request, response);
//		    return;

		case "insert":
		    insert(request, response);
		    return;

//		case "login":
//		    login(request, response);
//		    return;

//		case "list":
//		    if (userDTO.getGrade() <= 3) {
//		        list(request, response);
//		        return;
//		    }
//		    break;

//		case "detail":
//		    detail(request, response);
//		    return;
//
//		case "logout":
//		    logout(request, response);
//		    return;
//
//		case "delete":
//		    delete(request, response);
//		    return;
//
//		case "update":
//		    update(request, response);
//		    return;
//
//		case "modify":
//		    modify(request, response);
//		    return;
		    
		default:
			System.out.println("잘못된 접근입니다");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		
		
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService service = new UserService();
		service.insertDB();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
