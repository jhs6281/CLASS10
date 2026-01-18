package chap05;

public class Qhrtmq_00 {

	public static void main(String[] args) {

		int[][] q1 = new int[3][5];

		int[] q1_1 = new int[5];
		int[] q1_2 = new int[5];
		int[] q1_3 = new int[5];

		q1[0] = q1_1;
		q1[1] = q1_2;
		q1[2] = q1_3;

		int 규칙찾기1 = 0;
		int 규칙찾기2 = 1;

		for (int i = 0; i < q1.length; i++) {
			int count = 0;
//			System.out.println(q1[i]); q1 자리 3칸 생성
			for (int j = 1; j < (1 + q1[i].length); j++) {
//				System.out.println(q1[i]); //15칸 생성 / 규칙1 값 (0)
				q1[i][j - 1] = j + 규칙찾기1;
				System.out.println(q1[i][j - 1]);
				count++;
			}
			if (count == q1[i].length) {
				// 규칙 찾기 +0, 10, 100
				규칙찾기2 *= 10; // (규칙2 값은 10배씩 증가)
				규칙찾기1 = 규칙찾기2; //
			}
		}

		System.out.println("3차원 배열 시작****************************************");

		// gpt 1번
		int[][][] arr = new int[2][3][4];
		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr.length); >> arr 길이 2
			for (int h = 0; h < arr[i].length; h++) {
//			System.out.println(arr[2].length); >> 에러: 잘못된 값 arr[숫자XXXXXX]				
				for (int j = 0; j < arr[i][h].length; j++) {
					arr[i][h][j] = j + 1;
					System.out.println("gpt 문제 1: " + arr[i][h][j]);
				}
			}
		}

		// gpt 2번
		int[][][] arr2 = new int[3][3][3];
		for (int i = 0; i < arr2.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr2[i].length; j++) {
				for (int k = 0; k < arr2[i][j].length; k++) {
					sum += arr2[i][j][k] + 1;
				}
			}
			System.out.println(sum);
		}

		// 아파트 동의 구조가 층마다 다를 수 있습니다.
		// >> 가변 배열 or 변수

		// 아래 조건에 맞는 3차원 배열을 만드세요.

		// 총 2개의 동(buildings)이 있습니다.
		// >> int [2][][]

		// 1동은 3층까지 있고, 2동은 2층까지 있습니다.
		// >> int [2][](가변으로 +1)[]

		// (층마다 호실 수는 자유롭게 설정하세요 - 가변 배열 활용)
		// >> int [2][][](가변)

		// 각 호실에는 거주 인원수(정수)를 저장합니다.

		// 조건: for-each문(향상된 for문)을 사용하여
		// >> 모르겠음.
		// 모든 호실의 인원수를 출력하고,
		// 전체 아파트에 살고 있는 총 인원수를 계산해 출력하세요.
		// >> sum

		int sum = 0;
		int[][][] arr3 = new int[2][][];

		int[][] arr3_1 = new int[3][1];
		int[][] arr3_2 = new int[2][1];

		arr3[0] = arr3_1;
		arr3[1] = arr3_2;

		for (int i = 0; i < arr3.length; i++) {

			for (int j = 0; j < arr3[i].length; j++) {
				for (int k = 0; k < arr3[i][j].length; k++) {
					sum += arr3[i][j][k] + 1;
				}
			}
		}
		System.out.println("gpt 문제 2: " + sum);

		// 조건: for-each문(향상된 for문)을 사용하여
		// 조건: for-each문(향상된 for문)을 사용하여
		// 조건: for-each문(향상된 for문)을 사용하여

