package secQz13;

import java.util.ArrayList;

import secQz12.Member;

public class Process {
	
	//아이템 타입 리스트에 
	//ArrayList<Item> t = new ArrayList<Item>();
	//Item t1  = new Item("aaaa");
	
	
	//ArrayList 타입의 t라는 변수만큼
	//Item 클래스의 item이라는 변수를 new해서 넣는 동안.
	
	//Item 타입의 리턴 받은 name을 출력.
	void run(ArrayList<Item> t) {
		//Item t  = new Item("aaaa");
		//t.rtname();
		//this.t.add(t);
		//t.rtname();
//		t.get(0).rtname();
		for(Item item : t) {
//			t.get(item.rtname());
//			System.out.println(t + "를 만들었습니다.");
			System.out.println("배열 타입 자동 생성기 : " + item.rtname()+"을 만들었습니다.");
					
		}
	}
	//의문: 이름을 리턴하는 이유 모름!
	void run2(Item test) {
		System.out.println("수동 테스트: " + test.rtname() + "을 제작했습니다.");
	}
}
// [Process]-공정(일하는 방법 또는 순서)
//    메소드명: run
//    전달인자: Item
//      리턴타입: 없음
//    하는일: Item이름+" 생산 완료" 출력
