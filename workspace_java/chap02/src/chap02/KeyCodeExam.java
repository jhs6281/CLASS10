package chap02;

import java.util.Scanner;

public class KeyCodeExam {

	public static void main(String[] args) {

		System.out.println(1);
		System.out.println(2);

		System.out.print(3);
		System.out.print(4);
		System.out.println(5);
//		System.out.println(); <br>처럼 그냥 엔터
		String name = "정현수";
		int age = 20;
		System.out.printf("이름: %s, 나이: %d\n", name, age);

//		입력
		int keyCode;

		/*
		 * Scanner 연습 하려고 주석
		 * 
		 * try { System.out.println("입력하시오 >> "); keyCode = System.in.read();
		 * System.out.println("keyCode: "+ keyCode); keyCode = System.in.read();
		 * System.out.println("keyCode: "+ keyCode); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 */

//		이클립스 단축키
		/*
		 * import 자동 : Ctrl+Shift+o  
		 * 주석 단축키 : Ctrl + / 
		 * 한줄 복사 : Ctrl + Alt + 위 아래 방향키
		 * 한줄 지우기 : Ctrl + d 
		 * 자동 정렬 : Ctrl + Shift + f
		 */
		
		Scanner scanner = new Scanner(System.in);
//		엔터까지의 모든 글씨
//		String inputDate = scanner.nextLine();
//		System.out.println("inputDate: " + inputDate);
//		
//		문제
//		나이를 입력하고 + 1해서 출력
		
		System.out.print("나이를 입력하세요");
//		원래 방법
//		String sscan = scanner.nextLine();
//		int Myage = (Integer.parseInt(sscan)+1);
		
//		scanner로 받은 값을 인트 타입으로 한번에 바꿔주는 기능
		int Myage = scanner.nextInt()+1;
		System.out.println("내년 나이: " + Myage + "살 입니다. ");
		
		
		
		
	}

}
