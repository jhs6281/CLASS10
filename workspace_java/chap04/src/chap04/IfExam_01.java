package chap04;

import java.util.Scanner;

public class IfExam_01 {

	public static void main(String[] args) {

		int score = 95;

		boolean over90 = score >= 90;
		{
			System.out.println("항상 실행");
		}

		if (over90) {
			System.out.println("90 이상입니다");
		}

//		if(over90) System.out.println("90이상입니다"); 한 줄 작성 = 중괄호 생략 가능

		if (score < 90) {
			System.out.println("90 미만입니다");
		}
		// 정 반대일 경우 !()로 부정 연산자
		if (!(score < 90)) {
			System.out.println("아님");
		}

		System.out.println("IF ELSE문:  ");

		if (score >= 90) {
			System.out.println("90 이상 입니다");
		} else // else가 존재하면 무조건 하나는 실행되는게 보장됨
		{
			System.out.println("90 미만 입니다");
		}

		if (score >= 90) {
			System.out.println("A");
		} else if (score < 90 && score >= 80) {
			// 90미만이고 80이상이면
			System.out.println("B");
		}

		System.out.println("--------------");
		if (score >= 90) {
			System.out.println("90 이상");
		} else if (score >= 80) {
			System.out.println("90미만 80이상");
		} else if (score >= 80) {
			System.out.println("90미만 80이상");
		} else {
			System.out.println("70미만");
		}

		int x = 3;
		if (x % 2 == 0) {
			System.out.println("짝");
		} else {
			System.out.println("홀");
		}

		double random1 = Math.random();
		System.out.println("random1 : " + random1);

		// Math.random()
		// 0 <= Math.random() < 1
		// 0 ~ 0.99999999999

//		정교한 방식
		/*
		 * 1. 홀짝 0*2 <= Math.random()*2 < 1*2 0~1.9999999 int 로 형 변환
		 */
		double rand2 = Math.random(); // 0~0.999999999
		double temp1 = rand2 * 2; // 0~1.99999999
		int result = (int) temp1;
		System.out.println("랜덤 홀짝 : ");
		if (result == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}

		/*
		 * 1~6까지 구하기 (주사위) 0*6 <= Math.random()*6 < 1*6 0~ 5.99999999 int로 바꾸고 +1 하면 1~6
		 */

		rand2 = Math.random();
		double temp2 = rand2 * 6; // 0~5.999

		int result0 = (int) temp2; // 0~5
		result = result0 + 1; // 1~6
		System.out.println("주사위 결과 : " + result);

		rand2 = Math.random();// 0~5.99
		temp2 = rand2 * 6;
		result0 = (int) temp2; // 0~5
		result = result0 + 5; // 5~10
		System.out.println("5~10: " + result);

		// 계산식 끝판왕 정교한 버전
		int min = 5;
		int max = 10;
		rand2 = Math.random();
		temp2 = (int) (rand2 * (max - min + 1)) + min;

		// 쉬운 방식
		rand2 = Math.random();
		temp2 = rand2 * 100000;
		result0 = (int) temp2;
		result = (result0 % 6) + 1;

		// 로또 번호
		// 1~45까지 6개의 숫자를 랜덤으로 뽑아서 제출 하시오
		// 단, 중복 X
		double rand3 = Math.random();
		double rand4 = Math.random();
		double rand5 = Math.random();
		double rand6 = Math.random();
		double rand7 = Math.random();
		double rand8 = Math.random();

		int lotto1 = (int) (rand3 * 46 + 1);
		int lotto2 = (int) (rand4 * 46 + 1);
		int lotto3 = (int) (rand5 * 46 + 1);
		int lotto4 = (int) (rand6 * 46 + 1);
		int lotto5 = (int) (rand7 * 46 + 1);
		int lotto6 = (int) (rand8 * 46 + 1);

		System.out.println(lotto1 + " " + lotto2 + " " + lotto3 + " " + lotto4 + " " + lotto5 + " " + lotto6);

		// 로또 반복문
		for (int i = 1; i <= 6; i++) {
			int lotto = (int) (Math.random() * 45) + 1;
			System.out.print(lotto + " ");
		}
		System.out.println();

		if (score >= 90) {
			System.out.println("90이상");
		}
		// 스캐너 쓰는 방법
		Scanner scanner = new Scanner(System.in);
		System.out.println("아래에 숫자 1개를 입력하시오.");
		int scan = scanner.nextInt();
//		String input = scanner.nextLine();

		System.out.println(scan);
		// 문제1 : 양수 0 음수 판단 입력

		if (scan > 0) {
			System.out.println("문제1 결과: 양수");
		} else if (scan == 0) {
			System.out.println("문제1 결과: 0");
		} else if (scan < 0) {
			System.out.println("문제1 결과: 음수");
		}
		// 문제2 : 홀수인지 짝수인지 판단하여 출력
		if (scan % 2 == 0) {
			System.out.println("문제2 결과: 짝수");
		} else if (scan % 2 == 1) {
			System.out.println("문제2 결과: 홀수");
		} else {
			System.out.println("문제2 결과: 에러");
		}

		// 문제3 : 임의의 두가지 숫자를 받고 둘 중 큰 값 입력
		System.out.println("아래에 숫자 2개를 입력하시오.");
		int bigger_x = scanner.nextInt();
		int bigger_y = scanner.nextInt();

		if (bigger_x > bigger_y) {
			System.out.println("문제3 결과: " + bigger_x);
		} else if (bigger_y > bigger_x) {
			System.out.println("문제3 결과: " + bigger_y);
		} else {
			System.out.println("결과가 같습니다");
		}

		// 문제4: money > 7000 "택시" / if else (money > 3000 : "버스" / else "궁핍합니다")
		System.out.println("아래에 숫자(금액) 1개를 입력하시오.");
		int Mymoney = scanner.nextInt();
		if (Mymoney >= 7000) {
			System.out.println("문제 4 결과: 택시");
		} else if (Mymoney >= 3000) {
			System.out.println("문제 4 결과: 버스");
		} else {
			System.out.println("문제 4 결과: 궁핍하니 걸어가자");
		}

		// 문제5: <if*3>if,else if,else if, else> (me == 바위) if(com == 바위) "비겼다" else
		System.out.println("가위, 바위, 보를 시작합니다."
				+ "\n 가위 "
				+ "\n 바위 "
				+ "\n 보 "
				+ "\n 숫자 (가위,바위,보) 중 하나를 입력하시오.");
		String userGBB = scanner.next();
		int comGBB = (int)(Math.random()*3);
		
		if (comGBB==0){
			if (userGBB.equals("가위")) {
				System.out.println("문제 5: \n"+ "사용자: " + userGBB +"\n컴퓨터: 가위\n결과: 비겼다");
			}
			else if (userGBB.equals("바위")) {
				System.out.println("문제 5: \n"+ "사용자: " + userGBB +"\n컴퓨터: 가위\n결과: 이겼다");
			}
			else if (userGBB.equals("보")) {
				System.out.println("문제 5: \n"+ "사용자: " + userGBB +"\n컴퓨터: 가위\n결과: 졌다");
			}
		}
		else if (comGBB==1) {
			if (userGBB.equals("바위")) {
				System.out.println("문제 5: \n"+ "사용자: " + userGBB +"\n컴퓨터: 바위\n결과: 비겼다");
			}
			else if (userGBB.equals("보")) {
				System.out.println("문제 5: \n"+ "사용자: " + userGBB +"\n컴퓨터: 바위\n결과: 이겼다");
			}
			else if (userGBB.equals("가위")) {
				System.out.println("문제 5: \n"+ "사용자: " + userGBB +"\n컴퓨터: 바위\n결과: 졌다");
			}
		}
		else if (comGBB==2) {
			if (userGBB.equals("보")) {
				System.out.println("문제 5: \n"+ "사용자: " + userGBB +"\n컴퓨터: 보\n결과: 비겼다");
			}
			else if (userGBB.equals("가위")) {
				System.out.println("문제 5: \n"+ "사용자: " + userGBB +"\n컴퓨터: 보 \n결과: 이겼다");
			}
			else if (userGBB.equals("바위")) {
				System.out.println("문제 5: \n"+ "사용자: " + userGBB +"\n컴퓨터: 보\n결과: 졌다");
			}
		}

		else {
			System.out.println("문제 5 : 0, 1, 2 숫자를 제대로 입력하지 않았습니다.");
		}
	
		// 문제6: x, y, z / if (z >= x && z <= y) {"포함"} else if (z >= y && z <= x)
		System.out.println("아래에 숫자를 세번 입력하시오. \n 어떤 값이 더 클지 비교할 예정");
		int xx = scanner.nextInt();
		int yy = scanner.nextInt();
		int zz = scanner.nextInt();
		if (xx > yy && xx > zz) {
			System.out.println("문제6: 첫번째 값이 가장 큽니다.");
		} else if (yy > xx && yy > zz) {
			System.out.println("문제6: 두번째 값이 가장 큽니다.");
		} else if (zz > yy && zz > xx) {
			System.out.println("문제6: 세번째 값이 가장 큽니다.");
		} else {
			System.out.println("문제6: 올바르게 입력하지 않았습니다");
		}
//		문제 7
		System.out.println("1~12까지 숫자만 입력하십시오. (예) 7 ");
		int weather = scanner.nextInt();
		if (weather > 12) {
			System.out.println("정확히 입력해주세요");
		} else if (weather == 12 || weather <= 2) {
			System.out.println("문제7: " + weather + "월은 겨울입니다");
		} else if (weather >= 9) {
			System.out.println("문제7: " + weather + "월은 가을입니다");
		} else if (weather >= 6) {
			System.out.println("문제7: " + weather + "월은 여름입니다");
		} else if (weather >= 3) {
			System.out.println("문제7: " + weather + "월은 봄입니다");
		} else {
			System.out.println("정확히 입력해주세요");
		}

//		문제8

//		문제9
		System.out.println("영상, 영하 기온을 입력하시오");
		int tempt = scanner.nextInt();
		if (tempt > 0) {
			System.out.println("문제9: 영상" + tempt + " 도 입니다.");
		} else if (tempt < 0) {
			System.out.println("문제9: 영하" + tempt + " 도 입니다.");
		} else {
			System.out.println("문제9: 0 도 입니다.");
		}
		System.out.println();

//		문제10

//		Scanner scanner = new Scanner(System.in);

		System.out.println("시간과 분을 입력해주세요 " + "\n 시간: 0~23" + "\n 분: 0~59");
		int inputH = scanner.nextInt();
		int inputM = scanner.nextInt();

		int hour = inputH;
		int minute = inputM + 35;

		if (hour > 24) {
			System.out.println("시간이 정확하지 않습니다.");
		} else if (minute > 60 && minute < 95) {
			if ((hour + 1) > 23) {
				System.out.println("35분 뒤 0시 " + (minute - 60) + "분 입니다");
			} else {
				System.out.println("35분 뒤" + (hour + 1) + "시 " + (minute - 60) + "분 입니다");
			}
		} else if (minute >= 0) {
			System.out.println("35분 뒤" + (hour) + "시 " + (minute) + "분 입니다");
		} else {
			System.out.println("올바르게 입력하지 않았습니다.");
		}

//		문제: 11

		System.out.println("두자리 수의 숫자를 입력해주세요 ");
		int same = scanner.nextInt();

		int sf = same / 10;
		int sb = same - (same / 10 * 10);

		if (sf > 9) {
			System.out.println("문제 11: 정확한 값을 입력하세요");
		} else if (sf == sb) {
			System.out.println("문제 11: 같음");
		} else if (sf != sb) {
			System.out.println("문제 11: 다름");
		} else {
			System.out.println("what");
		}

//		문제 12

//		십의자리: scan12/10 일의자리: scan12 - (scan12/10*10) / if 십의자리 %3 == 0 
//		|| 일의자리 %3 == 0 {"짝"} else if (scan12 >= 0 && scan <= 99) {syso scan12}

//		문제 13
		int dot = scanner.nextInt();
		int x1 = 30;
		int y1 = 10;
		int x2 = 130;
		int y2 = 80;

		if ((dot >= x1) 
		&& (dot <= x2) 
		&& (dot >= y1) 
		&& (dot <= y2)) {
			System.out.println("겹쳐요");
		} else {
			System.out.println("범위를 벗어났습니다.");
		}

	}

}
