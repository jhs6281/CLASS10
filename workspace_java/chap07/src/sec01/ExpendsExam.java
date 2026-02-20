package sec01;

public class ExpendsExam {

	public static void main(String[] args) {
		// child만 들고왔음. (parent 없이)
		Child child = new Child();
		
		System.out.println("--------------------");
		child.printName();
		
		// 부모필드의 변수를 자식 필드가 자유자재로 사용 가능 
		System.out.println("child.name: " + child.name);
		
		
		
		String n = child.getName();
		System.out.println("child.getName(): " + n);
	}

}
