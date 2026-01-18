package chap05;

public class RefExam_01 {

	public static void main(String[] args) {

		int a = 10;
		int b = a;
		System.out.println("출력 a : " + a + " 출력 b : " + b);

		b = 12;
		System.out.println("출력 a : " + a + " 출력 b : " + b);

		String name = "정현수";
//		= 오른쪽이 먼저 실행 됨
//		"최민수"를 힙heap 영역에 할당하면 번지 획득
//		스택 stack 영역의 변수 name에 번지 저장

		System.out.println(name);
//		name이 가르키는 번지에 값을 가져온다

		System.out.println(a == b);
//		==, != 은 무조건 stack의 값을 비교한다

//		new = 같은 값이 있어도 새로운 번지수에 저장한다
		String name2 = new String("정현수");
		System.out.println(name2);
		System.out.println(name == name2);

		System.out.println(name.equals(name2));
		String name4 = "정" + "현수";
		System.out.println(name == name4);
//		번지수가 3개 생김 정 따로 현수 따로 더해진 값(정현수) 따로
//		더한 결과가 String이라 번지수 재활용되어 true 결과가 나옴

		String name5 = name;
		System.out.println("name5: " + name5);
		System.out.println(name5 == name);
		name = "다른걸로";
		System.out.println("after name 5 : " + name5); // 정현수
		System.out.println(name5 == name);

//		int c = null;
//		기본 타입에는 null을 넣을 수 없다

//		null : 참조하는 주소가 없는 상태
		String addr = "천안";
		System.out.println("addr == null : " + (addr == null));
		System.out.println("addr != null : " + (addr != null));

		String addr2 = ""; // null 아님
		System.out.println("addr2 == null : " + (addr2 == null));

		addr = null;
//		"천안"과 연결이 끊어지고
//		"천안"은 참조하고 있는 변수가 없어서
//		garbage collector(가베지 컬렉터, gc)가 지워버린다

		System.out.println("addr + \"abc\" : " + (addr + "abc"));
//		출력할 때만 "null"이라는 글씨로 바뀐다

//		addr이 null이라서
//		NullpointerException 발생
//		if(addr.equals(addr2)) {
//			System.out.println("같다");

//		System.out.println(addr2.equals(addr));
		if (addr != null) { // 방어 코딩
			System.out.println(addr.equals(addr2));
		} else {
			System.out.println("addr이 null");
		}

//		비교 전략

		// 1.
		if (addr.equals("천안")) {
		}
		// addr이 null일 수 있다. = 방어 코딩 필요
//		null.equals"천안 >> null일 가능성이 있어서 비교 오류"
		// 2.
		if ("천안".equals(addr)) {
		}
		// 천안은 null과 같은가? >> 방어 코딩 필요없음

	}

}
