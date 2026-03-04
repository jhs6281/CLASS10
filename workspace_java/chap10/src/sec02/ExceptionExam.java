package sec02;

public class ExceptionExam {

	public static void main(String[] args) {
		
		// 트라이 캐치 
		try {
			System.out.println(1);
			int a = Integer.parseInt("a");
			System.out.println(1.5);
			System.out.println(args[100]);
			System.out.println(2);
//		} catch(Exception e){
//			System.out.println(3);
//			e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println(31);
			e.printStackTrace();
		} catch(NumberFormatException e){
			System.out.println(32);
			e.printStackTrace();
			System.out.println( e ); 
			System.out.println( e.getMessage() ); 
		} catch(Exception e){
			System.out.println(3);
			e.printStackTrace();
		} finally {
			System.out.println("무조건 실행 ");
		}
		System.out.println(4);
//		System.out.println(args.length);
	}
	
	void test() {
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
