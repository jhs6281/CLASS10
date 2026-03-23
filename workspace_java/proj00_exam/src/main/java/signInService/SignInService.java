package signInService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import signInDAO.SignInDAO;

public class SignInService {

	SignInDAO dao = new SignInDAO();
	List list = dao.selectAll();

	public List service() {
		{
			// 뭔가 함
		}
		return list;
	}

	public String toJson() {
		
		String json = "[";
			
			for (int i = 0; i < list.size(); i++) {
				Map map = (Map)list.get(i);
				
				// 문자열에 쌍 따옴표 추가하기!
				json +=
						"{"
						+ "\"num\" : " + map.get("num") + ", "
						+ "\"empno\" : " + map.get("empno") + ", "
						+ "\"id\" : \"" + map.get("id") + "\", "
						+ "\"pw\" : " + map.get("pw") + ", "
						+ "\"email\" : " + map.get("email") + ", "
						+ "\"hiredate\" : " + map.get("hiredate") + ", "
						+ "\"working\" : " + map.get("working") + 
						"} " ;
				
				if (i != list.size() - 1) {
		            json += ",";
		        }
			}
			
			json += "]";
		
			System.out.println(json);
			System.out.println("/service toJson > json 배열 생성 완료");
		
		return json;
		
	}
}