package chap04;

import java.util.Scanner;

public class Qhrtmq {

	public static void main(String[] args) {
//		1
		int myAge = 26;
		System.out.println("문제 1 : " + myAge);
//		2
		boolean Un = true;
		System.out.println("문제 2 : " + Un);
//		3
		int phone = 4;
		System.out.println("문제 3 : " + phone);
//		4
		String MyName = "정현수";
		System.out.println("문제 4 : " + MyName);
//		5
		double Miter = 3.3;
		System.out.println("문제 5 : " + (5 * Miter));
//		6
		int x = 5;
		int y = 3;
		System.out.println("문제 6 : " + (x + " > " + y + " 결과는 " + (x > y) + " 입니다. "));
//		7
		int num = 527;
		int n100 = num / 100;
		int n10 = (num - (n100 * 100)) / 10;
		int n1 = (num - (n100 * 100)) - (n10 * 10);
		System.out.println("문제 7-1 : " + n100);
		System.out.println("문제 7-2 : " + n10);
		System.out.println("문제 7-3 : " + n1);
//		8
		int 회식비 = 99999;
		int 참여인원 = 4;
		int N빵 = 회식비 / 참여인원;
		int 만원단위 = (N빵 / 10000) * 10000;
		int 주최자 = 회식비 - (만원단위 * (참여인원 - 1));
		System.out.println("문제 8-1 : " + 회식비 / 참여인원);
		System.out.println("문제 8-2 : " + 만원단위);
		System.out.println("문제 8-2-1 : " + (회식비 - (만원단위 * (참여인원 - 1))));
//		9
		String left = "오예스";
		String right = "사탕";
		String i = left;
		left = right;
		right = i;
		System.out.println("문제 9-1 : " + left);
		System.out.println("문제 9-2 : " + right);

//		복습 끝 / 예습 시작
//		삼항 연산자 1. 조건식 계산 -> 2. 참 = 왼쪽값 / 거짓 = 오른쪽값 출력
		int score = 92;
		char grade = (score > 90) ? 'A' : 'B';
		System.out.println(grade);

//		if문 기본
		int score2 = 93;

		if (score >= 90) {
			System.out.println("점수가 90보다 큽니다. \n등급은 A입니다. ");
		}
		if (score < 90) {
			System.out.println("점수가 90보다 작습니다. \n등급은 B입니다. ");
		}

		char v1 = 'A';
		if (v1 == 'A') {
			int v2 = 100;
			double v3 = 3.14;
		}
		boolean v4 = true;
		System.out.println();

		int dice = (int) (Math.random() * 6) + 1;

		if (dice == 1) {
			System.out.println("주사위 값 : 1");
		}
		if (dice == 2) {
			System.out.println("주사위 값 : 2");
		}
		if (dice == 3) {
			System.out.println("주사위 값 : 3");
		}
		if (dice == 4) {
			System.out.println("주사위 값 : 4");
		}
		if (dice == 5) {
			System.out.println("주사위 값 : 5");
		}
		if (dice == 6) {
			System.out.println("주사위 값 : 6");
		}

		/////////////////////////////////////////////////
		/////////// 2일차 ///////////////////////////////
		/////////////////////////////////////////////////

//		LEVEL1-1
		for (int p = 1; p <= 10; p++) {
//			System.out.printf(p); 에러: 
			System.out.println(p);
		}

//		LEVEL1-2
		int sum = 0;
		for (int p = 1; p <= 100; p++) {
//			int sum += p;	에러:지역 내에서 변수 선언해서 에러 뜸
			sum += p;
		}
		System.out.println(sum);

//		LEVEL1-3
		for(int p = 5; p>0; p--) {
			System.out.print(p+" ");
		}
		System.out.println();
		
		
//		LEVEL 1-4
		for (int gu = 1; gu <= 9; gu++) {
			for (int basu = 1; basu <= 9; basu++) {
				System.out.printf("%d단: %d x %d = %d\n", gu, gu, basu, (gu * basu));
			}
		}
//		LEVEL 1-5
		for(int p = 1; p<= 50; p++) {
			if(p%7 == 0){
				System.out.print(p+ " ");
			}
		}
		System.out.println();
		
//		LEVEL 2-1
		for(int p = 0; p<5; p++) {
			System.out.print("*");
		}
		System.out.println();
		
//		LEVEL 2-2
		for(int p=0; p<5; p++) {
			for(int aa=0; aa<5; aa++) {
			System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("2-3");
//		LEVEL 2-3
		for(int p=0; p<5; p++) {
			for(int aa=0; aa<p; aa++) {
				System.out.print("*");
			}
			System.out.println("*");
		}
		System.out.println("2-4");
//		LEVEL 2-4
		for(int p=5; p>0; p--) {
			for(int aa=1; aa<=p; aa++) {
				System.out.print("*");
			}
			System.out.println("");
		}
//		LEVEL 2-5
		int summ=0;
		for(int p=0; p<=20; p++) {
			if(p%2==0){
				summ+=p;
			}
		}
			System.out.println(summ);
			
			
		
//		LEVEL3-2
		int N = 4;

		for (int n = 1; n <= N; n++) {
			for (int go = 1; go <= N; go++) {
				System.out.print(go);
			}
			System.out.println();
		}
//		LEVEL3-3
		for(int a=1; a<=5; a++) {
			for(int aa=1; aa<=a; aa++) {
				System.out.print(aa);
			}
			System.out.println();
		}
//		LEVEL3-4
		for(int a=0; a<=5; a++)
		{
			for(int b=0; b<=a; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
		Scanner scanner = new Scanner(System.in);
		/*
		
		System.out.println("시간과 분을 입력해주세요 "
				+ "\n 시간: 0~23"
				+ "\n 분: 0~59");
		int inputH = scanner.nextInt();
		int inputM = scanner.nextInt();
		
		int hour = inputH;
		int minute = inputM+35;
		
		if(hour>24) {
			System.out.println("시간이 정확하지 않습니다.");
		}
		else if(minute>60 && minute < 95) {
			if((hour+1)>23) {
				System.out.println("35분 뒤 0시 "+(minute-60)+"분 입니다");
			}
			else {
				System.out.println("35분 뒤"+(hour+1)+"시 "+(minute-60)+"분 입니다");
			}
		}
		else if(minute >= 0) {
			System.out.println("35분 뒤"+(hour)+"시 "+(minute)+"분 입니다");
		}
		else {
			System.out.println("올바르게 입력하지 않았습니다.");
		}
		*/
//		문제: 11
		/*
		System.out.println("두자리 수의 숫자를 입력해주세요 ");
		int same = scanner.nextInt();
		
		int sf = same/10;
		int sb = same - (same/10*10);
		
		if(sf>9) {
			System.out.println("문제 11: 정확한 값을 입력하세요");
		}
		else if(sf==sb) {
			System.out.println("문제 11: 같음");
		}
		else if(sf!=sb) {
			System.out.println("문제 11: 다름");
		}
		else {
			System.out.println("what");
		}
		*/
		
//		문제 12
//		십의자리: scan12/10 일의자리: scan12 - (scan12/10*10) / if 십의자리 %3 == 0 
//		|| 일의자리 %3 == 0 {"짝"} else if (scan12 >= 0 && scan <= 99) {syso scan12}
		
//		문제 13
//		int x1 = scanner.nextInt();
//		int y1 = scanner.nextInt();
//		int x2 = scanner.nextInt();
//		int y2 = scanner.nextInt();
//		
//		if((x1<=30) && (x1>=130) 
//		&& (y1>=10) && (y1<=80)
//		&&(x2<=130) && (x2 >=30)
//		&& (y2>=10) && (y2<=80)) {
//		System.out.println("겹쳐요");
//	}
//	else {
//		System.out.println("범위를 벗어났습니다.");
//	}
//	
		System.out.println("가위, 바위, 보를 시작합니다."
				+ "\n 가위 "
				+ "\n 바위 "
				+ "\n 보 "
				+ "\n 숫자 (가위,바위,보) 중 하나를 입력하시오.");
		int Igyeo = scanner.nextInt();
		
		int comGBB = (int)(Math.random()*3);
		
		if(Igyeo==comGBB) {
			System.out.println("문제 5 : 비겼다.");
		}
		else if(Igyeo==0) {
			if(comGBB==1) {
				System.out.println("문제 5 : 졌다");
			}
			else if(comGBB==2) {
				System.out.println("문제 5 : 이겼다");
			}
		}
		else if(Igyeo==1) {
			if(comGBB==0) {
				System.out.println("문제 5 : 이겼다");
			}
			else if(comGBB==2) {
				System.out.println("문제 5 : 졌다");
			}
		}
		else if(Igyeo==2) {
			if(comGBB==0) {
				System.out.println("문제 5 : 졌다");
			}
			else if(comGBB==1) {
				System.out.println("문제 5 : 이겼다");
			}
		}
		else {
			System.out.println("문제 5 : 0, 1, 2 숫자를 제대로 입력하지 않았습니다.");
		}
	
	}

}
