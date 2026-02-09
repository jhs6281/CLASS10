package sec06_package.pack3;

//Human 위치
// *은 해당 경로의 모든 클래스 import, new 해야 생성
//import sec06_package.pack2.Human; // 휴먼 가져온다
import sec06_package.pack1.*; // 내 폴더만 가져온다
// 상위 폴더를 가져왔지만
import sec06_package.pack1.sub1.*; // 하위 패키지 폴더는 안 가져오니 주의

public class HumanExam {
	public static void main(String[] args) {
		// 컨트롤+쉬프트+O
//		sec06_package.pack1.Human h1 = new sec06_package.pack1.Human();
		Human h1 = new Human();
		sec06_package.pack2.Human h2 = new sec06_package.pack2.Human();		

		Edu e1 = new Edu(); 
		
		// import java.lang.*  << String, println, random() 등등 들어있음
		// 자동 선언 되어있어서 import 생략 가능
		
		String a = "a";
		System.out.println(a + Math.random());
	}
	

}
