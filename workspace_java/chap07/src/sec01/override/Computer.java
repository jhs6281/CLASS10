package sec01.override;

public class Computer extends Calc{
	
	@Override // 오버라이드 검사하는 어노테이션
	// visiblelity  에러 
	public double areaCircle(double r) { 
		System.out.println("Computer 의 area Circle 실행");
		return Math.PI * r * r;
	}
	
	@Override
	public int plus (int x, int y) {
		System.out.println("Computer의 plus 실행");
		
		int result  = super.plus(x, y);
		return result ;
		
	}
	
}
