package controller;

import java.util.List;

public class EmpController implements Servlet {

	EmpService empService = new EmpServiceImpl();
	
	@Override
	public String doGet() {
		// empService
		
		List<Integer> list = empService.getEmpno();
		
		String html = "";
		
		for(int i=0; i<list.size(); i++) {
			html += "<div>" + list.get(i) + "</div>";
		}
		
		return html;
	}

	@Override
	public String doPost() {
		return null;
	}

}
