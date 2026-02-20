package sec01;

public class Child extends Parent{
	
	
	void printName() {
		System.out.println("Child의 printName 실행");
		
		System.out.println("name: " + name);
		
		System.out.println("this.name: " + this.name);
		
		String name = "지역변수 선언 가능";
		
		System.out.println("super.name: " + super.name); // super 처음 배움
	}
	
	// 전달인자가 필드를 가리는 현상
	void setName(String name) {
		this.name = name;
	}
	
	// 자식 필드가 부모 필드를 가리는 현상
	// overshadow
	String name = "Child의 name";
	
//	Child(int a){
//		
//	}
//	
	Child(){ // 상속 받는 순간 기본 생성자
		super(3); // 의도적으로 사용하려면 첫줄에 적어야 한다.
		// 부모 생성자에 전달인자가 있는 경우 생략 불가능
//		this(2); // super(), this() 모두 첫 줄에 적어야 해서 같이 사용할 수 없다.
		System.out.println("Child 생성자 실행");
	}
	
	
}
