package sec04_return03;

public class CarExam01 {

	public static void main(String[] args) {
		Car car = new Car();
		boolean status = car.isLeftGas();
		System.out.println("가스 남았나? : " + status);
		
//		car.gas = 3; 동일 코드 / 추 후에 메소드에 제한을 두기 때문에 아래 코드가 좋다
		car.setGas(8);
		System.out.println(car.isLeftGas());
		
		car.run();
		System.out.println("4885 운행을 종료합니다");
	}

}
