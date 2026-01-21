package secQz08;

import java.util.Scanner;

public class UpDown {

	int num; // 랜덤 숫자
	int userNum; // 사용자 입력값
	Scanner scan = new Scanner(System.in); // 스캐너 소환
	boolean flag; // false 상태
	int rand = (int) (Math.random() * 10) + 1; // 1~10
	int count;

	void game() { // 게임 호출
		while (!flag) { // 깃발 들 때까지 반복
			this.num = rand; // num = 랜덤값
			int sc = scan.nextInt(); // 스캐너 int 변수 담기
			System.out.println("숫자를 입력해주세요 (1~10)");
			this.userNum = sc;
			count++;

			if (num == userNum) {
				System.out.println("정답!");
				System.out.println("정답까지 " + count + "회");
				flag = true;
			} else if (num < userNum) {
				System.out.println("받은 수 : " + userNum + " / 다운");
			} else if (num > userNum) {
				System.out.println("받은 수 : " + userNum + " / 업");
			} else {
				System.out.println("똑바로");
			}
		}
	}
}
