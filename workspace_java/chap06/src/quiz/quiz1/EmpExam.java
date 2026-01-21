package quiz.quiz1;

public class EmpExam {

	public static void main(String[] args) {
		
		Emp [] em = new Emp[3];

//		Emp [] arrList1 = new Emp[3];
//		arrList[0] = new Emp();
//		arrList[1] = new Emp();
		
//		Emp a = new Emp();
//		Emp b = new Emp();
//		Emp [] arrList2 = {a, b};
		
//		Emp [] arrList3 = { new Emp(), new Emp() };
		
		em[0] = new Emp(1, "최민수", 10, 18000, "원장님");
		em[1] = new Emp(2, "정현수", 9, 0, "최민수");
		em[2] = new Emp(3, "홍길동", 8, 11000, "최민수");

		for(int i=0; i<em.length; i++) {
			System.out.println(em[i].sys());
			
//			중요!
			
//			System.out.println(em[i].info());
//			리턴 값이 없어서 오류가 생김
//			info가 void라서 무엇을 프린트 해야 하는지 모르는 상태임

//			for(int i=0; i<arrList.length; i++) {
//				if(arrList[i] != null) {
//					arrList[i].info();
//				}				
//			}
//			같은 코드이지만 남의 코드를 수정할 때 허락 안받아도 됨 ㅎ
//			if(arrList[i] == null) {
//				continue;
//			}
		}
	}

}
