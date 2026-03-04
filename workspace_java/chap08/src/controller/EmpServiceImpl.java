package controller;

import java.util.ArrayList;
import java.util.List;


public class EmpServiceImpl implements EmpService {

	EmpDAO empDAO = new EmpDAOImpl(); // EmpDAO(부모타입)의 EmpDAOImpl (new)
	
	@Override
	public List getEmpno() {
		
		//리턴 타입 리스트로 받아온 empDAO.selectEmpno()
		List<Integer> list = empDAO.selectEmpno();
		//getEmpno()에 조건별로 담을 리스트 만들기.
		List<Integer> result = new ArrayList();
		
		for(int i=0; i<list.size(); i++ ) {
			if(list.get(i)>=3000) {
				result.add(list.get(i));
			}
		}
		return result;
		// 리턴 타입 List = 3000 이상의 사원 번호를 담은 List 
		
	}

}
