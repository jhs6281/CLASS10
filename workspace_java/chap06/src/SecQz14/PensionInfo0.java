package SecQz14;

public class PensionInfo0 {
	int startDate;
	int endDate;
	
	// if (full - 예약 인수 < 0){ "인원을 초과하였습니다." } 
	int full=10;
	boolean pet;
	boolean beef = true;
	
	void rsrv(int startDate, int endDate){
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	void info() {
		System.out.println( 
				
				"방 최대 허용 인원 : " + full 
				+ " / 반려동물 여부: " + pet
				+ " / 바베큐장 여부: " + beef
				);
	}

}
