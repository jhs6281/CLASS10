package sec02;

public class Naver extends OAuth {
	@Override
	boolean login() { // 로그인

		System.out.println("네이버 아이디: ");
		String id = sc.nextLine();
		System.out.println("비밀번호: ");
		String pw = sc.nextLine();

		return loginCheck(id, pw);

	}
}
