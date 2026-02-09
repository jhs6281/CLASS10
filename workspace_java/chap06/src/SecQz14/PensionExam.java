package SecQz14;

import java.util.ArrayList;

public class PensionExam {
	public static void main(String[] args) {
		
		
		
		//예약
		//방(int 예약 시작 날짜, int 예약 종료 날짜)
		ArrayList<PensionInfo> arrayPen = new ArrayList<PensionInfo>();
		RoomRsrv r = new RoomRsrv();
		
		// 방 10 개 생성.
		PensionInfo pi1 = new PensionInfo(2, 3);
		PensionInfo pi2 = new PensionInfo(9, 11);
		PensionInfo pi3 = new PensionInfo(1, 10);
		PensionInfo pi4 = new PensionInfo(4, 8);
		PensionInfo pi5 = new PensionInfo(11, 15);
		PensionInfo pi6 = new PensionInfo(1, 7);
		PensionInfo pi7 = new PensionInfo(5, 7);
		PensionInfo pi8 = new PensionInfo(8, 9);
		PensionInfo pi9 = new PensionInfo(2, 3);
		PensionInfo pi10 = new PensionInfo(2, 3);		
		PensionInfo pi11 = new PensionInfo(2, 3);
		PensionInfo pi12 = new PensionInfo(2, 3);
		PensionInfo pi13 = new PensionInfo(2, 3);
		PensionInfo pi14 = new PensionInfo(2, 3);
		PensionInfo pi15 = new PensionInfo(2, 3);
		
		arrayPen.add(pi1);
		arrayPen.add(pi2);
		arrayPen.add(pi3);
		arrayPen.add(pi4);
		arrayPen.add(pi5);
		arrayPen.add(pi6);
		arrayPen.add(pi7);
		arrayPen.add(pi8);
		arrayPen.add(pi9);
		arrayPen.add(pi10);
		arrayPen.add(pi11);
		arrayPen.add(pi12);
		arrayPen.add(pi13);
		arrayPen.add(pi14);
		arrayPen.add(pi15);
		arrayPen.add(pi15);
		
		r.room(arrayPen);
		
		//reserv 예약 메소드 였던 것
		 //됨
//		pi.reserv(11,10); // 입력 날짜 오류
//		pi.reserv(11,20); // 예약 불가능 시간
//		pi.reserv(5,10);
//		pi.reserv(5,10);
//		pi.reserv(5,10);
//		pi.reserv(5,10);
//		pi.reserv(5,10);
//		pi.reserv(5,10);
//		pi.reserv(5,10);
//		pi.reserv(5,10);
//		pi.reserv(5,10); // 방 가득참
		


	}
}
