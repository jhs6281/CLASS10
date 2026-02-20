package sec01.override;

public class Naver extends Login {

	Naver(String id, String pw) { // 네이버 회원가입
		super(id, pw);
	}

	@Override
	void login(String id, String pw) {
		if (loginCheck(id, pw)) {
			System.out.println("네이버 로그인 성공");
		} else {
			System.out.println("네이버 로그인 실패");
		}
	}
}
