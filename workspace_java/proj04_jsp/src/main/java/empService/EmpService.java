package empService;

import java.util.List;

import empDAO.EmpDAO;

public class EmpService {
	
	public List selectEmp() {
		
		System.out.println("/service 실행");
		
		EmpDAO edao = new EmpDAO();
		return edao.select();
	}
	
}
