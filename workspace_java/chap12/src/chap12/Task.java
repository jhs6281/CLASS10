package chap12;

public class Task implements Runnable {

	@Override
	public void run() {
		// 실행할 내용 전부 run()안에 작성
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Task1 : " + i);
			 try {
				 // 강력해서 잘 사용 해야 함
				Thread.sleep(500); // 500ms 단위
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // ms 단위
		}
	}

}
