package sec02;

public class TvingExam {

	public static void main( String[] args ) { 
	Tving tv = new Tving();
	
	Naver n = new Naver();
	Kakao k = new Kakao();
	
	n.signin();
	tv.tvingLogin(n);
	}
	
}
