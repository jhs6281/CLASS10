package chap05;

public class EnumExam_06 {
	Week week;
    	Week week2;

    	week = Week.금;
    	System.out.println(week);

    //사용용도 예시 (비교)
    // 검사용도, 판별용도 등으로 쓴다.
    if(week == Week.월) {
        System.out.println("월요일");
    }else if(week == Week.금) {
        System.out.println("금요일");
    }
}
