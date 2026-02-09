package sec05_final;

public class Person {
	final String nation = "Korea";
	final String ssn; // 주민번호

	{
		int[] a = new int[3];
//	a.length = 30; 길이 3을 30으로 바꾸려고 해봤지만 바뀌지 않는다.
		// final과 비슷하다
	}

	
	// 선언할 때 값이 없으면
	//	딱 한 번 할당할 수 있다. (생성자마냥)
	Person(String ssn){
//		this.nation = "0"; 안됨! final이라서 안바뀜
//		사용예) 주민등록번호 등
		
		this.ssn = ssn;
	}
	

	
	
	
}
