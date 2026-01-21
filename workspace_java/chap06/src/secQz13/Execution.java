package secQz13;

public class Execution {

	public static void main(String[] args) {
		
		//공정
		Process pc = new Process();
		
		//아이템 넣기
		Item item1 = new Item("제품1");
		Item item2 = new Item("제품2");
		
		//아이템 1+2 되어야 함.
		pc.run();
	}

}
