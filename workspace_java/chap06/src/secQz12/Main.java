package secQz12;

public class Main {

	public static void main(String[] args) {
		
		//main에서 회원가입 생성자 호출
//		LogIn li = new LogIn("A", "1111");
//		LogIn li2 = new LogIn("B", "2222");
		LogIn li = new LogIn();	
		li.signIn("A", "1111"); // 회원가입 
		li.signIn("A", "11122"); //중복
		li.signIn("A", "111141"); //중복
		li.signIn("N", "11331"); // 회원가입
		
		//ID PW 입력
		
		li.memInfo();
		li.logIn("A", "11"); // 비번 틀림
		li.logIn("A", "1111"); //로그인
	}

}
