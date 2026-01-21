package quiz.quiz1;

public class Movie02 {
	//문제 3 # 메소드
	//영화 관리
	//제목, 개봉년도
	//메소드를 통해서
	// -각 값을 따로 받아서 따로 저장하기 / setter
	// 	+제목만 받아서 필드에 저장하는 메소드
	// -각 값을 하나만 돌려주는 메소드 / getter
	// 	+제목만 돌려주는 메소드 return title;
	// -모든 정보를 예쁘게 출력
	// 2개 이상 관리
	
	String title;
	int date;
	String 속편제작;
	
	//1 set + 오버로딩
	void set(String title, int date) {
		this.title = title;	
		this.date = date;	
	}
	
	// 타이틀만 받기
	void set(String title) {
		this.title = title;	
	}
	
	// 출시년도 받기
	void set(int date) {
		this.date = date;
	}
	
	
	//2 get값만 받음 (출력은 안함)
	String getTitle() {
		return title;
	}
	
	
	int getDate() {
		return date;
	}
	
	String 속편제작() {
		return this.title+2;
	}
	//3 
	void Info() {
		System.out.println("제목 : " + title + " / 출시 : " + date);
	}
	
	
	
}
