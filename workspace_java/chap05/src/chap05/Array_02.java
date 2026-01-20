package chap05;

public class Array_02 {

	public static void main(String[] args) {

		/*
		 * 배열 array
		 * 
		 * 한번에 여러 변수를 만드는 방법 같은 타입만 선언할 수 있음 생성할 때 전체 크기를 지정해줘야 함 생성된 여러 변수들은 index로
		 * 관리한다 index는 0번부터 시작
		 */

//		선언방법
		int[] a1; // java 스타일
		int[] a2;
		int a3[]; // c스타일

//		배열 변수는 참조 타입이라서 null을 넣을 수 있다
		a1 = null;

		int score_0 = 90;
		int score_1 = 85;
		int score_2 = 70;

		/*
		 * 첫번째 [] : int[] int 만으로 구성된 배열 변수 타입이다 두번째 [] : new int[30] 배열의 크기. 즉, 한번에 만들
		 * 변수의 개수 세번째 [] : score[0] 만들어진 변수 중에서 몇번째인가? index는 0부터 시작한다
		 */

		// 배열을 선언하는 첫번째 방법
		int[] score = new int[30];
		score[0] = 90;
		score[1] = 85;
		score[2] = 70;

		System.out.println("score[0]: " + score[0]);
//		score[40] = 2; [0~29] 범위로 설정해서 큰 값(40)을 입력하면 에러가 나온다

		String[] str = new String[3];
		System.out.println("str[0]: " + str[0]);
		System.out.println("score[5]: " + score[5]);

//		배열 생성 후 기본 값
//		0, false, null로 초기화 됨 (타입에 따라 다름)

//		배열을 선언하는 두번 째 방법
		int[] i1 = new int[] { 90, 85, 70 };

		System.out.println("il[1]: " + i1[1]);

		int[] i2 = null;
		i2 = new int[] { 90, 85, 70 };

		int[] i3 = { 90, 85, 70 };
//		i3 = {90, 85, 70};

		int sum = 0;

		for (int i = 0; i < 3; i++) {
			sum += i3[i];
		}

		System.out.println(sum);
		System.out.println(sum / 3.0);
		System.out.println("배열의 길이: " + i3.length);
		for (int i = 0; i < i3.length; i++) {
			sum = sum + i3[i];
		}

//		문제1
		int[] a5 = new int[5];

		for (int i = 0; i < a5.length; i++) {
			a5[i] = i + 1;
//			System.out.println(a5[i]);
		}
		for (int a = 0; a < a5.length; a++) {
			System.out.println(a5[a]);
		}

		System.out.println("args : " + args.length);

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}

//		문제2
		int[] q2 = new int[] { 7, 12, 8 };
		int[] nq2 = new int[3];

		for (int i = 0; i < q2.length; i++) {
			nq2[i] = q2[i];

			System.out.println(nq2[i]);
		}
		System.out.println("------------문제2끝------------");

//		문제3
		int[] rq2 = new int[] { 7, 12, 8, 5 };
		int[] rnq2 = new int[rq2.length];

		for (int i = 0; i < rq2.length; i++) {
			rnq2[i] = rq2[rq2.length - i - 1];

			System.out.println(rnq2[i]);
		}

		System.out.println("------------문제3끝------------");

//		문제4-1

		int[] arr = new int[] { 7, 12, 8, 3, 4, 7, 8, 9, 41 };
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				++count;
			}
		}
		System.out.println(count);

//		문제 4-2
		int[] q4 = new int[] { 7, 12, 8, 3, 5, 8, 2 };
		int q4_count = 0;

		for (int i = 0; i < q4.length; i++) {
			if (q4[i] > 4) {
				++q4_count;
			}
		}
		System.out.println(q4_count);

		System.out.println("------------문제4끝------------");

