package forward;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;


@WebServlet("/Forward")
public class Forward extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("/Forward의 [doGet] 실행");
		
		int num = 10;
		
		Map map = new HashMap();
		map.put("하나", num);
		map.put("둘", ++num);
		map.put("셋", ++num);
		
		System.out.println("map : " + map);
		
		request.setAttribute("num", num);
		request.setAttribute("map", map);
		
		List list = new ArrayList();
		list.add(num);
		list.add(map);
		list.add(new String[3]);
		
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setContent("할 일1");
		request.setAttribute("todoDTO", todoDTO);
		
		list.add(todoDTO);
		
		request.setAttribute("list", list);
		
		// forward
		request.getRequestDispatcher("el_4.jsp").forward(request, response);
	
	}


}
