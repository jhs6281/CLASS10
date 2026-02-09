package test;

import java.util.ArrayList;
import java.util.Scanner;

class Menu{
	String menu;
	int price;
//	ArrayList<Menu> list = new ArrayList<Menu>();
	
	Menu(String menu, int price){
		this.menu = menu;
		this.price = price;
	}
}


class Order {
	
	Scanner sc = new Scanner(System.in);
	
	Order(ArrayList<Menu> cart){
		System.out.println("메뉴 번호 입력: 0, 1, 2");
		int scan = sc.nextInt();
		
		if (scan == 0) { cart.add(new Menu("아메리카노", 1000));z }
		if (scan == 1) { cart.add(new Menu("카페라떼", 2000)); }
		if (scan == 2) { cart.add(new Menu("카푸치노", 3000)); }
	}
}

public class NewTest {

	public static void main(String[] args) {
		
	}

}
