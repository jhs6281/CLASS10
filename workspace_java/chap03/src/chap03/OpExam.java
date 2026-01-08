package chap03;

public class OpExam {

	public static void main(String[] args) {
		int x = 10;
		
		x++;
		System.out.println("x: "+x);
		
		x = 10;
		
		x = x + 1;
		x = 1 + x; //위와 같은 코드다른 항을 사용 가능 y등
		x += 1; //위와 같은 코드 다른 숫자 사용 가능 2등
		x++; //위와 같은 코드 1개씩 증가
		
		x = 10;
		
		++x;
		x--;
		--x;
		System.out.println("++x : " + x);
		
		x = 10;
		int z = ++x;
		System.out.println("++z " + z);
		System.out.println("++x " + x);
		
		x = 10;
		z = x++;
		System.out.println("z++ " + z);
		System.out.println("x++ " + x);
		
		x = 10;
		System.out.println(("x++"+ x++) + (" x:"+ x)); 
//		항이 넘어갈 때 계산한다
		
		x = 10;
		// 10 + 1 + 11 
		z = x++ + ++x;
		// 예측: 21
		System.out.println("z: "+ z); //결과 22
		
		x = 15;
		System.out.println("x: "+ x); 
		//우선순위 : 단항 연산 > 사칙 연산    
		z = x++ - --x * x++ - x--;
		System.out.println("z: "+ z); 

//		나누기 할 때 0으로 나누지 않기 *(에러: 무한 루프)
//		int b = 10;
//		int c = b / 0 ;
		double d = 7.3;
		double e = d / 0;
		System.out.println("d/0 : " + e); // 무한
		
		// 나머지
		int f = 10 % 3;
		// 특징 : 0 ~ (나머지 값 - 1) 범위의 숫자가 나온다.
		
		int nameoji = 149;
		int n100 = nameoji/100;
		System.out.println("백의 자리 : "+ nameoji/100);
		System.out.println("십의 자리 : "+ nameoji%100/10);
		System.out.println("일의 자리 : "+ nameoji%10);

//		놀라운 사실
		System.out.println(0.1);
		System.out.println(0.1f);
		System.out.println(0.1 == 0.1f);
		
//		소수점은 근사치로 저장된다
//		그나마 같은 타입으로 비교하면 수월하다
		
		String s1 = "s1";
		String s2 = "s1";
		System.out.println("글씨는 무조건 equal: " + s1.equals(s2));
	
		int c1 = 22;
		int c2 = 4;
		System.out.println("몫: " + c1/c2);
		System.out.println("나머지: " + c1%c2);
		
//		문제1-1 : 쌍화차 최대 몇 잔?
//		문제1-2 : 거스름돈 ?
//		문제2 : 꿀홍차 8000 -15% =?
		
		int money = 10000;		
		int SHC = 4500;
		int honey = 8000;
		double sale = honey *0.15;
		
		System.out.println("문제 1: " + money/SHC);
		System.out.println("문제 2: " + money%SHC);
		System.out.println("문제 3: " + (honey-sale));
		
//		문제3
		double v1 = 1000;
		double v2 = 794.0;
		int value =  (int) (v1/v2*1000);
		
		double result = (double)value/1000;
		
		System.out.println("문제 3: " + value);
		System.out.println("문제 3: " + result);
		
//		문제4
//		17000 원 5000원 몇장 1000원 몇장 
		int allmoney = 48000;
		int m5000 = 5000;
		int	m1000 = 1000;
		int smoney = allmoney%m5000;
		
		System.out.println("5000원: " + allmoney/m5000 + "장");
		System.out.println("1000원: " + smoney/m1000 + "장");

//		비트 연산자
//		int charCode = 'A';
//		
//		if((charCode>=65)&(charCode<=90)) {
//			System.out.println("대문자");
//		}
//		}
		
		int s = 95;
		String grade = (s>90) ? "A" : "B" ;
		System.out.println(grade);
		
	}

}
