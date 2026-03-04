package sec02;

import java.util.Scanner;

public class OAuth {
	String id;
	String pw;
	Scanner sc = new Scanner(System.in);

	void signin() { // 회원가입

		System.out.println("회원가입 할 아이디를 입력하시오: ");
		String idIn = sc.nextLine();
		System.out.println("아이디 저장 완료.");

		System.out.println("회원가입 할 비밀번호를 입력하시오: ");
		String pwIn = sc.nextLine();
		System.out.println("비밀번호 저장 완료.");

		if (this.id == null) {
			this.id = idIn;
		} else {
			if (!this.id.equals(idIn)) {
				this.id = idIn;
			} else {
//				return false;
			}
		}

		this.id = idIn;
		this.pw = pwIn;
	}

	boolean loginCheck(String id, String pw) { // 로그인 체크
		if (this.id.equals(id) && this.pw.equals(pw)) {
			System.out.println("로그인 체크 성공");
			return true;
		} else
			return false;
	}

	boolean login() { // 로그인

		System.out.println("로그인 아이디를 입력하시오: ");
		String id = sc.nextLine();
		System.out.println("로그인 비밀번호를 입력하시오: ");
		String pw = sc.nextLine();

		return loginCheck(id, pw);

	}

}
