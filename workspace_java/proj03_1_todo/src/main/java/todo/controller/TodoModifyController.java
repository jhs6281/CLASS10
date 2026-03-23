package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/todo/modify")
public class TodoModifyController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/todo/modify [doGet] 실행");
		

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// 파라미터 값 받기 listner // todo ID
		String todo_id = request.getParameter("todo_id");
		
		System.out.println(todo_id);
		
		int nTodo_id = Integer.parseInt(todo_id);

		// Todo_id -> service -> DAO
		TodoService todoservice = new TodoService();
		// service -> DAO -> controller
		TodoDTO todoDTO = todoservice.getTodo(nTodo_id);
		
		PrintWriter out = response.getWriter();
		
		// get 방식으로 보냄 / action의 주소에 파라미터로 전달
		out.write("<form method='get' action=''>");
		
		out.write("<br> todo_id : <input type='text' value='" 
						+ todoDTO.getTodo_id() + "'>");
		
		out.write("<br> duedate : <input type='text' value='" 
				+ todoDTO.getTodo_duedate() + "'>");
		
		out.write("<br> done : <input type='text' value='" 
				+ todoDTO.getTodo_done() + "'>");
		
		out.write("<br> content : <input type='text' value='" 
				+ todoDTO.getTodo_content() + "'>");
		
		out.write("<br> ctime : <input type='text' value='" 
				+ todoDTO.getTodo_ctime() + "'> "
				+ "<br><br> <input type=\"submit\" value=\"post 전송\">"
				+ "</form>");
				
		out.write("<a href='/proj03_1_todo/todo/detail?todo_id="
				+ todo_id + "'> 뒤로 </a>"
				
				);
		
	}

}
