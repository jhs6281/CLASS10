package sec04.overloading;

public class CalcExam {

	public static void main(String[] args) {
		Calc calc = new Calc();
		
		calc.plus(1, 1);
		calc.plus(1, 1.8);
		
//		형태가 자동으로 바뀔 때
		System.out.println("문자");
		System.out.println(1);
		
		calc.plus(50);
		
		calc.fitness("덤벨", 20, 5);
	}

}
