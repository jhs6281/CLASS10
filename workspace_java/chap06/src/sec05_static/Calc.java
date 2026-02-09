package sec05_static;

public class Calc {
	
	// 이해 확인
	// static 타입 변수명 = 값; < static 변수 생성 양식
	// static 은 공용으로 사용할 수 있는 
	
	
	String color;
	
	//어차피 변수
	// 정적 멤버, 공용 변수, 클래스 변수
	
	// static 선언!
	static double pi = 3.14;
	
	static void test() {
		System.out.println("실행");
	}
	
	int max_int = Integer.MAX_VALUE;
	
	static int price;
	// price = 100;
	// 불가능 <
	
	
	// static이 먼저 실행되는 테스트
	// static은 java언어에서의 전제이다.
	// 호출과 선택은 사용자의 마음이지만, 사용하지 않아도 static으로 생성한 순간부터 존재한다.
	// 따라서 static을 사용하지 않는 이유는 메모리 효율과 관리의 이유이며
	// 반대로 static을 사용하는 이유는, 동기화의 편의성을 위함이다.
	{		
		System.out.println("필드에 있는 그냥 실행 블럭");
		// new를 해야 실행 되는?
	}
	static {		
		System.out.println("필드에 있는 static 블럭");
		// 밑에 있는데도 먼저 실행됨 ! (static이기 때문)
//		Scanner s = new Scanner(System.in);
//		price = s.nextInt()+10; //왜 오류
		
	}
	
	Calc()
	{
		System.out.println("Calc new 하면 생성자 실행");
		this.price = 100;
		Calc.price = 100;
	}
	
	
}

/*
 * 필드는 따로 ㅇㅇ
 * 메소드 = 메소드 영역에서 동작 (공통 사용)
 * 
 */