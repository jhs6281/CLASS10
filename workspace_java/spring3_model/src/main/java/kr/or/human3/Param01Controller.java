package kr.or.human3;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Param01Controller {

	@RequestMapping("/join.do")
	public void joinForm(HttpServletRequest request, HttpServletResponse response) {
	
		// jsp로 포워드
		System.out.println("메소드 실행");
		
		try {
			request.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/join2.do")
	public ModelAndView joinForm2() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("join");
		
		return mav;
		
	}
	
	@RequestMapping("/join3.do")
	public ModelAndView joinForm3() {
		
		ModelAndView mav = new ModelAndView("join");
		
		return mav;
		
	}
	
	// 실무에서 가장 많이 사용하는 패턴
	@RequestMapping("/join4.do")
	public String joinForm4() {
		return "join";
	}
	
	// 주소와 jsp 명이 같을 때
	@RequestMapping("/join")
	public void joinForm5() {
	}
	
	@RequestMapping("/join6.do")
	public String joinForm6() {
		System.out.println("redirect");
		return "reidirect:join.do";
	}
	
	@RequestMapping("/join7.do")
	public String joinForm7() {
		System.out.println("redirect");
		return "forward:join.do";
	}
	
	@RequestMapping("/join1") // jsp명
	public String joinForm1(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		
		return "forward:join.do";
	}
	
	//////////////////////////////////
	//////////@ RequestParam//////////
	//////////////////////////////////
	
	@RequestMapping("/join2")
	public void join2( 
			// String id = request.getParameter("id");
			// 위의 코드와 같음
			// (required=true 생략됨) 기본적으로 필수 값, 그래서 없으면 400
			@RequestParam("id") String id,
			
			// value가 "dd"인 것 / 필수 값 아님. 값이 없으면 null 
			@RequestParam(value="email", required=false)
			String email,
			
			// 필수 값
			@RequestParam(value="pw", required=false)
			String pw,
			
			// 고도의 생략 버전. 
			// 이름이 같은 것 찾아줌 / required=false
			String tel,
			
			// int는 null이 안돼서 500 ERROR
			// > Integer 사용하면 됨 // int age 
			Integer age
			) {
		
		System.out.println("/join2 실행");
		
		System.out.println( "id : " + id );
		System.out.println( "email : " + email );
		System.out.println( "pw : " + pw );
		System.out.println( "tel : " + tel );
		System.out.println( "age : " + age );
		
	}
	
	@RequestMapping("/join3")
	public String join3(
			
			@RequestParam
			Map map
			
//			@RequestParam 아쉽게도 DTO는 안된다.
//			MemberDTO memberDTO 
			
		) {
		
		System.out.println(map);
		
		return "join";
	}
	
	@RequestMapping("/join4")
	public String join4(
			
			@ModelAttribute
			MemberDTO memberDTO 
			
			) {
		
		System.out.println(memberDTO);
		
		return "join";
	}
	

	@RequestMapping("/signup1")
	public ModelAndView signup1 (
			
			HttpServletRequest request, 
			String id
		
		) {
		ModelAndView mav = new ModelAndView("result");
		
		request.setAttribute("id", id);
		
		return mav;
	}
	
	@RequestMapping("/signup2")
	public ModelAndView signup2 (
			
			HttpServletRequest request, 
			String id
			
			) {
		System.out.println("/signup2 : 실행 ");
		ModelAndView mav = new ModelAndView("result");
		
		//request.setAttribute("id", id);
		mav.addObject("id", id);
		return mav;
	}
	
	@RequestMapping("/signup3")
	public ModelAndView signup3 (
			
			// parameter에서 꺼내서
			// DTO의 setter를 이용하여 자동으로 넣어줌
			@ModelAttribute
			MemberDTO dto1,
			
			// 심지어 다음줄의 코드까지 해줌
			// mav.addObject("memberDTOa", dto2)
			@ModelAttribute("memberDTO3") // key
			MemberDTO dto2, // value
			
			// @ModelAttribute("memberDTO") 이것도 생략가능
			// 생략하면 타입(클래스)의 앞글자를 소문자로한 key로 
			// 모델에 넣어줌
			MemberDTO dto3 // value
			// 가독성 쓰레기
			
			) {
		System.out.println("/signup3 : 실행 ");
		// SEARCH JSP NAME
		ModelAndView mav = new ModelAndView("result"); 
		
		//request.setAttribute("id", id);
		mav.addObject("dto1", dto1); // set Attribute 비슷한거
		return mav;
	}
	
	@RequestMapping("/signup4")
	public ModelAndView signup4 ( MemberDTO dto1, String id ) {
		
		System.out.println("/signup4 : 실행 ");
		
		System.out.println(dto1);
		System.out.println(id);
		
		ModelAndView mav = new ModelAndView("result"); 
		
		return mav;
	}
	
	// 우선순위가 가장 높기 때문에 1을 찍으면 아래 메소드로 온다.
	@RequestMapping("/cal/1")
	public void cal() {
		System.out.println("1월 달력입니다 111");
	}
	
	// { 안에 있는 값 }
	@RequestMapping("/cal/{month}")
	public void cal2 (
			
			// 주소의 값을 변수에 담아주는 것
			@PathVariable("month") // 변수명 같다면 생략 가능
			int mon
			
		) {
		System.out.println( mon + "월 달력입니다 222" );
	}
	
	@RequestMapping("/lunch/{store}/order/{menu}/start")
	public void lunch(
		
			@PathVariable("store")
			String store,
			@PathVariable // 변수명 같은 것은 생략 가능
			String menu
			
		) {
		System.out.println("가게 : " + store + " / 메뉴 : " + menu);
	}
	
	@RequestMapping("/dinner")
	public String dinner(Model model, String menu) {
		System.out.println("/dinner 실행 model: " + model);
		System.out.println("/dinner 실행 menu: " + menu);
		
		model.addAttribute("menu", menu);
		
		return "result";
	}
	
	@RequestMapping(value="/brunch")
	public String brunch() {
		
		System.out.println("/brunch");
		return "result";
		
	}
	
	@RequestMapping(value={"/brunch1", "/brunch2"})
	public String brunch2() {
		
		System.out.println("/brunch");
		return "result";
		
	}
	
	@RequestMapping(value="/brunch3", method=RequestMethod.POST)
	public String brunch3() {
		
		System.out.println("/brunch3");
		return "result";
		
	}
	@RequestMapping(value="/brunch4", method= {RequestMethod.POST, RequestMethod.GET})
	public String brunch4(HttpServletRequest req) {
		
		System.out.println("/brunch4");
		
		HttpSession session = req.getSession();
		
		return "result";
		
	}

}
