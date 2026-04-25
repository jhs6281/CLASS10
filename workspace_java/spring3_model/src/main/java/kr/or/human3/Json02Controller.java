package kr.or.human3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Json02Controller {

	@RequestMapping("/ajax.do")
	public String ajax() {
		return "/ajax";
	}
	
	@RequestMapping("/ajax1")
	public String ajax1(
		
			@RequestParam(value="id", required=false)
			String id
			
		) {
		
		System.out.println("id : " + id);
		System.out.println("/ajax1 실행");
		
		return "/ajax";
	}
	@RequestMapping("/ajax2")
	public String ajax2(
			
//			@RequestParam(value="id", required=false)
//			String id,
			
			@RequestBody
			MemberDTO dto
			
			) {
		
		System.out.println("/ajax2 실행");
		System.out.println("dto : " + dto);
		
		return "/ajax";
	}
	
	@RequestMapping("/ajax3")
	@ResponseBody
	public String ajax3() {
		return "ajax";
	}
	
	@RequestMapping("/ajax4")
	@ResponseBody
	public MemberDTO ajax4() {
		
		MemberDTO dto = new MemberDTO();
		
		dto.setId("id3");
		dto.setPw("패스워드");
		dto.setName("이름");
		dto.setTel("전번");
		dto.setEmail("이메일1");
		dto.setAge(21);
		
		return dto;
	}
	
	@RequestMapping("ajax5")
    @ResponseBody
    public List<MemberDTO> ajax5() {
        List<MemberDTO> list = new ArrayList<MemberDTO>();

        MemberDTO dto = new MemberDTO();
        dto.setId("id3");
        dto.setPw("pw3");
        dto.setEmail("wmfdla3@naver.com");

        list.add(dto);
        list.add(dto);
        list.add(dto);

        return list;
    }
	
	@RequestMapping("ajax6")
	@ResponseBody
	public Map ajax6() {
		List list = new ArrayList<MemberDTO>();
		
		MemberDTO dto = new MemberDTO();
		dto.setId("id3");
		dto.setPw("pw3");
		dto.setEmail("wmfdla3@naver.com");
		
		list.add(dto);
		list.add(dto);
		list.add(dto);
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", 120);
		map.put("pageNo", 3);
		map.put("keyword", "scott");
		map.put("type", "code");
		
		return map;
	}
}
