package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleJDBCExam {

	public static void main(String[] args) {
		
		long before = System.currentTimeMillis();

		// 퓨어 자바에서 사용할 수 있게 해주는 클래스(new)
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 접속할 때 사용하는 주소 (고정)
		String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
		// oracle / id, pw
		String user = "scott1_5";
		String password = "tiger";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cnt=1;

		try {

			// Class.forName : String 을 이용해서 class를 생성
			// new OracleDriver();
			// 드라이버 driver : 서로 다른 것들을 서로 사용할 수 있도록 해주는 것
			Class.forName(driver);

			// DB 접속
			conn = DriverManager.getConnection(url, user, password);

			// SQL 준비
			String query = "select * from emp"; // 세미콜론 안씀!
			ps = conn.prepareStatement(query);// 오라클용 언어로 컴파일

			// SQL 실행 및 결과 확보
			System.out.println("hello world");
			rs = ps.executeQuery(); // 데이터 가져옴 '표 전체'
			
			// 결과 활용
			while( rs.next() ) { // set 형태라서 Next / next() 한 순간 데이터는 '한 줄'
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				
				System.out.print("No." + cnt);
				System.out.print(", empno : " + empno);
				System.out.println(", ename : " + ename);
				
				cnt++;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
			// try-catch-resource
//		try ( 
//				Connection conn2 = DriverManager.getConnection(url, user, password);
//				PreparedStatement ps2 = conn.prepareStatement("select * from emp"); 
//			) {
//			Class.forName(driver);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
		}
		long after = System.currentTimeMillis();
		System.out.println( "걸린 시간 : " + (after-before));
	}
}
