package quizGmarket;

public class Shop {

	public static void main(String[] args) {

//		Goods [] goods = new Goods [3];
		// 1. 상품 3개 진열

//		System.out.println(goods1.goodsName()); // 연결 테스트
		Goods[] goods = new Goods[5];
		goods[0] = new Goods("텀블러", "20000", "물 담는 통");
		goods[1] = new Goods("인형", "10000", "귀여움");
		goods[2] = new Goods("안경", "30000", "잘 보임");

		Users[] user = new Users[2];

		// 2. 회원 2명 이상 A = 0 / B = 1
		user[0] = new Users("A");
		user[1] = new Users("B");

		// 3. 장바구니 담기 테스트
//		user[0].cart[0]= goods[0]; //OK
		user[0].cart[0] = goods[0];
		user[0].cart[1] = goods[2];

		user[1].cart[0] = goods[0];
		user[1].cart[1] = goods[1];
		user[1].cart[2] = goods[2];

		// 이름, 가격, 정보 (서로 다른 변수의 값들을 배열에 어떻게 담을 수 있는가?)
		// 정답: 배열 타입을 값과 동일하게 한다. (Users [] i = new Users[];)

		// 4. 장바구니 출력 테스트
//		System.out.println(user[0].cart[0].info()); //OK	
//		System.out.println(user[0].ID());//ID 리턴 테스트 // OK

		for (int i = 0; i < 2; i++) {
			System.out.println("users ID: " + user[i].ID());
			// 유저 2명 출력하는 동안 유저의 장바구니 출력할 것
			for (int j = 0; j < 5; j++) {
				if (user[i].cart[j] != null) {
					System.out.println(user[i].cart[j].info());
				}
			}
		}

//		System.out.println(user[0].cart[0]);

	}

}