//		문제5

		int[] q5 = new int[] { 2, 4, 5, 1 };

		for (int j = 1; j <= 5; j++) {
//			5를 세는 동안
			boolean flag = false;
//			5를 세는 동안 / 깃발은 false로 초기화된다
			for (int i = 0; i < q5.length; i++) {
//				5를 세는 동안 / 골인한 사람만큼(4) 세는 동안 
				if (q5[i] == j) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("빠진 번호: " + j);
			}
		}

		System.out.println();

		System.out.println("------------문제5끝------------");
//		문제6
		int[] num = new int[] { 2, 4, 7, 5, 1, 4, 6 }; // 가장 큰 수
		int big = num[0];

		for (int i = 0; i < num.length; i++) {
			if (big < num[i]) {
				big = num[i];
			}
		}
		System.out.println(big);
		System.out.println("------------문제6끝------------");

//		문제7 두번째 큰 수
		int[] q7 = new int[] { 3, 4, 7, 5, 1, 4, 6 }; // 두번째 큰 수
		big = q7[0];
		int second = q7[0];

		for (int i = 0; i < q7.length; i++) {
			// 가장 큰 수
			if (big < q7[i]) {
				big = q7[i];
			}

		}
		for (int h = 0; h < q7.length; h++) {
			// 두번째 큰 수
			if (second < q7[h] && q7[h] < big) {
				second = q7[h];
			}
		}

		System.out.println("가장 큰 수 : " + big);
		System.out.println("두번째 큰 수 : " + second);

		System.out.println("------------문제7끝------------");

		// 문제8 // 오른쪽으로 한칸 씩 밀기 i+1 / 앞자리 0
		int[] q8 = new int[] { 3, 4, 7, 5, 1, 4, 6 };
		int[] q8_1 = new int[7];
		int[] q8_2 = new int[7];
		
		//1Round
		//첫 줄
		for (int i = 0; i < q8.length; i++) {
			//둘째줄
				if (i < q8.length - 1) {
					//다음값에 현재값을대입한다
					q8_1[i + 1] = q8[i];
				}	
			System.out.print( q8_1[i]);
		}
		System.out.println();
		
		//2Round
		
		//첫 줄
		for (int i = 0; i < q8.length; i++) {
		//둘째줄
				if (i < q8.length - 2) {
					//다음값에 현재값을대입한다
					q8_2[i + 2] = q8[i + 1];
				}
	
			System.out.print( q8_2[i]);
		}
		System.out.println();
		
		
		//3Round
		for (int i = 0; i < q8.length; i++) {
			
			// 조건 : array가 최대길이 -6일 때까지
				if (i < q8.length - 3) {
					//다음값에 현재값을대입한다
					q8_2[i + 3] = q8[i + 2];
				}
	
			System.out.print( q8_2[i]);
		}
		System.out.println();
	


		// 문제 8-1

//		int [][] q81 = new int [3][];
//
//			for (int j = 0; j < q81.length; j++) {
//				for (int k = 0; k < q81[j][k].length; k++) {
//				}
//			}

		System.out.println("------------문제8끝------------");

//		문제9 
//		밀기2 / 앞자리 = 이전 끝자리 length - 

//		문제10
//		임시 비밀번호 8자리
//		10-1 : 숫자만
//		10-2 : 소문자만
//		10-3 : 숫자 2개 이상 , 대/ 소문자 각 1개 이상

//		문제11
//		자리가 10개 있는 소극장의 예약 시스템
//		자리 번호는 1~10번까지 번호의 자리가 있습니다
//		메뉴 : "1.예약 2.좌석 현황" 3. 잔여 좌석 0. 종료
//		조건 1: 예약이 가능하다면 "n번 자리 예약 되었습니다."
//		조건 2: 예약이 되어있다면 "이미 예약 되어 있습니다"

//		문제 12
//		로또 번호 6개 배열에 저장 중복 없이

//		문제
		/*
		 * {0, 0, 0, 0}, // 1층 {0, 0, 0, 1}, // 2층 0: 주차됨 {1, 0, 1, 1}, // 3층 1: 비어 있음
		 * {1, 1, 1, 1}, // 4층
		 */
//		문제 13-1 2층에 주차된 차량 수

//		문제 13-2 전체 남은 자리 수 

	}

}
