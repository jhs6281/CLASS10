package loginCheck;

import emp.EmpDAO;
import emp.EmpDTO;


public class CheckService {
	EmpDAO dao = new EmpDAO();
	// select
		public EmpDTO select(EmpDTO dto){
			return dao.selectMember(dto);
		}
		
}
