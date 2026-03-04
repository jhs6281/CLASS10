package controller;

public class ServletExam {

	public static void main(String[] args) {
//		EmpServiceImpl emser = new EmpServiceImpl();
//		emser.getEmpno();

		Servlet servlet = new EmpController();
		String html = servlet.doGet();
		System.out.println( html );
	}

}
