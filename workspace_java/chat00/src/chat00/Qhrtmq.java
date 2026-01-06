package chat00;

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
		System.out.println("문제 5 : " + (5*Miter));
//		6
		int x = 5;
		int y = 3;
		System.out.println("문제 6 : " + (x + " > " + y + " 결과는 " + (x>y)+" 입니다. "));
//		7
		int num = 527;
		int n100 = num/100;
		int n10 = (num-(n100*100))/10;
		int n1 = (num-(n100*100))-(n10*10);
		System.out.println("문제 7-1 : " + n100);
		System.out.println("문제 7-2 : " + n10);
		System.out.println("문제 7-3 : " + n1);
//		8
		int 회식비 = 99999;
		int 참여인원 = 4;
		int N빵 = 회식비 / 참여인원;
		int 만원단위 = (N빵/10000)*10000;
		int 주최자 = 회식비 - (만원단위*(참여인원-1));
		System.out.println("문제 8-1 : " + 회식비/참여인원);
		System.out.println("문제 8-2 : " + 만원단위);
		System.out.println("문제 8-2-1 : " + (회식비 - (만원단위*(참여인원-1))));
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
		
		if(score>=90) {
			System.out.println("점수가 90보다 큽니다. \n등급은 A입니다. ");
		}
		if(score<90) {
			System.out.println("점수가 90보다 작습니다. \n등급은 B입니다. ");
		}
		
		char v1 = 'A';
		if (v1 == 'A') {
			int v2 = 100;
			double v3 = 3.14;
		}
		boolean v4 = true;
		System.out.println();
		
		
	}
	

	
}
