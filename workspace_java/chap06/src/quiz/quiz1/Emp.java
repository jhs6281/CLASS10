package quiz.quiz1;

public class Emp {
	
	//테이블 정보 선언
	int empNum;
	String name;
	int rank;
	int salary;
	String boss;
	
	
	//생성자
	Emp(int empNum, String name, int rank, int salary, String boss){
		this.empNum = empNum;
		this.name = name;
		this.rank = rank;
		this.salary = salary;
		this.boss = boss;		
	}
	

	//모든 정보 출력
    public String sys() {
        return empNum + " " + name + " " + rank + " " + salary + " " + boss;
    }
	
	
	

	
}
