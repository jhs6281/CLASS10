package sec04_return03;

public class Car {
	int gas;

	void setGas(int g) {
		gas = g;
		//return; 생략된 형태
	}

	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas 없음");
			return false;
		} else {
			System.out.println("gas 있음");
			return true;
		}
	}

	boolean isLeftGas2() {
		//return 하는 순간에 메소드 종료
		if (gas == 0) {
			System.out.println("gas 없음");
			return false;
		}
		
		System.out.println("가스 있음");
		return true;
		//에러: 도달할 수 없는 코드 (이미 리턴 했기 때문에)
//		System.out.println();
	}
	
	//  return 한번만 하는 방식
	boolean isLeftGas3() {
		boolean result = false;
		if (gas == 0) {
			System.out.println("gas 없음");
			result = false;
		} 
		else {
			System.out.println("gas 있음");
			result = true;
		}
		
		return result;
	}
	
	// 참 거짓 반환하기
	boolean isLeftGas4() {
		return (gas != 0);
	}
	
	void run() {
		while(true) {
			if (gas > 0) {
				System.out.println("가자 잔량: " + gas);
				gas--;
			} else {
				System.out.println("멈춰 잔량: " + gas);
				return;
				
				//void는 return 생략 가능
				//위 코드와 같이 사용 가능
			}
		}
	}
}


