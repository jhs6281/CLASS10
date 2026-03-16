package chap00;

public class Exam {

	public static void main(String[] args) {
		int[] n = new int[] { 2, 3, 5 };
		int check = 10;

		for (int j = 0; j < n.length; j++) {
			boolean flag = false;
			for (int i = 1; i <= check; i++) {
//				System.out.println(1);
				if (n[j] == i) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("hi");
			}
		}
	}

}
