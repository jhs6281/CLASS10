package test;

import java.util.ArrayList;
import java.util.Scanner;

class Cof {
	// Scan menu;
	Scanner sc = new Scanner(System.in);
	String coffee;
	String cfName;
	int price;

	String[] cf_menu = { "아메리카노", "카페라떼", "카푸치노" };
	String[] nonCf_menu = { "아이스티", "프라푸치노", "밀크쉐이크" };
	int[] priceList = { 1000, 2000, 3000 };

	String Order() {
		System.out.println("주문하실 메뉴를 선택해주세요.");
		System.out.println("입력 1: 커피 / 입력 2: 논커피");
		int scan = sc.nextInt();

		if (scan == 1) { //카페인 메뉴
			
			System.out.println("메뉴를 한글로 입력하세요 ");
			System.out.println("[메뉴판]");
			System.out.println("[아메리카노] [카페라떼] [카푸치노]");
			String scan1 = sc.next();
			
			for (int i = 0; i < cf_menu.length; i++) {
				if (cf_menu[i].equals(scan1)) {
					this.price = priceList[i];
					this.cfName = scan1;
					return cf_menu[i];
				} else {
					System.out.println("올바른 메뉴명을 입력해주세요. ");
				}
			}
		}
		else if (scan == 2) { //논카페인
			System.out.println("메뉴를 한글로 입력하세요 ");
			System.out.println("[메뉴판]");
			System.out.println("[아이스티] [프라푸치노] [밀크쉐이크]");
			String scan2 = sc.next();
			
			for (int i = 0; i < nonCf_menu.length; i++) {
				if (nonCf_menu[i].equals(scan2)) {
					this.price = priceList[i];
					this.cfName = scan2;
					return cf_menu[i];
				} else {
					System.out.println("올바른 메뉴명을 입력해주세요. ");
				}
			}
		}
		else {
			System.out.println("올바른 숫자를 입력해주세요. ");
		}
		return "";
	}
} // Class 필드 & 리턴 끝

// Class 프로세스 시작
class Pro {
	Scanner sc = new Scanner(System.in);
	ArrayList<Cof> cart = new ArrayList();
	Cof c = new Cof();
	boolean power;
	int sumPrice;

	// ON 시작할 때
	void powerOn() {
		this.power = true;
	}

	// OFF
	void powerOff() {
		this.power = false;
	}

	// 초기화
	void reset() {
		if (power) {
			Cof cf = new Cof();
			Pro pr = new Pro();
		}
	}

	// ON 하고 왔음
	// Order(String i) -> ArrayList<>에 넣을까?
	void pro() {
		while (power) {
			boolean next = false;
			c.Order();

		}

	}

	// 결제

	// 선택
	void selectMenu() {
		boolean next = false;
		int a = sc.nextInt();
		if (a == 1) {
			System.out.println("아이스를 선택하셨습니다.");
			System.out.println("장바구니에 담습니다.");
			sumPrice += 1000;
			cart.add("[아메리카노 1000원]");
			next = true;
		} else if (a == 2) {
			System.out.println("핫을 선택하셨습니다.");
			System.out.println("장바구니에 담습니다.");
			sumPrice += 1000;
			cart.add("[아메리카노 1000원]");
			next = true;
		} else {
			System.out.println("입력이 올바르지 않습니다.");
		}
	}

	// 프로세스
	void program() {
		while (power) {
			boolean next = false;
			System.out.println("주문하실 메뉴를 선택해주세요.");
			System.out.println("입력 1: 커피 / 입력 2: 논커피 / 입력 0: 결제");
			int a = sc.nextInt();

			if (a == 0) {
				System.out.println("영수증: ");
				for (int i = 0; i < cart.size(); i++) {
					System.out.println(cart.get(i));

				}
				System.out.println("합계: " + sumPrice);
			}

			else if (a == 1) { // 다음으로 이동할 때까지 장바구니에 담기
				while (!next) {

					System.out.println("상품을 선택해주세요");
					System.out.println("입력 1: [아메리카노 1000원] / 입력 2: [카페라떼 2000원] / 입력 3: [카푸치노 3000원]");
					int a1 = sc.nextInt();
					if (a1 == 1) {
						System.out.println("[아메리카노 1000원]를 선택하셨습니다.");
						System.out.println("무료옵션을 선택해주세요");
						System.out.println("입력 1: 아이스 / 입력 2: 핫");
						int a1_0 = sc.nextInt();
						if (a1_0 == 1) {
							System.out.println("아이스를 선택하셨습니다.");
							System.out.println("장바구니에 담습니다.");
							sumPrice += 1000;
							cart.add("[아메리카노 1000원]");
							next = true;
						} else if (a1_0 == 2) {
							System.out.println("핫을 선택하셨습니다.");
							System.out.println("장바구니에 담습니다.");
							sumPrice += 1000;
							cart.add("[아메리카노 1000원]");
							next = true;
						} else {
							System.out.println("입력이 올바르지 않습니다.");
						}
					}

					else if (a1 == 2) {
						System.out.println("[카페라떼 2000원]를 선택하셨습니다.");
						System.out.println("무료옵션을 선택해주세요");
						System.out.println("입력 1: 아이스 / 입력 2: 핫");
						int a1_2 = sc.nextInt();
						if (a1_2 == 1) {
							System.out.println("아이스를 선택하셨습니다.");
							System.out.println("장바구니에 담습니다.");
							sumPrice += 2000;
							cart.add("[카페라떼 2000원]");
							next = true;
						} else if (a1_2 == 2) {
							System.out.println("핫을 선택하셨습니다.");
							System.out.println("장바구니에 담습니다.");
							sumPrice += 2000;
							cart.add("[카페라떼 2000원]");
							next = true;
						} else {
							System.out.println("입력이 올바르지 않습니다.");
						}
					} else if (a1 == 3) {
						System.out.println("[카푸치노 3000원]를 선택하셨습니다.");
						System.out.println("무료옵션을 선택해주세요");
						System.out.println("입력 1: 아이스 / 입력 2: 핫");
						int a1_3 = sc.nextInt();
						if (a1_3 == 1) {
							System.out.println("아이스를 선택하셨습니다.");
							System.out.println("장바구니에 담습니다.");
							sumPrice += 3000;
							cart.add("[카푸치노 3000원]");
							next = true;
						} else if (a1_3 == 2) {
							System.out.println("핫을 선택하셨습니다.");
							System.out.println("장바구니에 담습니다.");
							sumPrice += 3000;
							cart.add("[카푸치노 3000원]");
							next = true;
						} else {
							System.out.println("입력이 올바르지 않습니다.");
						}
					} else {
						System.out.println("입력이 올바르지 않습니다.");
					}

				}

			}

		}
	}
}

public class last {

	public void main(String[] args) {

		{
			System.out.println("키오스크를 시작합니다.");
			System.out.println("메뉴 ");
			System.out.println("메뉴 ");
			System.out.println("메뉴 ");
			System.out.println("메뉴 ");
			System.out.println("메뉴 ");
			System.out.println("메뉴 ");

//			powerOn() -> pro() /reset()/ -> powerOff()

//			pro() 내용 중에 Order 값 소환.

		}

	}
}
