package secQz07;

public class Quiz07 {

	boolean power = false;

	//켜기
	void on() {
		this.power = true;
		if (power) {
			System.out.println("전원이 켜졌습니다.");
		}
	}

	//끄기
	void off() {
		this.power = false;
		if (!power) {
			System.out.println("전원이 꺼졌습니다.");
		}
	}

	//전원 켰을 때만 실행
	void wind1() {
		if (power) {
				System.out.println("1단 입니다.");
		}
		else {
			System.out.println("전원을 먼저 켜주세요.");
		}
	}

	void wind2() {
		if (power) {
				System.out.println("2단 입니다.");
		}
		else {
			System.out.println("전원을 먼저 켜주세요.");
		}
	}
}
