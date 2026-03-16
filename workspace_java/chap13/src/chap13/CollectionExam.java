package chap13;

import java.util.ArrayList;
import java.util.List;

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
		
		list.remove(1); // 삭제
		System.out.println(list);
		System.out.println( list.size() ); // 배열 길이 크기
		System.out.println( list.isEmpty() ); // 있는지 다시 확인?
	}

}
