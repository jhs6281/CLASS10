package chap06;

public class EmpQ6Table {
	
	// 1. ArrayList
//	ArrayList list = new ArrayList();
	
	// 2. 배열
	
	// 추가 메소드
	// Emp를 전달 받아서 저장한다
//	void join(EmpQ6 emp) {
//		this.list.add(emp);
//	}

	EmpQ6[] eq = new EmpQ6[6];

//	EmpQ6 em1 = new EmpQ6(1, "최민수", 10, 5500, 1100);

	void qq() {
		this.eq[0] = new EmpQ6(1, "최민수", 10, 5500, 1100);
		this.eq[1] = new EmpQ6(2, "정현수", 9, 5500, 1200);
		this.eq[2] = new EmpQ6(3, "배철수", 8, 5500, 1300);
		this.eq[3] = new EmpQ6(4, "오달수", 7, 5500, 1400);
		this.eq[4] = new EmpQ6(5, "월화수", 6, 5500, 1500);
		this.eq[5] = new EmpQ6(6, "박 수", 5, 5500, 1600);
	}

//	EmpQ6[] qq() {
//		this.eq[0] = new EmpQ6(1, "최민수", 10, 5500, 1100);
//		this.eq[1] = new EmpQ6(2, "정현수", 9, 5500, 1200);
//		this.eq[2] = new EmpQ6(3, "배철수", 8, 5500, 1300);
//		this.eq[3] = new EmpQ6(4, "오달수", 7, 5500, 1400);
//		this.eq[4] = new EmpQ6(5, "월화수", 6, 5500, 1500);
//		this.eq[5] = new EmpQ6(6, "박 수", 5, 5500, 1600);
//		return eq{0,1,2,3,4,5};
//	}

	// 모든 정보 출력
//	void sys() {
//		for(int i=0; i< this.eq.length; i++) {
//			System.out.println(eq[i]);
//		}
//	}
//	void sys() {
//		for(int i=0; i< this.eq.length; i++) {
//			System.out.println(eq[i]);
//		}
//	}

	void sys() {
		for (int i = 0; i < this.eq.length; i++) {
			System.out.print(this.eq[i].empNum + " ");
			System.out.print(this.eq[i].name + " ");
			System.out.print(this.eq[i].rank + " ");
			System.out.print(this.eq[i].salary + " ");
			System.out.println(this.eq[i].boss + " ");
		}
		System.out.println("-----------------------");
	}
}
