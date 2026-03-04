package sec02;

public class Tving {

	void tvingLogin(OAuth oa) {
		
		if(oa.login()) {
			System.out.println("로그인 성공. 메인 페이지로 이동합니다.");
		} else {
			System.out.println("로그인 실패 다시 로그인 해주세요.");
		}
	}
}
