package secQz11;

public class Tv {
	boolean power = false; // 전원
	int vol = 5; // 0~10 직접 입력, 0유지
	int channel = 1;

	// 현재 상태 보기 : 현재 전원 / 볼륨 / 채널 값 표시
	// 켜기
	void on() {
		this.power = true;
		if (power) {
			System.out.println("전원이 켜졌습니다.");
			System.out.println("채널은 1~10");
		}
	}

	// 끄기
	void off() {
		this.power = false;
		if (!power) {
			System.out.println("전원이 꺼졌습니다.");
		}
	}

	// 전원 켰을 때만 실행
	void volume(String x) {
			
		if (power) {
			if ("+".equals(x)) {
				this.vol++;
				System.out.println("볼륨 : " + vol);
			} else if ("-".equals(x)) {
				this.vol--;
				System.out.println("볼륨 : " + vol);
				if (vol <= 0) {
					vol = 0;
					System.out.println("볼륨 : " + vol);
				}
			} else {
				System.out.println("제대로 입력");
			}
		} else {
			System.out.println("전원을 먼저 켜주세요.");
		}
	}

	void channel(int channel) {
		if (power) {
			if (channel > 0 && 11 > channel) {
				this.channel = channel;
				System.out.println("채널은 : " + channel + "입니다.");
			}
			else {
				System.out.println("올바른 채널을 입력해주세요. 1~10");
			}
		} else {
			System.out.println("전원을 먼저 켜주세요.");
		}
	}
}
