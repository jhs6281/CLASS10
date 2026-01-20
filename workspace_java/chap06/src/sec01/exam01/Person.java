package sec01.exam01;

public class Person {
	String name = "정현수";
	int age = 10;

	public static void main(String[] args) {
		Person me = new Person();

		System.out.println("이름 : " + me.name + " / 나이 : " + me.age);
	}

	public class Car {
		String brand = "마세라티";
		int speed = 3;

		void drive() {
			System.out.println(brand + "가 " + speed + "km로 달립니다");
		}
		
			
	}

}