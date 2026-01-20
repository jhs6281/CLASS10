package sec04.method02;

public class CalcExam {

	public static void main(String[] args) {
		Calc calc = new Calc();
		calc.powerOn();
		calc.plus(1,2);
		
		int a = calc.plus(5,7);
		System.out.println("a: " + a);
		
		//호출: 이름, 전달인자는 꼭 맞출 것
		//calc.plus();
		
		int i = 4;
		a = calc.plus(i,8);
		
		/**
		 * javadoc 주석
		 * 두 정수를 입력 받아서
		 * 
		 * 메소드 명: divide
		 * 전달 인자: int x, int y
		 * 리턴 타입: double
		 * 
		 * @param int x, int y
		 * @return double
		 * @author todair@naver.com
		 */
		
//		calc.divide(3,2); 출력 해야됨ㅎ
		
		double b = calc.divide(3, 1);
		System.out.println(b);

	}

}
