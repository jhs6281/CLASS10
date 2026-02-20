package sec01.override;

public class Calc {
		
	public double areaCircle(double r) {
			System.out.println("Calculator 의 area Circle 실행");
			return 3.14159 * r * r;
	}
	
	public int plus (int x, int y) {
		System.out.println("Calc의 plus 실행");
		return x + y ;
	}
}
