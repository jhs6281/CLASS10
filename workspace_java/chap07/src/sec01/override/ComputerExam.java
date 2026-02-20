package sec01.override;

public class ComputerExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = 10;
		
		Calc calc = new Calc();
		
		System.out.println("원 면적: " + calc.areaCircle(r));
		System.out.println();
		
		Computer computer = new Computer();
		
		System.out.println("원 면적: " + computer.areaCircle(r));
		
		System.out.println(computer.plus(1, 5)); 
	}

}
