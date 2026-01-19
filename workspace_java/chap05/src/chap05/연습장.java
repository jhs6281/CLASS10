package chap05;

import java.util.Scanner;

public class 연습장 {

	public static void main(String[] args) {
		// 문제 11

		Scanner scanner = new Scanner(System.in);
		int[] seat = new int[10];


//		0누르면 깃발 들기
		boolean flag = false;

		//시작
		while (!flag) {
			
			// 메뉴 1번 방어 코드용 깃발
			boolean numRight = false;
			// 메뉴 3번 잔여 좌석 카운트용 변수
			int count = 0;
			
			// 메뉴 (스캐너 숫자 입력 받기)
			System.out.println("메뉴 : \"1.예약 2.모든 좌석 현황 3.잔여 좌석 0.종료\" ");
			int scan = scanner.nextInt();

			//1 예약
			if (scan == 1) {
				while (!numRight) {
					System.out.println("좌석 예약을 시작합니다.");
					System.out.println("예약을 원하신다면 1번~10번 자리를 입력해주세요");
					System.out.println("(예: 7)");

					int scan2 = scanner.nextInt();

					//빈 자리일 때, 0 < 입력한 숫자 < 10 일 때
					if (scan2 > 0 && scan2 <= 10 && seat[scan2-1] == 0) {
						seat[scan2 - 1] = 1;
						System.out.println(scan2 + "번 자리 예약 완료!");
						numRight = true;
					}
					//이미 예약된 자리일 때
					else if (scan2 > 0 && scan2 <= 10 && seat[scan2-1] == 1) {
						System.out.println(scan2 + "번 자리는 이미 예약되어 있습니다. ");
						numRight = true;
					}	
					//방어 코드
					else {
						System.out.println("올바른 숫자를 입력해주세요.");
						System.out.println();		
					}
				}
			}
			
			//2 예약 현황
			else if (scan == 2) {
				for (int i = 0; i < 10; i++) {
					if (seat[i] == 0) {
						System.out.println(i + 1 + "번 자리: 비었음");
					}
					if (seat[i] == 1) {
						System.out.println(i + 1 + "번 자리: 이미 예약된 좌석");
					}
				}
			}

			//3 잔여 좌석
			else if (scan == 3) {

				for (int i = 0; i < 10; i++) {
					if (seat[i] == 0) {
						count++;
					}
				}
				System.out.println("남은 좌석 수: " + count + "자리");

			}

			//0 종료
			else if (scan == 0) {
				flag = true;
			}
			
			//방어 코드
			else {
				System.out.println("올바른 숫자를 입력해 주세요.");				
				System.out.println();				
			}
		}

	}
}