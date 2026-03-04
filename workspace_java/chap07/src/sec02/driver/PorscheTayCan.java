package sec02.driver;

public class PorscheTayCan extends Car{
	
	@Override
	void start(){
		System.out.println("타이칸 시동 on");
	}
	void run(){
		System.out.println("타이칸 주행중...");
	}
}
