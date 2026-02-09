package sec05_static;

public class CalcExam_01 {
	int a;
	//static이기 때문에 
	//클래스명.main > 실행됨(new 하지 않았음)
	public static void main(String[] args) {
		
		double p = Calc.pi;
//		언급 하는 순간 static 시작
		
		Calc c1 = new Calc();
		Calc c2 = new Calc();
		
		c1.color = "하늘색";
		c2.color = "핑크";
		
		System.out.println(c1.color);
		System.out.println(c2.color);
		
		System.out.println(c1.pi);
		c1.pi = 3.141592653;
		//cl.pi 를 바꿔도 결국 Calc에 있는 pi 값을 바꿨기 때문에
		//c2.pi 값도 바뀌어서 출력된다.
		System.out.println(c2.pi);
		System.out.println(c1.pi);
		
		//이게 국룰 사용법
		System.out.println(Calc.pi);
		
		Calc stt; // 얘는 선언만 해서 안됨.
		
		Calc.test();
		
		// eat(); 오류
//		this.a = 10; new가 되지 않았기 떄문에 실행 불가
		// this는 new가 된 인스턴스를 사용한다는 것.
//		-> static에서는 못쓴다.
		
		// static에서는 static만 사용 가능하다.
	}
	void eat() {
		System.out.println("먹는다");
		
	}

}
