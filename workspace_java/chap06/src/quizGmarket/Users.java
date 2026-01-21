package quizGmarket;

public class Users {
//	유저 ID
	String id; // 아이디 만들기
	Goods[] cart = new Goods[5]; // 장바구니 만들기
	

	
	
	Users(String id) {
		this.id = id;
	} // ID get

	String ID() {
		return this.id;
	}
	
	void carting () {
		
		
	}
	
}


//	void cart() {
//		Goods goods = new Goods();
//	}

// 전략
// 장바구니 변수 만들어서 Goods의 이름, 가격, 정보 return받고
// 출력 or return
