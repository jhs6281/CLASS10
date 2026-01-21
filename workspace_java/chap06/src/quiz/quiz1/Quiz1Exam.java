package quiz.quiz1;

public class Quiz1Exam {

	public static void main(String[] args) {
		Melon m1 = new Melon("화사", "Good Goodbye", "Good Goodbye", 60);
		m1.가사 = "바이바이";
		
		Melon m2 = new Melon("한로로", "사랑하게 될 거야", "이상비행", 50);
		m2.가사 = "사랑해";
		
		Melon m3 = new Melon("가사 없음 3333", "333test3", "test", 80);
		
		m1.Info();
		m2.Info();
		m3.Info();
		
		System.out.println("가수만 출력: " + m1.가수); 

		System.out.println("문제 33333333\\\\\\\\\\===================================");
		
		Movie02 mv = new Movie02();
		Movie02 mv2 = new Movie02();
		
		mv.set("아바타", 2025);
		mv2.set("곡성", 2016);
		
		System.out.println(mv.title);
		System.out.println(mv.getTitle() + " " + mv.getDate());
		System.out.println(mv2.getTitle() + " " + mv2.getDate());
		
		mv.Info();
		mv2.Info();
		
		System.out.println(mv.속편제작());
		
		System.out.println("안녕하세요" + 33);
		
		Cafe03 cf1 = new Cafe03("휴먼카페1", 3000);
		Cafe03 cf2 = new Cafe03("휴먼카페2", 6000);
		
		cf1.Info();
	}

}
