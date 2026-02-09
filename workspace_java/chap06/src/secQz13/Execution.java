package secQz13;

import java.util.ArrayList;

public class Execution {

	public static void main(String[] args) {

//1. 생성 (전달: 스트링 타입)
//
//
//2. 메인 (스트링 타입 값)
//	
//	공정 메소드(클래스 타입 값)
//
//
//3. 공정 (클래스 타입 변수명 ){
//	클래스.원하는 값
//}

		
		//공정
		ArrayList<Item> tem = new ArrayList<Item>();
		Item item1 = new Item("아이템1");
		Item item2 = new Item("아이템2");
		Item item3 = new Item("아이템3");
		Item item4 = new Item("아이템4");
		
		tem.add(item1);
		tem.add(item2);
		tem.add(item3);
		tem.add(item4);
		
		Process pc = new Process();
		//아이템 넣기
		pc.run(tem);
		
		pc.run2(item1);
		pc.run2(item2);
		pc.run2(item3);
		pc.run2(item4);
		
		//아이템 1+2 되어야 함.
	}

}
