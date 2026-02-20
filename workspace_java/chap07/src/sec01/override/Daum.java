package sec01.override;

public class Daum extends Login {

	Daum(String i, String p) {
		super(i, p);
	}

	@Override
	void login(String id, String pw) {
		if (loginCheck(id, pw)) {
			System.out.println("다음 로그인 성공");
		} else {
			System.out.println("다음 로그인 실패");
		}
	}
}
