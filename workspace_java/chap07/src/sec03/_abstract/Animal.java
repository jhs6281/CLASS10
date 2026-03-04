package sec03._abstract;

public abstract class Animal {
	// abstract class - 상속 전용
	// final class - 상속 불가
	
	// final method - 오버라이딩 불가 
	void breathe() {
		System.out.println("숨쉬어.");
	}
	
	// abstract void sound() {} // 실행 블럭이 있으면 안됨
	// 자식에게 구현을 강제한다
	abstract void sound();
	
	String kind;
	
	Animal (){
		System.out.println("Animal 생성자 실행");
	}
}
