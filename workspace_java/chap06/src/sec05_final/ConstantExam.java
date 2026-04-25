package sec05_final;

public class ConstantExam {

	public static void main(String[] args) {
		//ARS 
		//상품 문의
		//고장 문의
		
		int as = statusCheck("고장 문의");
		
		if(as == Constant.E03) {
			System.out.println("냉매 충전 필요");			
		}
		
		else if(as == Constant.OK) {
			System.out.println("조치 필요");
		}
		
		static int statusCheck(String request) {
			if("상품문의".equals(request)) {
//				return Constant.E03;
				else {
//					return Constant.OK;
					
				}
			}			
			return 1;
		}
	}

}
