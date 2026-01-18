package chap04;

public class For_02 {

	public static void main(String[] args) {

		int[] rq2 = new int[] { 7, 12, 8, 5 };
		int[] rnq2 = new int [rq2.length];
	
		for (int i = 0; i < rq2.length; i++) {
			rnq2[i]=rq2[rq2.length-i-1];
			System.out.println(rnq2[i]);
		}
		
	}

}
