package chap12;

public class BeepExam {

	public static void main(String[] args) {

		// Runnable 인터페이스 타입 변수 생성
		// Task 클래스는 Runnable을 구현한 클래스라고 가정
		Runnable task = new Task();

		// Thread 객체 생성
		// 생성자에 Runnable 객체를 넣으면
		// Thread가 실행될 때 task.run()이 실행된다.
		Thread t1 = new Thread(task);

		// 스레드 시작
		// start()를 호출하면 새로운 스레드가 생성되고
		// 내부적으로 run() 메소드가 실행된다.
		t1.start();

		System.out.println("main");

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		// 익명객체로 쓰레드 /만드는 방법
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Task2 : " + i);
					try {
						// 강력해서 잘 사용 해야 함
						Thread.sleep(500); // 500ms 단위
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // ms 단위
				}
			}

		});
		t2.start();
	}

}
