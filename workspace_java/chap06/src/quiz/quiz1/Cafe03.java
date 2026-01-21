package quiz.quiz1;

public class Cafe03 {
	// 4 생성자
	// 카페 창업
	// 상호, 필요자본금
	// 생성할 때 상호와 필요자본금을 꼭 입력해야 생성되도록
	// 그리고 생성과 동시에 메뉴 1에는 "아아", 메뉴 2는 "따아"

	String name;
	int money;
	String menu1;
	String menu2;

	Cafe03(String name, int money) {
		this.name = name;
		this.money = money;

		this.menu1 = "아아";
		this.menu2 = "따아";

	}
	
	void Info() {
		System.out.println("상호: "+ this.name + " / 필요자본금: " + this.money + " / 메뉴1: " + menu1 + " / 메뉴2: " + menu2);
	}
}
