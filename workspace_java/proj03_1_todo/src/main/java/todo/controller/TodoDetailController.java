package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/todo/detail")
public class TodoDetailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8;");

			// todo_id 받아서 출력하기

			System.out.println("/todo/detail [doGET] 실행");

			// 파라미터 값 받기 listner
			String todo_id = request.getParameter("todo_id");
			System.out.println(todo_id);

//		int nTodo_id = todoDTO.setTodo_id(Integer.parseInt(todo_id));

			// 파라미터에 입력할 숫자 -> int 형 변환
			int nTodo_id = Integer.parseInt(todo_id);

			// Todo_id -> service -> DAO
			TodoService todoservice = new TodoService();
			// service -> DAO -> controller
			TodoDTO todoDTO = todoservice.getTodo(nTodo_id);

			System.out.println(todoDTO);

			// 화면에 출력
			PrintWriter out = response.getWriter();
			out.write("<br> <a href='../todo'>목록으로 </a>");
			
			out.write("<br> todo_id : " + todoDTO.getTodo_id());
			out.write("<br> duedate : " + todoDTO.getTodo_duedate());
			out.write("<br> done : " + todoDTO.getTodo_done());
			out.write("<br> content : " + todoDTO.getTodo_content());
			out.write("<br> ctime : " + todoDTO.getTodo_ctime() + "<br>");
			
			out.write("<hr><a href='/proj03_1_todo/todo/modify?todo_id=" + todoDTO.getTodo_id() + "'>수정하기 </a><br>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
