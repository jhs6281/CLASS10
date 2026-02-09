package SecQz14;

import java.util.ArrayList;

public class RoomRsrv {

	int count;
	// 방 10개 생성.
	// pensionInfo의 reserv()를 받아온다.
	// 방이 > 10 출력 : 방이 가득 찼습니다.

	void room(ArrayList<PensionInfo> p) {

		for (PensionInfo pi : p) {

			if (count > 10) {
				System.out.println("방이 가득 찼습니다. ");
			} else {
				if (pi.startDate > 0 
						&& pi.startDate < 10 
						&& pi.endDate >= pi.startDate 
						&& pi.endDate <= 10) {
					// 예약 : 1일~10일
					System.out.println("예약에 성공하셨습니다.");
					count++;
					pi.info();
					System.out.println("예약하신 날짜 정보 : " + pi.startDate + "일부터 " + pi.endDate + "일까지입니다. ");
				} else if (pi.startDate > 11 
						&& pi.startDate <= pi.endDate 
						&& pi.endDate <= 31) {
					// 예약 : 11일~31일
					System.out.println("해당 날짜는 예약하실 수 없습니다. ");
				} else {
					// 예약 오류 방어코드
					System.out.println("올바른 날짜를 입력하십시오. ");
				}

			}

		}

//		for (int i = 0; i < p.size(); i++) {
//			System.out.println(pi.startDate);

	}

}
