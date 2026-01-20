package sec03;

public class CarExam {

	// 생성자는 new를 선언할 때 초기화된다.
	class Car{
		
//		new Car();
		
		// 생성자를 생략한 경우
		// 즉, 생성자가 하나도 없는 경우
		// 기본 생성자가 자동 완성된다.

//		ex: Car(){ 기본 생성자 } 

		// 반대로 생성자가 있으면 기본 생성자는 안 만들어진다.

//		String brand = "KIA";
		String brand;
//		Car(){
		// 보통 생성자는
		// 필드 값을 초기화 할 때 많이 사용된다.
//			brand = "KIA";
//		}

//		Car c3 = null;
//		try {
//			//생성자가 실행 되어야 실제 생성이 된다
//			c3 = new Car();
//		} catch (Exception e) {
//			System.out.println("new Car () 에서 예회 발생");
//		}
//		System.out.println("c3 : " + c3);

		String model;
		int maxSpeed;
		Car(String b, String m, int ms){
			brand = b;
			model = m;
			maxSpeed = ms;
		}
		
		Car(){
//			brand = "현대";
//			model = "그랜저";
//			maxSpeed = 240;
			
			// this : 다른 오버로딩 된 생성자 호출
			// 무조건 가장 먼저 실행 돼야 한다
			this("현대", "그랜저", 240);
			//이거 위로 올리면 버그남
			System.out.println("다른 생성자 호출 이후 실행");
		}
	}
}
