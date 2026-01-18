package chap05;

public class 다차원배열Exam_03 {

	public static void main(String[] args) {
		int a0 = 5;
		int a1 = 15;
		int a2 = 34;

		int[] b0 = new int[3];
		// b의 첫번째 변수에 a0 넣기
		// b의 두번째 변수에 a1 넣기

		b0[0] = a0;
		b0[1] = a1;
		b0[2] = a2;

		int[] b1 = new int[3];
		b1[0] = a0 + 1;
		b1[1] = a1 + 1;
		b1[2] = a2 + 1;

		int[][] c0 = new int[2][3];
		c0[0] = b0;
		c0[1] = b1;

		System.out.println(c0[0][1] == a1);
		System.out.println("c0.length: " + c0[1][2]);

		// b

		int[][] c1 = new int[][] { { 1, 2, 3 }, new int[] { 4, 5, 6 } };
		int[][] c2 = { { 1, 2, 3 }, { 4, 5, 6, 7 }, null, null, null, null, null };

		int[][] arr = new int[2][];
		System.out.println(c2[5]);
//		가장 바깥 차원은 꼭 있어야 한다
//		heap에 공간은 만들어야 해서
//		모두 null로 초기화
//			참조 공간만 만들고 실제 배열은 나중에 만들기
//		가변(비정형) 배열
//		공간을 연속으로 잡지 않아서 고성능에서는 불리할 수 있다

		int[] d1 = { 1, 2, 3 };
		int[] d2 = d1;

		// 얕은 복사 > 힙 영역의 주소값만 가져온 것( call by reference )
		// = 기호는 stack의 값 (또는 주소)만 복사
		// 값을 변경하는 경우 원본도 바뀐다

		int[] d3 = new int[d1.length];

		d1[0] = 55;

		// 깊은 복사 (call by value)
		int[] d4 = new int[d1.length];
		for (int i = 0; i < d1.length; i++) {
			d3[i] = d1[i];
			System.out.println("깊은 복사 : " + d3[i]);
		}

		System.out.println("-----------------------------------");

		int k1 = 10;
		int k2 = k1;
		k1 = 5;

		// 변수에 값을 대입한 것이기 때문에다시 대입하지 않으면 바뀌지 않는다
		System.out.println("k2 : " + k2);
		// 참조타입은 heap에 있는 주소 값을 가르키기 때문에 값이 바뀐다
		System.out.println("k2 : " + d2[0]);

		// ㄲ짝퀴즈
		// 반복문
		// 1~5, 10~15, 100~105
		// 다른 반복문에서위의 값 출력

		int[][] q1 = new int[3][5];
		
		int[] q1_1 = new int[5];
		int[] q1_2 = new int[5];
		int[] q1_3 = new int[5];

		for (int i = 0; i < q1_1.length; i++) {
			q1_1[i] = i+1;
			//q1-1 출력
			System.out.println(q1_1[i]);
		}
		for (int i = 0; i < q1_2.length; i++) {
			q1_2[i] = i+11;
			//q1-2 출력 +1*10
			System.out.println(q1_2[i]);
		}
		for (int i = 0; i < q1_3.length; i++) {
			q1_3[i] = i+101;
			//q1-3 출력 +1*100
			System.out.println(q1_3[i]);
		}
		
//		q1_4를 모두 출력
		int[][] q1_4 = new int [3][5];
		q1_4[0] = q1_1;
		q1_4[1] = q1_2;
		q1_4[2] = q1_3;
		

		// length 연습
		for(int j = 0; j<q1_4.length; j++) {
			for(int i = 0; i<q1_1.length; i++)
				System.out.println(q1_4[j][i]);
		}
		
		
		
		
		int [][] aa1 = new int [3][5];	
		
		for(int i = 0; i < aa1.length; i++) {
			for(int j = 0; j < aa1[i].length; j++) {
				System.out.println(aa1[i][j]);
			}
		}
		
//		int[] q1_1 = new int[5];
//		int[] q1_2 = new int[5];
//		int[] q1_3 = new int[5];
		
		q1[0] = q1_1;
		q1[1] = q1_2;
		q1[2] = q1_3;
	
		


		
		
		

		
		

		
	}
}
