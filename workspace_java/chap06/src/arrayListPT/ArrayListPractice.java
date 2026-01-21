package arrayListPT;

import java.util.ArrayList;

public class ArrayListPractice {

	public static void main(String[] args) {
		ArrayList<Integer> pt1 = new ArrayList<Integer>();

		//문제 1 : 1, 3, 5, 7, 9 출력
		for (int i = 1; i < 10; i+=2) {
			pt1.add(i);
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(pt1.get(i) + " ");
		// pt1.get(i) = pt1의 i 인덱스 return을 받는 것과 비슷함.
		// 따라서 출력문을 따로 만들어야함
		}
		System.out.println();
		
		//문제 2 : 홍길동, 김철수, 이영희 배열에 저장
		ArrayList<String> pt2 = new ArrayList<>();
		pt2.add("홍길동");
		pt2.add("김철수");
		pt2.add("이영희");
		// 저장 반복.add = 그냥 순서대로 저장된다. 
		// 알아서 0,1,2,3 인덱스에 차곡차곡 쌓임.
		
		for(int i=0; i<pt2.size(); i++) {
			System.out.print(pt2.get(i) + " ");
		}
		System.out.println();
		
		// 문제 3
	}

}
