package sec02;

public class AnimalExam {

	public static void main(String[] args) {
		Cat cat = new Cat();
		String result = cat.eat("츄르");
		System.out.println(result);
		cat.sound();
		
		System.out.println("==================================");
		
		Cat cat2 = new Cat();
		Animal a1 = (Animal)cat2; // 형 변환
		// 자식 부모 간에 형 변환이 가능하다.
		Animal a2 = cat2;
		// 상속 대상 한정 자동 형 변환
		
		// 부모(Animal)로 형 변환 하면
		// 부모의 형태(eat, sound)만 사용 가능. / grooming 사용 불가
		// 왜 ? 자식을 사용하는 가 ?
		// Override 되어 sound가 "야옹" 이기 때문에.
		
		// 형태는 부모로 제한하되, 내용은 자식의 것으로 사용한다.
		
		
		System.out.println(a2 == cat2);
		System.out.println("cat2.color : " + cat2.color);
		System.out.println("a2.color : " + a2.color);
		
		Animal a3 = new Dog();
		a3.sound();
		
		Dog d1 = (Dog) a3;
		Cat c1  = (Cat)a2;
		c1.grooming();
		
		Dog d2 = (Dog) a2; // Cat 타입의 a2를 Dog타입에 대입
		// 에러
	}

}
