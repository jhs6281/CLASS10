package chap02;

public class VarExam {

	public static void main(String[] args) {
		// 변수 선언
		int value;
		
		// 변수에 값 넣기
		// 변수에 할당
		value =  5;
		
		// value의 값을 출력해라
		System.out.println(value);
		
		// 변수의 값 덮어쓰기
		value = 6;
		
		// value 재출력
		System.out.println(value);
		
		int result;
		
//		System.out.println(result);
		result = value + 10;
		System.out.println(result);
		
//		선언과 동시에 초기화
		int hour = 3;
		int minute = 5;
		
		System.out.println(hour+ "시 " + minute+"분");
		System.out.println("value : "+ value);
		
		int x = 10;
		{
			System.out.println("x : "+ x);
//			y = 지역변수
			int y = 5;
			System.out.println("y : "+ y);
			{
				System.out.println("y : "+ y);
			}
//			garbage collecter 작동
		}
//		System.out.println("y : "+ y);
		
	}
}


