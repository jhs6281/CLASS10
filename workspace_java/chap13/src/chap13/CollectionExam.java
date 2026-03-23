package chap13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionExam {

	public static void main(String[] args) {
		
		List list = new ArrayList(); 
		
		System.out.println(list.isEmpty()); // 새삥
		
		list.add(123);
		list.add("글씨");
		System.out.println(list); // toString이 Override가 되어있음

		list.add(1, "삽입"); // (1번 인덱스에, "내용")
		System.out.println(list); // 중간에 낀 것 확인
		
		//검색
		System.out.println(list.contains("글씨")); // 있는지?
		
		System.out.println( list.get(0) ); // return 타입 Object라 변수에 담을 때 형 변환 해야 함
		
		// 벗어나면
		// IndexOutOfBoundsException
		// System.out.println(list.get(100));
		
		list.remove(1); // 삭제
		System.out.println(list);
		System.out.println( list.size() ); // 배열 길이 크기
		System.out.println( list.isEmpty() ); // 있는지 다시 확인?
		
		Map map = new HashMap();
		// key가 없다면 key 추가
		map.put("k1", "v1");
		map.put("k2", 123);
		map.put("k3", list);
		
		// key가 있다면 value 덮어쓰기
		map.put("k2", 1234); 
		

		// 중요!!!!!!!!!!!!!!!!!!!!!!!!!
		
		// get은 Object타입의 값을 받는다. 
		// 자동 형 변환이 안되기 때문에
		// 꼭!!!!!!!! 형 변환을 해줘야 한다.
		String v = (String) map.get("k1");
		System.out.println(map.get("가사")); // 없다면 Null
		
		System.out.println(map);
		
		// 초기화
		list = new ArrayList();
		map = new HashMap();
		
		// 관리 방법
		
//		좋지 못한 케이스 map.put("한로로", "사랑하게 될거야"); (가수명 , 노래 제목)
		map.put("가수명", "한로로");
		map.put("노래명", "사랑하게 될꺼야");
		
		
		// 얕은 복사 / 깊은 복사

		// add(map) 시점 - 얕은 복사
		// 깊은 복사 방법 : new를 새로 해야한다.
		list.add(map);
		System.out.println(list);
		System.out.println("+:+:+:+::+:+:+:+:+:+:+:+:+:+:+:+:+");
		// 선 긋기

		// 덮어쓰기 됨 = list.add(map) 얕은 복사라는 뜻
		map.put("가수명", "kiiikii");
		System.out.println(list); 
		

		// 제네릭
		// 10점 짜리 설명 : 노란줄 없애기
		// 60점 짜리 설명 : 추가할 자료형을 제한한다
		// 100점 짜리 설명 : 전달인자나 리턴 타입의 자료형을 동적으로 변경한다
		
		// 원시타입 (int, double, char) 사용 불가하므로 wrapper class를 사용해야 함
		Map<String, Integer> map2 = new HashMap<String, Integer> ();
		
		//map2.put("k", "abc"); 전달인자가 String이라 불가능
		map2.put("k", 123);
		map2.get("k"); // Integer 형태이다.
	}

}
