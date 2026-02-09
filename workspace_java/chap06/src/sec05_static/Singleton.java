package sec05_static;

public class Singleton {
//	Singleton singleton = null;
//	static Singleton singleton = null;
//	
////	Singleton get() {
//	static Singleton get() {
//		if(singleton == null) {
//			singleton = new Singleton();
//		}
//		
//		return singleton;
//	}
	
	//12
	static Singleton singleton = new Singleton();
	
	//private 생성자 변경 -> 외부에서 접근 불가
	private Singleton() {}
	
	//생략가능
	static Singleton get() {
		return singleton;
	}
}
