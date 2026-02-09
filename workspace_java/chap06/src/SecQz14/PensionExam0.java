package SecQz14;

import java.util.ArrayList;

public class PensionExam0 {
	public static void main(String[] args) {
		
		ArrayList<PensionInfo0> arrayPen = new ArrayList<PensionInfo0>();
		RoomRsrv0 r = new RoomRsrv0();
		
		// 방 10 개 생성.
		// PensionInfo0 클래스는 10번 정보가 갱신
		PensionInfo0 pi1 = new PensionInfo0();
		pi1.pet = true;
		pi1.beef = false;
		arrayPen.add(pi1);
		
		PensionInfo0 pi2 = new PensionInfo0();
		pi2.pet = true;
		pi2.beef = false;
		arrayPen.add(pi2);
		
		PensionInfo0 pi3 = new PensionInfo0();
		arrayPen.add(pi3);
		
		PensionInfo0 pi4 = new PensionInfo0();
		pi1.pet = true;
		pi1.beef = false;
		arrayPen.add(pi4);
		
		PensionInfo0 pi5 = new PensionInfo0();
		pi1.pet = true;
		pi1.beef = false;
		arrayPen.add(pi5);
		
		PensionInfo0 pi6 = new PensionInfo0();
		pi1.pet = true;
		pi1.beef = false;
		arrayPen.add(pi6);
		
		PensionInfo0 pi7 = new PensionInfo0();
		pi1.pet = true;
		pi1.beef = false;
		arrayPen.add(pi7);
		
		PensionInfo0 pi8 = new PensionInfo0();
		pi1.pet = true;
		pi1.beef = false;
		arrayPen.add(pi8);
		
		PensionInfo0 pi9 = new PensionInfo0();
		pi1.pet = true;
		pi1.beef = false;
		arrayPen.add(pi9);
		
		PensionInfo0 pi10 = new PensionInfo0();
		pi1.pet = true;
		pi1.beef = false;
		arrayPen.add(pi10);
		
		r.room(arrayPen);
	}

}
