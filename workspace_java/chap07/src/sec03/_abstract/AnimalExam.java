package sec03._abstract;

public class AnimalExam {

	public static void main(String[] args) {

//		Animal a = new Animal(); // 추상 클래스는 new 불가 

		Cat c = new Cat();
		c.sound();

		Animal a = new Cat();

		Cat cat = (Cat) a;

		c.sound();
		cat.sound();
		a.sound();

		System.out.println(c.kind);
		System.out.println(cat.kind);
		System.out.println(a.kind);
		
		//test(); // static이 아니라서 실행 불가능

	}

	void test() {

	}

}
