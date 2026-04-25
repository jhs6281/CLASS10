package loginCheck;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.EmpDTO;
import java.util.*;

@WebServlet("/list")
public class ListPage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		HttpSession session = request.getSession();
		// 재귀
		List<EmpDTO> list = (List<EmpDTO>) session.getAttribute("list");

		if (list == null) {
			list = new ArrayList<>();
		}

		EmpDTO dto = (EmpDTO) session.getAttribute("dto");

		if (dto != null) {

			boolean flag = false;

			for (EmpDTO li : list) {
				
				if ((int)li.getEmpno() == (int)dto.getEmpno()) {
					
					System.out.println("중복된 사용자 입니다.");
					flag = true;
					break;
				}
				
			}
			if (!flag) {
				list.add(dto);
			}
		}

		session.setAttribute("list", list);
		response.sendRedirect("list.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
