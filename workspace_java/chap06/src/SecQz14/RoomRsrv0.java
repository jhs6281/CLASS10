package SecQz14;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomRsrv0 {
	int count;
	boolean flag;
	
	
	// 방 10개 생성.
	// pensionInfo의 reserv()를 받아온다.
	// 방이 > 10 출력 : 방이 가득 찼습니다.

	void room(ArrayList<PensionInfo0> p) {		
		while(!flag) {
			boolean full;
			System.out.println("예약 시스템을 시작합니다. ");
			System.out.println("1.예약하기 2.예약 현황 0.종료");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			
			
			if(num == 0) {
				flag = true;
			}
			else if (num == 1) {
			
				for (int i=0; i<=10; i++) {	
//					p.add(PensionInfo0 pi);
				}
			}
			
			else if(num == 2) {
				for (PensionInfo0 pi : p) {	
					pi.info();
//				if (count > 10) {
//					System.out.println("방이 가득 찼습니다. ");
//				} else {
//					if (pi.startDate > 0 && pi.startDate < 10 && pi.endDate >= pi.startDate && pi.endDate <= 10) {
//						// 예약 : 1일~10일
//						System.out.println("예약에 성공하셨습니다.");
//						
//
//						System.out.println("예약하신 날짜 정보 : " + pi.startDate + "일부터 " + pi.endDate + "일까지입니다. ");
//					} else if (pi.startDate > 11 && pi.startDate <= pi.endDate && pi.endDate <= 31) {
//						// 예약 : 11일~31일
//						System.out.println("해당 날짜는 예약하실 수 없습니다. ");
//					} else {
//						// 예약 오류 방어코드
//						System.out.println("올바른 날짜를 입력하십시오. ");
//					}
//				}
			}
		}

		}

	}
}
