package sec06_package.pack3;

import sec06_package.pack1.*;
import sec06_package.pack2.Access2; // 다른 패키지에서 가져올 때에는 import 필수

public class AccessExam {

	public static void main(String[] args) {
		Access2 a2 = new Access2(); // public이라 실행 가능
//		new Access1(); // public 아니어서 안됨
		
		Edu edu = new Edu(); // public 생성자 안했는데 불러와짐
		// -> 이해 : 기본 생성자는 public이 붙어있구나
		
		//
		
		a2.p1 = 10;
		System.out.println(a2.p1);
		a2.p();

		
	}
	


}
