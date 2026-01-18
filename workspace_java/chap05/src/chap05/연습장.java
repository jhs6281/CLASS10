package chap05;

public class 연습장 {

	public static void main(String[] args) {

		int[] pw = new int[8];

//		if (j >= 0 && j <= 9 || (j >= 65 && j <= 90) || (j >= 97 && j <= 122)) {}
//			pw[0]=num;
		// 랜덤값 < 10 랜덤 1회 출력 / 97 < 랜덤값 < 112 랜덤 2회 출력 / 65 < 대문자만큼

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;

		boolean flag = false;
//		 값의 범위 지정

		for (int j = 0; j < 8; j++) {
			int gbb = (int) (Math.random() * 3);

			// 가위,바위,보 시작
			if (gbb == 0) {
				int num = (int) (Math.random() * 10); // 숫자
				pw[j] = num;
				count1++;
			} else if (gbb == 1) {
				int aaa = (int) ((Math.random() * 26) + 97); // 소문자
				pw[j] = aaa;
				count2++;
			} else if (gbb == 2) {
				int AAA = (int) ((Math.random() * 26) + 65); // 대문자
				pw[j] = AAA;
				count3++;
			}

			// 고스톱 정하기
			if (count1 >= 2 && count2 >= 1 && count3 >= 1) {
				flag = true;
			} else if (!(count1 >= 2 && count2 >= 1 && count3 >= 1)) {
				j--;
			}
		}

		// 고 하면 출력
		for (int j = 0; j < 8; j++) {

			if (pw[j] > 10) {
				System.out.print((char) pw[j]);
			} else {
				System.out.print(pw[j]);
			}
		}

	}
}