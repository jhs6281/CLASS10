package kr.or.human2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.human2.dao.MemberDAO;
import kr.or.human2.dao.MemberDAOImpl;
import kr.or.human2.service.MemberService;
import kr.or.human2.service.MemberServiceImpl;

@Controller
public class MemberController {

		MemberController(){
			
			System.out.println("MemberController 생성자 실행");
			
		}
		
		@Autowired
		MemberService memberService;
	
		@RequestMapping("/member")
		String listMember() {
			
			System.out.println("/member 실행");
			
//			MemberService memberService = new MemberServiceImpl();
//			
//			MemberDAO memberDAO = new MemberDAOImpl();
//			List list = memberService.getList(memberDAO);
//			MemberDAO memberDAO2 = new MemberDAOImpl2();
//			List list2 = memberService.getList(memberDAO2);
//			System.out.println(list);
//			System.out.println(list2);
			
			List list = memberService.getList2();
			System.out.println("list : " + list);
			
			
			return "home";
		}
		
}
