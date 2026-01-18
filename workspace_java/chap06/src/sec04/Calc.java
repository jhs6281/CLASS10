package sec04;

public class Calc {
	//메소드 선언
	void powerOn() {
		int a;
		a = 10;
		
		System.out.println("전원을 켭니다");
	}
	
	//잠깐 return 배우고 왔음
	int plus(int x, int y) {
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		
		int result = x+y;
		return result;
	}
	
	/////////////////////////////////////////
	
	double divide(int x, int y) {
		
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		
		if(y==0) {
			System.out.println("0으로 나눌 수 없습니다");
			return 0;
		} 
//		else {
//		else를 쓰지 않아도 if문 조건에 맞지 않을 때 return까지 실행 되고 메소드는 끝난다 
			return (double) x/y;
//		}
	}
}
