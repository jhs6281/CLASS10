package test;

import java.util.ArrayList;

class Coffee {
	// Scan menu;
	String coffee;
	int price;
	int priceSum;

	String[] cf_menu = { "아메리카노", "카페라떼", "카푸치노" };
	String[] nonCf_menu = { "아이스티", "프라푸치노", "밀크쉐이크" };

//	ArrayList<Coffee> cart = new ArrayList<>();
	void Order(String coffee) {
		this.coffee = coffee;
	}

	int prc() { // return 가격 
		if (cf_menu[0].equals(this.coffee)) {
			this.price = 1000;
			this.priceSum += price;
			return price;
		}

		else if (cf_menu[1].equals(this.coffee)) {
			this.price = 2000;
			this.priceSum += price;
			return price;
		}
		
		else if (cf_menu[2].equals(this.coffee)) {
			this.price = 3000;
			this.priceSum += price;
			return price;
		}
		
		else if (nonCf_menu[0].equals(this.coffee)) {
			this.price = 1000;
			this.priceSum += price;
			return price;
		}

		else if (nonCf_menu[1].equals(this.coffee)) {
			this.price = 2000;
			this.priceSum += price;
			return price;
		}
		
		else if (nonCf_menu[2].equals(this.coffee)) {
			this.price = 3000;
			this.priceSum += price;
			return price;
		}
		else {
			System.out.println("올바르지 않습니다. ");
		}
		return price;
	}
	
	
	void receipt() { // 총합
		System.out.println("구매 하신 내역 : ");
		System.out.println("");
	}

}

public class Mestest {
	public static void main(String[] args) {
		Coffee cf = new Coffee();

		Process pr = new Process();

		pr.power();

		// 초기화 버튼
		pr.program();

	}
}
