package chap05;

public class 향상된for문Exam_03 {

	public static void main(String[] args) {
		int [] scores = { 1, 2, 3, 4, 5 };
		
		int s1 = scores[0];
		// 반복할 수 있는 것
		// 하나씩 꺼내서 담을 변수 : 반복할 수 있는 것
		for(int s : scores) {
			System.out.print(s + " ");
		}
		
		for(int i = 0; i<scores.length; i++) {
			int s = scores[i];
			System.out.println(s);
		}
		
	}

}