//		-------------------------AI문제2
//		0동
//		1층
//		101호실 5명거주 102호실 2명거주 103호실 2명거주
//		2층
//		201호실 2명거주 202호실 4명거주 203호실 4명거주
//		3층
//		301호실 2명거주 302호실 5명거주 303호실 2명거주
//
//		1동
//		1층
//		101호실 0명거주 102호실 0명거주 103호실 0명거주 104호실 0명거주
//		2층
//		201호실 4명거주 202호실 5명거주 203호실 2명거주 204호실 5명거주
//
//		총 인원수 44 명
		int[][][] Aiq = new int[2][][];

		// 초기화 필요. int값을 넣을 공간이 Null 값이기 떄문
		Aiq[0] = new int[3][];
		////////////////////////////////////////////
		Aiq[0][0] = new int[] { 5, 2, 2 };
		Aiq[0][1] = new int[] { 2, 4, 4 };
		Aiq[0][2] = new int[] { 2, 5, 2 };

		// 얘도
		Aiq[1] = new int[2][];
		////////////////////////////////////////////
		Aiq[1][0] = new int[] { 0, 0, 0, 0 };
		Aiq[1][1] = new int[] { 4, 5, 2, 5 };

		sum = 0;

		for (int i = 0; i < Aiq.length; i++) {

			for (int j = 0; j < Aiq[i].length; j++) {
				for (int k = 0; k < Aiq[i][j].length; k++) {
					sum += Aiq[i][j][k]/* +1 변수 값을 직접 지정 했으니 필요 없음 */;
				}
			}
		}

		System.out.println("gpt 문제 3: " + sum);

		/*
		 * 
		 * [1] 데이터 구조 대상: 3개의 서버, 각 서버당 4일간의 데이터, 하루 중 6개 시간대의 기록 값: 1부터 시작하여 1씩 증가하는
		 * 연속된 정수 (총 72개)
		 * 
		 * [2] 장애 의심 구간 필터링 조건 서버: 0번 서버를 제외한 나머지 모든 서버
		 * 
		 * 날짜: 인덱스 번호가 홀수인 날
		 * 
		 * 시간: 각 날짜의 마지막 3개 시간대
		 * 
		 * 수치: 기록된 값이 40 이상인 경우
		 * 
		 * [3] 최종 출력값
		 * 
		 * 위 조건을 모두 만족하는 데이터들의 합계와 해당 데이터의 개수
		 * 
		 */
		sum = 0;
		int count = 0;
		int data[][][] = new int[3][4][6];
		// i = 1 >> 서버: 0번 서버를 제외한 나머지 모든 서버

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				for (int k = 0; k < data[i][j].length; k++) {
					++count;
					data[i][j][k] = count;
					if (k > 2) {

					}
				}
			}
		}
		System.out.println(sum);

		// sum += data[i][j][k]+1;

		int[][][] arrr = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };

		for (int i = 0; i < arrr.length; i++) {
			sum = 0;
			for (int j = 0; j < arrr[i].length; j++) {
				for (int k = 0; k < arrr[i][j].length; k++) {
					sum += arrr[i][j][k];
				}

			}
			System.out.println(i + "층의 합: " + sum);
		}

		int ii = 0;
		int jj = 0;
		int kk = 0;

		for (int i = 0; i < arrr.length; i++) {
			sum = 0;
			for (int j = 0; j < arrr[i].length; j++) {
				for (int k = 0; k < arrr[i][j].length; k++) {
					if (arrr[i][j][k] > sum) {
						sum = arrr[i][j][k];
						ii = i;
						jj = j;
						kk = k;
					}
				}

			}

		}
		System.out.println("최댓값: " + sum);
		System.out.println("위치: (" + ii + ", " + jj + ", " + kk + ")");

		int[][][] qqqq = new int[2][12][5];
		int[][] riskMap = new int[2][12];
		count = 0;
		sum = 0;
		int average = 0;

		int dede = 0;

		for (int i = 0; i < qqqq.length; i++) {

			for (int j = 0; j < qqqq[i].length; j++) {
				for (int k = 0; k < qqqq[i][j].length; k++) {
					++count;
					qqqq[i][j][k] = count;
					sum += qqqq[i][j][k];
					average /= qqqq[i][j].length;
					dede = i;

				}
				riskMap[dede][j] = average;
//				riskMap[dede] = average;

			}

		}

//		가변 시작!!! 
//		전략: q88[0] = 기본값 { 3, 4, 7, 5, 1, 4, 6 }
//		(q88.length11) = (j+1)
//		q88[1] = {초기값, i+2, i+3, i+4, i+5, i+6, i+7}
//		q88[2] = {초기값, 초기값, i+2, i+3, i4, i+5, i+6}

//		여기서부터
//		int[][] q88 = { { 3, 4, 7, 5, 1, 4, 6 }, {}, {}, {}, {}, {}, {} };
//		System.out.println("q88 길이 : " + q88.length);
//		for (int i = 0; i < q88.length; i++) {
//			System.out.println("q88.[i] 길이 : " + q88[i].length);
////		q88[i].length 길이 = 7
//			for (int j = 0; j < q88[i].length; j++) {	
//				if (j < q88[i].length - (j+1)) {
//					System.out.print(0);
//				}
//			}
//			System.out.println();
//		}

////		6~0 인덱스 순회하는 반복문
//		for (int i = round.length - 1; i > 0; i--) {
//			
////			새로운 배열 (마지막 전 값부터 6~0까지의 수를 q8[0] 에 저장) 
//			q8[i] = round[i - 1];
//			//415743
//		}
//		q8[0] = 0;
//
//		// 출력
//		for (int i = 0; i < q8.length; i++) {
//		    System.out.print(q8[i] + " ");
//		}
		System.out.println("======================================");
