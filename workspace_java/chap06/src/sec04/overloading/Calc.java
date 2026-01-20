package sec04.overloading;

public class Calc {
	//리턴타입은 int
	int plus(int a, int b) {
		System.out.println("int int 실행");
		return a+b;
	}
	
	//double plus(int x, int y) {} 존재 불가능
	//리턴타입은 double
	double plus(double a, double b) {
		System.out.println("double double 실행");
		return a+b;
	} 
	// 변수가 같아도 실행 가능 위에 두 개
	
	
	
	// double double로 같은 타입이라서 오버로딩 안됨
//	double plus (double x, double y) {
//		return x+y;
	
	double plus(int a, double b) {
		System.out.println("int double 실행");
		return a+b;
	} 
	
	//우선순위 찾아 따라감
	
	int plus(int x) {
//		return x + x;
		return plus(x, x);
	}
	
	// 오늘 운동 setter
	String type;
	int min;
	int set;
	void fitness(String t, int m, int s){
		type = t;
		min = m;
		set = s;
	}	
	void fitness(String t, int m){
//		type = t;
//		min = m;
//		set = 5;
		fitness(t, m, 5);
	}	
	
	void fitness(String t){
		fitness(t, 3, 5);
	}	
	
	// 같은 변수 명을 사용하는 방법 : 오버로딩
	// 사용자의 편의성을 위해 위와  같이 작성함
	
	
	//여러가지 선언
	Calc newCalc() {
		Calc c = new Calc ();
		return c;
	}
	
	int [] newInt3 () {
		int[] a = new int [3];
		return a;
	}
	
	Calc[] newCalc5() {
		Calc [] a = new Calc[5];
		return a;
	}
	
}
