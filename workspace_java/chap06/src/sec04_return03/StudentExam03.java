package sec04_return03;

public class StudentExam03 {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		
		s1.name = "정현수";
		s1.age = 27;
		
		//setter
		s1.setName("최민수");
		//getter
		String name = s1.getName();
;
		System.out.println("이름: " + name);

		
	}

}