//		
//		int len = round.length;
//		int[][] q8 = new int[len][len];
//		q8[0] = round;
//		count = 0;
//
//		for (int i = 0; i < len; i++) {
//			for (int j = len - 1; j >= 0; j--) {
//				++count;
//				if (j - count >= 0) {
//					q8[i][j] = q8[i][j - count];
//				}
//			}
////			System.out.println(q8[i][0]);
//			q8[i][i] = 0 ;
//			for (int k = 0; k < len; k++) {
//				System.out.print(q8[i][k] + " ");
//			}
//			System.out.println();
//		}

		int[] round = { 1, 2, 3, 4, 5, 6, 7 };

		for (int i = 0; i < round.length; i++) {
			System.out.print(round[i] + " ");
		}
		System.out.println();

		for (int k = 0; k <= round.length; k++) {
			for (int i = round.length - 1; i > 0; i--) {
				round[i] = round[i - 1];
			}
			round[0] = 0;

			for (int i = 0; i < round.length; i++) {
				System.out.print(round[i] + " ");
			}
			System.out.println();
		}

		System.out.println("----------------------------------------");

		// 문제 9
		int[] round1 = { 1, 2, 3, 4, 5, 6, 7 };

		for (int i = 0; i < round1.length; i++) {
			System.out.print(round1[i] + " ");
		}
		System.out.println();

		for (int k = 0; k <= round1.length; k++) {
			int aarr = round1[round1.length - 1];
			for (int i = round1.length - 1; i > 0; i--) {
				round1[i] = round1[i - 1];
			}
			round1[0] = aarr;

			for (int i = 0; i < round1.length; i++) {
				System.out.print(round1[i] + " ");
			}
			System.out.println();
		}

		System.out.println("------------------");
		// 문제 10-1
		int[] q81 = new int[8];

		for (int i = 0; i < q81.length; i++) {
			int rd = (int) (Math.random() * 10);
			q81[i] = rd;
			System.out.print(rd);
		}
		System.out.println();

		System.out.println("=-================================");

		// 문제 10-2
		q81 = new int[8];

		for (int i = 0; i < q81.length; i++) {
			char code = (char) ((Math.random() * 26) + 97);
			// 자동 형 변환?
			q81[i] = code;
			System.out.print(code);
		}
		System.out.println();

		System.out.println("=================================");

		// 문제 10-3

//		if(숫자 배열.length>=2 && 대문자 배열>=1 && 소문자 배열>=1 && pw[랜덤] != 0) { pw[랜덤] = 값 }
		System.out.println("문제 10-3 비밀번호 : ");
//		int[] pw = new int[8];
//		[0][1][2]
//				i=0; i<=3; i++
//		j=0; j<=8; j++
//		pw[i] != random
//		{
//			pw[i] = random
//		}
		
//		char[0][0] aaaa = new char [2][2]; 문자
//		char[0][1] aaaa = new char [2][2]; 숫자
		
//		i<8
//		j<8 if (중복) 
//		pw = aaaa[i][random]
//		
//		
//		aaaa[0] = {0, 1};
		
		int[] num = new int[8];
		int[] abc = new int[8];
		int[] ABC = new int[8];

		int pwR = (int) (Math.random() * 8) + 1;

		for (int i = 0; i < num.length; i++) {
			int random = (int) (Math.random() * 10);
			char code1 = (char) ((Math.random() * 26) + 97);
			char code2 = (char) ((Math.random() * 26) + 65);

			num[i] = random;
			abc[i] = code1;
			ABC[i] = code2; 
			
			System.out.print(random + " ");
			System.out.print(code1 + " ");
			System.out.print(code2 + " ");
		}
		System.out.println();

		abc = new int[8];

		for (int i = 0; i < abc.length; i++) {

			// 자동 형 변환?

		}
		System.out.println();
		System.out.println("===========================");

		// 문제 12
		System.out.println("문제 12 : 로또");

		int[] lot = new int[6];
//		lot[0] = 0;

		// 배열만큼 돈다
		for (int i = 0; i < lot.length; i++) {
//			플래그 = 거짓
			boolean flag = false;
//			로또 랜덤 슷자 45
			int lotto = (int) (Math.random() * 45 + 1);

			for (int j = 0; j < i; j++) {
				if (lot[j] == lotto) {
					flag = true;
					break;
				}
			}

			if (flag) {
				i--;
			} else {
				lot[i] = lotto;
				System.out.print(lot[i] + " ");
			}
		}

		System.out.println();

		// 문제 13
		int sum1 = 0;
		int sum2 = 0;

		count = 0;

		int[][] car = { { 0, 0, 0, 0 }, { 0, 0, 0, 1 }, { 1, 0, 1, 1 }, { 1, 1, 1, 1 } };

		for (int i = 0; i < car.length; i++) {
			for (int j = 0; j < car[i].length; j++) {
				if (car[i][j] == 0 && i == 1) { // 반복 실수 car[i] == i xxxxxxxxx i == i
					count++;
				}
				sum1 += car[i][j];
			}

		}
		System.out.println("13-1 : " + count);
		System.out.println("13-2 : " + sum1);

