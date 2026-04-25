package item.ctrl;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.dto.ItemDTO;
import item.service.ItemService;
import user.dto.UserDTO;
import user.service.UserService;

@WebServlet("/item")
public class ItemCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/item [doGet] 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		String cmd = request.getParameter("cmd");

		if (cmd == null) { // 리스트 (기본)
			list(request, response);
		} else if (cmd.equals("list")) { // 리스트
			list(request, response);
		} else if (cmd.equals("insertPage")) { // 등록 페이지로
			request.getRequestDispatcher("insertItem.jsp").forward(request, response);
		} else if (cmd.equals("insert")) { // 아이템 등록
			insert(request, response);
		} else if (cmd.equals("detail")) { // 아이템 등록
			detail(request, response);
		} else if (cmd.equals("update")) { // 아이템 등록
			update(request, response);
		} else if (cmd.equals("modify")) { // 아이템 등록
			modify(request, response);
		} else if (cmd.equals("delete")) { // 아이템 등록
			delete(request, response);
		}

	}

	// 상품 list
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("/item/list 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		ItemDTO userdto = new ItemDTO();

		ItemService service = new ItemService();

		request.setAttribute("itemInfo", service.select(userdto));
		request.getRequestDispatcher("itemList.jsp").forward(request, response);
	}

	// insert 상품등록
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("item/insert 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// DTO
		ItemDTO dto = new ItemDTO();

		dto.setItem_img(request.getParameter("item_img"));
		dto.setCategory(request.getParameter("category"));
		dto.setItem_id(request.getParameter("item_id"));
		dto.setItem_name(request.getParameter("item_name"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setItem_info(request.getParameter("item_info"));
		//dto.setScore(Integer.parseInt(request.getParameter("score")));
		dto.setShipping_Level(Integer.parseInt(request.getParameter("shipping_Level")));

		// Service > DAO
		ItemService service = new ItemService();
		service.insert(dto);

		response.sendRedirect("item");
	}

	protected void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("item/detail 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// a태그 - get 파라미터
		int num = Integer.parseInt(request.getParameter("num"));

		// DTO - 해당 정보 특정용 num 세팅
		ItemDTO dto = new ItemDTO();
		dto.setItem_num(num);

		// Service > DAO - selectOne
		ItemService service = new ItemService();

		// Forward > DTO
		request.setAttribute("itemInfo", service.select(dto));
		request.getRequestDispatcher("item_detail.jsp").forward(request, response);

	}

	// update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/item/updateGet 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// a태그 - get 파라미터
		int num = Integer.parseInt(request.getParameter("num"));

		// DTO - 해당 정보 특정용 num 세팅
		ItemDTO dto = new ItemDTO();
		dto.setItem_num(num);

		// Service > DAO - selectOne
		ItemService service = new ItemService();

		// Forward > DTO
		request.setAttribute("itemInfo", service.select(dto));
		request.getRequestDispatcher("itemModify.jsp").forward(request, response);

	}

	// 수정
	protected void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/item/modify 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		ItemDTO dto = new ItemDTO();

		dto.setItem_num(Integer.parseInt(request.getParameter("item_num")));
		dto.setItem_img(request.getParameter("item_img"));
		dto.setCategory(request.getParameter("category"));
		dto.setItem_id(request.getParameter("item_id"));
		dto.setItem_name(request.getParameter("item_name"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setItem_info(request.getParameter("item_info"));
		dto.setScore(Integer.parseInt(request.getParameter("score")));
		dto.setSetTime(Date.valueOf(request.getParameter("setTime")));
		dto.setShipping_Level(Integer.parseInt(request.getParameter("shipping_Level")));

		ItemService service = new ItemService();
		service.modify(dto);

		response.sendRedirect("item");

	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/item/delete 실행");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		ItemDTO dto = new ItemDTO();
		dto.setItem_num(Integer.parseInt(request.getParameter("num")));

		ItemService service = new ItemService();
		service.delete(dto);

		response.sendRedirect("item");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
