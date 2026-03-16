package chap11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeExam {

	public static void main(String[] args) {
		
		// timestamp, UNIX time 시간
		// currentTimeMillis = 1970년 01월 01일로부터 몇 초 흘렀는지 ?
		long before = System.currentTimeMillis(); 
		System.out.println(before);
		
		for(int i=0; i<100000000; i++) {
			// 측정될 내용
		}
		
		long after = System.currentTimeMillis(); 
		
		
		System.out.println("걸린 시간 : " + (after - before)); // 시간 측정
		
		// util Date 임포트
		// 시계 출력 (많이 쓰이는 방식)
		Date date = new Date() ; // 시계 생성
		System.out.println(date);
		
		String format = "yyyy년 MM월 dd일 HH:mm:ss.SSS"; // 양식 지정
		SimpleDateFormat sdf = new SimpleDateFormat(format); // SimpleDateFormat("양식")
		String strDate = sdf.format(date); // 힙 영역의 값 get
		System.out.println(strDate); 
		
	}

}
