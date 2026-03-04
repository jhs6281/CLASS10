package chap08;

public interface RemoteControl {
	
	// 상수(static final) 대문자 표기
	public static final int MAX_VOLUME = 10;
	// 모든 필드는 public static final(상수)
	// -> 생략 가능.
	int MIN_VOLUME = 0;
	
	
	public abstract void turnOn();
	// 모든 메소드는 public abstract(추상) 메소드 입니다
	// 그래서 생략 가능
	
	void turnOff();
	void setVolume(int vol);
	
	default void mic (String text) {
		System.out.println();
	}
}
