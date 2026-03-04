package sec02;

public class Kakao extends OAuth {
	@Override
	boolean login() { // 로그인

		System.out.println("카카오 아이디: ");
		String id = sc.nextLine();
		System.out.println("비밀번호: ");
		String pw = sc.nextLine();

		return loginCheck(id, pw);

	}
}
