package todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/todo/update")
public class todoUpdateController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("/todo/update [doGET] 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		String content = request.getParameter("content");
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DTO
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setContent(content);
		todoDTO.setTodo_id(id);
		System.out.println("/todo/update Content : " + content + " id : " + id);
		// Service
		TodoService todoService = new TodoService();
		todoService.updateTodo(todoDTO);
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
