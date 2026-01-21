package secQz09;

import java.util.ArrayList;

public class Calc {
	ArrayList<String> log = new ArrayList();

	double Cal(int x, String z, int y) {
		double result = 0;

		if ("+".equals(z)) {
			result = x + y;
		} else if ("-".equals(z)) {
			result = x - y;
		} else if ("*".equals(z)) {
			result = x * y;
		} else if ("/".equals(z)) {

			if (y != 0) {
				result = (double) x / y;
			} else {
				System.out.println("0으로 나눌 수 없습니다");
			}
		} else if ("%".equals(z)) {
			if (y != 0) {
				result = (double) x % y;
			} else {
				System.out.println("0으로 나눌 수 없습니다");
			}
		}

		String log = x + z + y + "=" + result;
		this.log.add(log);

		return result;
	}

	void viewLog() {
		for (int i = 0; i < this.log.size(); i++) {
			System.out.println(this.log.get(i));
		}
	}
}
