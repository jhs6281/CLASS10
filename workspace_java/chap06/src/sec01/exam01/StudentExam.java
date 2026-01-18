package sec01.exam01;

public class StudentExam {
	public static void main(String[] args) {
		Student s1 = new Student();
		
		Student s2;
		s2 = new Student();
		
		System.out.println(s1 == s2); // false / new로 선언 했으니
		
		Student s3 = null;
		s3=s1;
		
		System.out.println(s3==s1); // true / 주소 공유했기 때문
		
		s1 = null; // null은 힙 영역을 지운 것. s3은 여전히 s1이 갖고있던 주소를 가짐
		// s3는 null이 아님
		
		s1 = s2;
		// s1은 s2의 주소 값을 가짐. s3는 여전히 예전 s1의 주소(인스턴스) 
		// s1 != s3
		
		Teacher tc = new Teacher();
	}
}
