package chap02;

public class TypeCastingExam {

	public static void main(String[] args) {
		int intValue = 10;
		byte byteValue = (byte)intValue;
		System.out.println(byteValue);
		
//		여기서의 ()는 우선 순위 연산자
		int a = 2 * (3 + 4);
		
//		여기서의 ()는 형 변환 연산자
		byte byteValue2 = (byte)intValue;
		
		intValue = 200;
		byteValue = (byte)intValue;
//		정확히는 비트를 2의 보수로 계산한 결과가 나온다
//		즉 예상하기 힘들다
		System.out.println(byteValue);
		
		double d1 = 3.14;
		float f1 = (float)d1;
		System.out.println(f1);
		
//L안붙여서 에러 뜸		long l1 = (long)2200000000;
		double d2 = -3.14;
		int i1 = (int)d2;
		System.out.println("i1: " + i1);
		
//	작은 것에서 큰 것으로 변환 할 때는 형 변환 생략 가능
		int i2 = 100;
		long l2 = (long)i2;
		long l3 = i2;
		long l4 = 100;
		System.out.println(l3-l4);
		
		int i3 = 2100000000;
		int i4 = 2100000000;
//		인트+인트 값이라 덧셈이 가능하다. 하지만 결과는 인트가 아니라서 
//		-9345645어쩌구가 뜬다.
		int i5 = i3 + i4;
//	오류가 없기 때문에 사용자에게 온전한 책임이 있다
		System.out.println("i5 : "+ i5);
		
//		int test = 4200000000L;
//		System.out.println("test : " + test);
		
		int i6 = 10;
		long l6 = 4L;
		
//		int i7 = i6 + l6; int와 long을 더했더니 int정수가 자동으로 long 타입이 되어 더해짐 
//		int에 long을 넣을 수 없기 때문에 오류가 뜬다.
		
		int i7 = 10;
		double d7 = 5.5;
		double d8 = i7 + d7;
		long l7 = i6 + l6;
		
		System.out.println("d8:[15.5?] " + d8);
		
		double d9 = 10 / 4;
//		int i9 = 10 / 4;
//		d9 = i9;
		
//		double = int / int -> 결과값 : int로 출력
		System.out.println("d9: " + d9);
		
//		.0(소수점)을 써서 형 변환으로 더블이 됐다
		double d10 = 10.0 / 4;
		System.out.println("d10 : " + d10);
		
//		double d11 = (double)10 / (double)4;
		double d11 = (double)10 / 4;
		System.out.println("d11: " + d11);
		
	}
	

}
