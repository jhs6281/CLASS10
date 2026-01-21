package quizGmarket;

public class Goods {
	
	String name;
	String price;
	String information;
	String inCart;
	
	//상품 필수 정보 생성자
	Goods(String name, String price, String information){
		this.name=name;
		this.price=price;
		this.information=information;
	}
	
//	//상품명 받기
//	String goodsName() {
//		return name;
//	}
//	//가격 받기
//	String goodsPrice() {
//		return price;
//	}
//	//정보 받기
//	String goodsInfo() {
//		return information;
//	}
	
	String info() {
		return "상품명 : " + name + " / 가격 : " + price + " / 정보 : " + information;
	}
	
	
	
	

}
