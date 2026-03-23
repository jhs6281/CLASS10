package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/todo")
public class TodoController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/todo [doGET] 실행");

		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답의 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

		// DB에서 모든 목록 가져오기
		TodoService todoService = new TodoService();
		List<TodoDTO> list = todoService.getList();
		// Object 반환 -> 
		
		
		System.out.println("행 개수 : " + list.size());

		// html로 출력하기
		PrintWriter out = response.getWriter();

		out.println("<table border=1>");
		out.println("<tr>");
		out.println("	<th> todo_id </td>");
//		out.println("	<th> duedate </td>");
//		out.println("	<th> done </td>");
		out.println("	<th> content </td>");
		out.println("	<th> ctime </td>");
		out.println("</tr>");

		
		for (int i = 0; i < list.size(); i++) {
			
			TodoDTO todoDTO = list.get(i);
			
			out.println("<tr>");
			out.println("	<td>" + todoDTO.getTodo_id() + "</td>");
//			out.println("	<td>" + todoDTO.getTodo_duedate() + "</td>");
//			out.println("	<td>" + todoDTO.getTodo_done() + "</td>");
			out.println("	<td><a href=\"/proj03_1_todo/todo/detail?todo_id=" 
						+ todoDTO.getTodo_id() + "\">" + todoDTO.getTodo_content() + "</a></td>");
			out.println("	<td>" + todoDTO.getTodo_ctime() + "</td>");
			out.println("</tr>");

//			Map map = (Map) list.get(i);
//
//			out.println("<tr>");
//			out.println("	<td>" + map.get("todo_id") + "</td>");
////			out.println("	<td>" + map.get("duedate") + "</td>");
////			out.println("	<td>" + map.get("done") + "</td>");
//			out.println("	<td>" + map.get("content") + "</td>");
//			out.println("	<td>" + map.get("ctime") + "</td>");
//			out.println("</tr>");
			
		}
		out.println("</table>");
		

	}

}
