package secQz12;

import java.util.ArrayList;

public class LogIn {

	// 전략
//	for(int i = 0; i < 어레이리스트.size(); i++) {
//		if (데이터 아이디[i].equals(id) 데이터 패스워드[i].equals(pw)) {
//			System.out.println("로그인에 성공하셨습니다");

	// 초기화 되면 안되는 변수 = 필드에 생성한다고 보면 됨 1
	String id;
	String pw;

	// 초기화 되면 안되는 변수 = 필드에 생성한다고 보면 됨 2
	ArrayList<Member> logInData = new ArrayList<Member>();

	// 12. 디테일 메인에서 아이디 / 비밀번호 / 받아서 회원가입
	// 메인에서 받기 = 생성자로 만듦.
	
	//강사님 버전 =====================================================
	// 회원가입
	void join (Member logInData) {
		this.logInData.add(logInData);
	}
	
	// 로그인
	void login2 (String id, String pw) {
		for (int i=0; i<logInData.size(); i++) {
			Member m = this.logInData.get(i);
			if( m.id.equals(id) && m.pw.equals(pw) ) {
				System.out.println("메인 페이지");
			} else {
				System.out.println("다시 로그인 해주세요.");
			}
		}
	}
	//==========================================================
	void signIn(String id, String pw) {
		// 배열 Member 타입 배열 생성, 매개 변수 맞추고
		Member mem = new Member(id, pw);
		// 매개 변수 id, pw (this X) -> 이걸 전역 배열(logInData)에 넣어서 저장함 -> 가비지 발동 X

		// 중복 아이디 검사 깃발
		boolean flag = false;
		// 중복 검사 for문
		for (int i = 0; i < logInData.size(); i++) {
			if ((mem.id).equals((logInData.get(i)).id)) {
				flag = true;
				System.out.println("중복된 ID입니다.");
				break;
			}
		}
		// 중복 검사 성공 -> 회원 가입 성공
		if (!flag) {
			logInData.add(mem);
			System.out.println("회원가입 성공!");
		}
	}

	// 개인 확인용 회원 목록 (그냥 헷갈려서 넣은 것)
	void memInfo() {
		// 배열만큼 돌 때 동안
		for (int i = 0; i < logInData.size(); i++) {
			// Member 타입의 mem은 배열의 i번째를 리턴 받는다. = mem은 Member 클래스
			Member mem = logInData.get(i);
			// ID / PW 출력
			System.out.println("ID: " + mem.id + ", PW: " + mem.pw);
		}
	}

	void logIn(String id, String pw) {
		// 배열만큼 돌 때 동안
		for (int i = 0; i < logInData.size(); i++) {
			// Member 타입 mem(지역 변수라 재탕중ㅋ) i번째 리턴
			Member mem = logInData.get(i);
			// 12. 3-1 로그인 성공 / 12. 3-2 실패
			if (mem.id.equals(id) && mem.pw.equals(pw)) {
				System.out.print("로그인 성공! ");
				System.out.println("메인 페이지로 이동");
			} else {
				System.out.println("로그인 실패. 아이디 혹은 비밀번호를 확인해주세요");
			}
		}
	}
}
