package controller;

import java.util.ArrayList;
import java.util.List;

public class EmpDAOImpl implements EmpDAO {

	@Override
	// select한 사원번호를 배열로 담는 함수
	public List selectEmpno() {

		// List 는 ArrayList의 부모 인터페이스이다.
		// add 함수는 List 것임
		List list = new ArrayList();
		
		list.add(1111);
		list.add(2222);
		list.add(3333);
		list.add(4444);
		list.add(5555);
		
		return list;
		// 리턴 타입이 리스트라 가져올 수 있다. 
	}

}
