package chat00;

public class Hello {
	public static void main(String[] args) {
		float value = 50;
		System.out.println(value+2);
		
	System.out.println("글씨"+3+2);
	
	byte result1 = 10 + 20;
	System.out.println(result1);
	
	byte x = 10;
	byte y = 20;
	int result2 = x + y;
	System.out.println(result2);
	
	float f2 = 0.1234567890123456f;
			System.out.println(f2);
//			float의 정밀도 : 소수점 7자리
			
	double d2 = 0.123456789012345678901234567890;
//	double의 정밀도 : 소수점 16자리
	
	double d3 = 5e3;
	System.out.println("d3 : " + d3);
	
	
//	문제1 내 나이를 저장
	int my_Age = 26;
	System.out.println("내 나이 : " + my_Age);
	
//	문제 2 운전 면허가 있다or없다
	boolean UM = true;
	System.out.println("면허가 있는가? : " + UM);
	
//	문제 3 우리 집에 있는 스마트 폰의 개수
	int smartPhone = 4;
	System.out.println("우리집 스마트 폰 개수 : " + smartPhone);
	
//	문제 4 내 이름 저장
	String name = "정현수";
	System.out.println("name : " + name);
	
//	문제 5
	double miter = 3.3;
	System.out.println("제곱 : " + (5*miter));
	
	
//	문제 6-1
	int xx = 3;
	int yy = 4;
	
	System.out.println("출력 결과 : " + (xx) + " > " + (yy) + " 결과는 " + (xx > yy) + " 입니다.");
	
//	문제 6-2
	System.out.println("출력 결과 : " + (yy) + " > " + (xx) + " 결과는 " + (yy > xx) + " 입니다.");
	
/*	문제 7 
 * 백의 자리, 십의 자리, 일의 자리
 */
	
	
	int num = 451;
	System.out.println("백의 자리 : " + (num/100));
	
	System.out.println("십의 자리 : " + (((num-(num/100)*100))/*100의 자리*//10)/*10의 자리*/);
	
	System.out.println("일의 자리 : " + (((num-((num/100)*100))-
										(((num-(num/100)*100))/10)*10)));
	
	/* 강사님 방법 */
	int number = 149;
	int n100 = number / 100;
	System.out.println(n100);

	
/*	문제 8
 * 
	회식비 43000 원
	참석 인원 4명
	8-1 : 디테일하게 원 단위까지
	8-2 : 만원 단위 까지만 받기
	8-2-1 : 주최자는 얼마 내야 하는가
	
	int money3 = 회식비- ((((회식비 / 참석인원) / 10000)*10000) * (참석인원 -1));
	
*/
	
	int money = 93000;
	int 인원 = 4;
	System.out.println("8-1 : "+money/인원);
	System.out.println("8-2 : "+((money/인원)/10000)*10000);
	System.out.println("8-2-1 : "+(money-((((money/인원)/10000)*10000)*3)));
	
	
	
	
//	문제 9
	String left = "오예스";
	String right = "사탕";
	
/*	
 	String left = right; << 틀림
	String은 한번 선언 하면 다시 선언 하지 않아도 된다.
*/
	String i = left;
	left = right;
	right = i;
	
//	뭔가하기
	
	System.out.println("left: " + left); // 사탕
	System.out.println("right: " + right); // 오예스
	}
	
}
