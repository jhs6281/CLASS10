package quiz.quiz1;

public class Melon {
	// 문제2 필드
	// 멜론 음악 차트를 관리하는 시스템
	// 목록을 관리하기 위해 클래스를 만들기로 했습니다
	// 전달인자 제목, 가수, 앨범명, 가사, 시간[초단위]
	// - 곡 2곡 이상의 정보를 저장하고
	// - 각 곡의 정보를 출력

	String 가수; 
	String 제목; 
	String 앨범명; 
	String 가사; 
	int 시간; 

	Melon(String 가수, String 제목, String 앨범명, int 시간) {
		this.가수 = 가수; 
		this.제목 = 제목; 
		this.앨범명 = 앨범명; 
		this.가사 = 가사; 
		this.시간 = 시간; 
	}
	
	void Info() {

		System.out.println("가수 : " + 가수 + " / 제목 : " + 제목 
				+ " / 앨범명: " + 앨범명 + " / 가사 : " + 가사 + " / 시간 : " + 시간);	

	}
}
	
