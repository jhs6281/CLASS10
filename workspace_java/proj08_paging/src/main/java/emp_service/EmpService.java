package emp_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import emp_DAO.EmpDAO;
import emp_DTO.EmpDTO;


public class EmpService {
	
	public Map selectEmp(EmpDTO empDTO) {
		
		System.out.println("/service 실행");
		
		int size = empDTO.getSize();
		int page = empDTO.getPage();
		
		int start = 0, end = 0;
		
		end = page * size;
		start = end - (size-1);
		
		empDTO.setStart(start);
		empDTO.setEnd(end); // RMx
		
		EmpDAO edao = new EmpDAO();
		
		int totalCount = edao.cntTable();
		List list = edao.select(empDTO);
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount);
		
		
		return map;
	}
	
	
}
