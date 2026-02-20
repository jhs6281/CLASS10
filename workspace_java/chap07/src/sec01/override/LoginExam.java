package sec01.override;

public class LoginExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Daum d = new Daum("홍길동", "비번");
		d.login("홍길동", "비번");
		d.login("asdfadsf", "sdfqq");
		
		Naver n = new Naver("네이버아이디", "비번");
		n.login("네이버아이디","비번");
		n.login("ㅁㄴㅇㄹㄴㅁㅇㄹ","비번");
	}

}
