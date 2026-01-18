package sec02;

public class ChinaExam {

	public static void main(String[] args) {
        Car myCar = new Car();

        China1 Ch1 = new China1();
        China1 Ch2 = new China1();
        Ch2.menus[0] = "오징어 볶음";

        System.out.println(Ch1.menus[0]);
        System.out.println(Ch1.menus[1]);
        
        System.out.println(Ch2.menus[0]);
        System.out.println(Ch2.menus[1]);
		
        System.out.println(myCar.speed);
	}

}
