package sec01.override;

public class Login {
	String id;
	String pw;
	boolean result;
	
	Login(String id, String pw) { // 회원가입
		this.id = id;
		this.pw = pw;
	}
	
	boolean loginCheck(String id, String pw) { // 체크
		if(this.id.equals(id) && this.pw.equals(pw)) {		
			result = true;
		}
		else{
			result = false;
		}
		return result;
	}
	
	void login(String id, String pw) { // 로그인 성공 / 실패
		if (loginCheck(id, pw)) {
		System.out.println("아이디 일치");
		System.out.println("비번 일치");
		}
		else {
		System.out.println("로그인 실패");
		}
	}
}
