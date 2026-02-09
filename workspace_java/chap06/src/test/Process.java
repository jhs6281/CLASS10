package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Process {
	boolean power;
	ArrayList<String> cart = new ArrayList();
	int sumPrice;
	Scanner sc = new Scanner(System.in);

	// 전원
	void power() {
		this.power = true;
	}

	// 초기화
	void reset() {
		if (power) {
			Coffee cf = new Coffee();
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
