package chap11;

public class MemberExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1 = new Member("이름", 3);
		Member m2 = new Member("이름", 3);
		int i1 = 1;
		int i2 = 1;
		
		// 힙 영역 비교
		System.out.println( m1 == m2 );
		// 힙 영역의 값 비교
		System.out.println( m1.equals(m2) );
//		System.out.println(i1.equals(i2)); equals 오버라이딩되어서 안먹음
		
		System.out.println(m1.toString().toString().toString());
	}
}