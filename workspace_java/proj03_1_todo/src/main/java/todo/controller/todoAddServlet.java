package todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/todo/add")
public class todoAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/todo/add [doGET 실행]");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// Listen Content
		String content = request.getParameter("content");

		// DTO - setContent
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setContent(content);
		System.out.println("/todo/add Content : " + todoDTO.getTodo_content()); // test

		String getContent = (String) todoDTO.getTodo_content();

		if (getContent == null || getContent.trim().equals("")) {

			System.out.println("Null Content");

		} else {
			
			// Service(DTO) > DAO(DTO) - Insert Content
			TodoService todoService = new TodoService();
			int result = todoService.addTodo(todoDTO); // DTO 전달
			System.out.println("/todo/add Update Count : " + result);

			// redirect
			response.sendRedirect("/proj03_1_todo/todo");
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/todo/add [doPOST 실행]");
		// doPost > doGet
		doGet(request, response); 

	}

}
