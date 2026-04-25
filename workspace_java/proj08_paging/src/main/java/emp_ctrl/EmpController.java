package emp_ctrl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp_DTO.EmpDTO;
import emp_service.EmpService;


@WebServlet("/list")
public class EmpController extends HttpServlet {

	EmpService service = new EmpService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("/list doGet 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		int size = 10; // 페이지당 표시 수
		int page = 1; // 현재 페이지
		
		String sSize = request.getParameter("size");
		String sPage = request.getParameter("page");
		
		try {
			size = Integer.parseInt(sSize);
		} catch(Exception e) {
			e.printStackTrace();
		}
		// 같이 있으면 서로 영향을 받기 떄문에 분리
		try {
			page = Integer.parseInt(sPage);
		} catch(Exception e) { }
		
		EmpDTO empDTO = new EmpDTO();
		
		empDTO.setSize(size);
		empDTO.setPage(page);
		
		Map map = service.selectEmp(empDTO);
		
		map.put("size", empDTO.getSize());
		map.put("page", page);
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("/WEB-INF/views/emp.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
