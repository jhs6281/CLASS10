package chap08;

public class RemoconExam {

	public static void main(String[] args) {

		Tv tv = new Tv();
		tv.setVolume(155);
		
		RemoteControl rc1 = (RemoteControl) tv;
		RemoteControl rc2 = tv;
		RemoteControl rc3 = new Tv();
		// 세 종류 전부 가능
		
		powerOn(tv);
		
//		OTT ot = new OTT(); // 인터페이스는 클래스와 다르다.
	}

	static void powerOn(RemoteControl rc) {
		rc.turnOn();
	}
}
