package chap11;

public class StringExam {

	public static void main(String[] args) {

		System.gc();

		String s1 = "영일이삼사오육칠팔구삼사";

		// charAt(인덱스 번호) = 해당 인덱스 번호의 값
		char c = s1.charAt(1);
		System.out.println(c);
		// 홀따옴표 ' ' = char 타입끼리 대입 / 수정 / 비교 가능  
		c = 'c';

		// indexOf("찾을 내용") = 찾은 내용 있는 배열 반환
		int i1 = s1.indexOf("삼사");
		System.out.println("i1 : " + i1);

		// 일치하지 않는 값  없으면 -1 // 헷갈림 주의 : python은 맨 마지막 인덱스가 -1
		int i2 = s1.indexOf("삼오");
		System.out.println("i2 : " + i2); 

		// .lastindexOf("뒤에서부터 찾을 내용")
		int i3 = s1.lastIndexOf("삼사");
		System.out.println(i3);

		String email = "todair@naver.com";
		// 이메일 양식 점검
		// @ 1개, . 1개 이상 있는가?
		

		// 유무 확인을 -1 과 비교하여 하는 모습
		if (email.indexOf("@") != -1 && email.indexOf(".") != -1) {
			System.out.println("이메일");
		} else {
			System.out.println("이메일 아님");
		}

		// indexOf를 charAt으로 구현하기
		int index = -1;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') { // char타입 비교는 '' 홀따옴표 사용
				index = i;
				break;
			}
		}

		// replace("바꾸고 싶은 내용", "대체할 내용")
		String s2 = s1.replace("삼사", "34");
		System.out.println("S1: " + s1); // replace 함수 = 원본은 바꾸지 않는다.
		System.out.println("S2: " + s2); // break 없이, 전부 바뀐다.

		// substring(n부터, n'앞'까지)
		String s3 = s1.substring(5, 8); 
		System.out.println("s3: " + s3);

		// 문제 1
		// email에서 id만 출력
		// 문제 2
		// 123456 - 1234567
		// 성별 출력하기

		// 문제 1 email에서 id만 출력
		if (email.indexOf("@") != -1 && email.indexOf(".") != -1) {
			System.out.println("id : " + email.substring(0, email.indexOf("@")));
		}

		// 문제 2 123456 - 1234567 
		String num = "123456-1234567";
		int minus = num.indexOf("-");
		
		// - 다음 값 비교할 내용
		String check = num.substring(minus+1, minus+2);
		int Check = Integer.parseInt(check); // 숫자로 변환
		
		if (Check%2 == 1) {
			System.out.println("남자");
		}
		else if (Check%2 == 0) {
			System.out.println("여자");
		}

		String s4 = "   글 to the 씨  ";
		System.out.println("["+s4.trim()+"]");
		
		String menu = "선생님 : 짜장, 유빈 : 짬뽕, 민호 : 볶음밥";
		
		// regex
		String[] menus = menu.split(", ");
		for(String m : menus) {
			System.out.println(m);
		}
		
		String url = "blog.naver.com";
		// split의 전달인자는 정규 표현식을 사용
		// 단순한 String이 아님에 주의
		// .은 정규 표현식에 예약어
//		String[] urls = url.split(".");
		
		// 해결 방법 : 1
		// String[] urls = url.split("\\."); 
		// 해결 방법 : 2
		 String[] urls = url.split("[.]"); 
		for(String m : urls) {
			System.out.println(m);
		}
		
		// 같은 것 어렵게 쓰기
		String str1 = "" + 10;
		String str2 = String.valueOf(10);
		System.out.println("확인? : " + str1.equals(str2));
		
		// StringBuffer - 필요성
		String a = "a";
		a += "b";
		a = a + "c";
		// 힙 영역 3개 잡아먹고 gc 돌아감 > 메모리 낭비
		
		// StringBuffer - 힙영역 1개에서 내용 수정
		// 메모리를 효율적으로 사용
		// 스레드에 안전하다 (Thread - safe)
		StringBuffer sb = new StringBuffer(); // ""
		sb = new StringBuffer(a); // "a"
		sb.append("b"); // "ab"
		sb.append("c"); // "abc"
		String d = sb.toString();
		
		// StringBuffer 보다 조금 빠름 -> 사용법은 같다
		// 스레드에 안전하지 않다 
		StringBuilder sb2 = new StringBuilder("a");
		
		// Math 함수 사용할 내용
		int vol = -3;
		if(vol < 0) {
			vol = 0;
		}
		if(vol > 10) {
			vol = 10;
		}
		
		// 실무에서 자주 사용하는 코드, 최소값 최대값 범위를 지정
		vol = Math.max(0, Math.min(10, vol));
	}
}