//		if(i!=j){
//			random
//		}

//////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////for문 피라미드 출력///////////////////////////////////

		/*
		 * // for문1 문제 복습 for (int i = 0; i < 5; i++) { System.out.print("+"); }
		 * System.out.println(); // for문2 문제 복습 for (int i = 0; i < 5; i++) {
		 * System.out.print("+"); System.out.print("_"); } System.out.println(); //
		 * for문3 문제 복습 for (int i = 0; i < 3; i++) { for (int j = 0; j < 5; j++) {
		 * System.out.print("+"); } System.out.println(); } // for문4 문제 복습 for (int i =
		 * 0; i < 5; i++) { for (int j = 0; j < 5; j++) { System.out.print(j + 1); }
		 * System.out.println(); } // for문5 문제 복습 for (int i = 1; i <= 5; i++) { for
		 * (int j = 0; j < i; j++) { System.out.print(i); } System.out.println(); } //
		 * for문6 문제 복습 for (int i = 1; i <= 5; i++) { for (int j = 0; j < i; j++) {
		 * System.out.print("+"); } System.out.println(); } // for문7 문제 복습 for (int i =
		 * 0; i < 5; i++) { for (int j = 0; j <= i; j++) { System.out.print(i + 1); }
		 * System.out.println(); }
		 * 
		 * // for문8 문제 복습 for (int i = 0; i < 5; i++) { for (int j = 0; j <= i; j++) {
		 * System.out.print("+"); } for (int k = 3; k >= i; k--) {
		 * System.out.print("_"); } System.out.println(); }
		 * 
		 * // for문9 문제 복습 for (int i = 0; i < 5; i++) { for (int k = 3; k >= i; k--) {
		 * System.out.print("_"); } for (int j = 0; j <= i; j++) {
		 * System.out.print("+"); }
		 * 
		 * System.out.println(); }
		 * 
		 * // for문10 문제 복습 for (int i = 0; i < 5; i++) { for (int k = 3; k >= i; k--) {
		 * System.out.print("_"); } for (int j = 0; j <= i; j++) {
		 * System.out.print("+"); } for (int j = 1; j <= i; j++) {
		 * System.out.print("+"); }
		 * 
		 * System.out.println(); } // for문11 문제 복습 for (int i = 0; i < 5; i++) { for
		 * (int k = 3; k >= i; k--) { System.out.print("_"); } for (int j = 0; j <= i;
		 * j++) { System.out.print("+"); } for (int j = 1; j <= i; j++) {
		 * System.out.print("+"); } for (int k = 3; k >= i; k--) {
		 * System.out.print("_"); }
		 * 
		 * System.out.println(); }
		 * 
		 * ///////////////////// for문피라미드 출력 끝 ///////////////////////////////
		 * //////////// for문 1월 9일 문제 /////////////////
		 * 
		 * // 1월 9일 문제 1: for (int i = 1; i <= 5; i++) { if (i % 2 == 1) {
		 * System.out.println(i + ": 홀"); } else { System.out.println(i + ": 짝"); } }
		 * 
		 * // 1월 9일 문제 2: int sum1 = 0; int sum2 = 0;
		 * 
		 * for (int i = 1; i <= 100; i++) { if (i % 2 == 1) { sum1 += i; } else { sum2
		 * += i; } } System.out.println("홀 : " + sum1); System.out.println("짝 : " +
		 * sum2);
		 * 
		 * // 1월 9일 문제 3: scan 안함
		 * 
		 * // 1월 9일 문제 4:
		 * 
		 * for (int i = 1; i <= 10; i++) { System.out.print(i + " "); if (i % 3 == 0) {
		 * System.out.println(); } }
		 * 
		 * // 1월 9일 2중 for 문제 1:
		 * 
		 * for (int i = 1; i <= 9; i++) { for (int j = 1; j <= 9; j++) {
		 * System.out.printf("%d x %d = %d ", i, j, (i * j)); System.out.println(); } }
		 * // 1월 9일 2중 for 문제 2: for (int i = 1; i <= 9; i++) { for (int j = 1; j <= 9;
		 * j++) { System.out.printf("%d x %d = %d ", i, j, (i * j)); }
		 * System.out.println(); }
		 * System.out.println("뭐야---------------------------------");
		 * 
		 * // 1월 9일 2중 for 문제 3: for (int i = 1; i <= 9; i++) { for (int j = 1; j <= 9;
		 * j++) { for (int k = 1; k <= 3; k++) { System.out.printf("%d x %d = %d ", k,
		 * j, (j * k)); } System.out.println(); } }
		 */
	}
}
