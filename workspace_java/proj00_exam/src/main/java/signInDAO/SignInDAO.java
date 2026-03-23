package signInDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SignInDAO {

	// DB -> Data 받아오기 -> Java
	public List selectAll() {

		List list = new ArrayList();

		try {
			Context ctx = new InitialContext();

			// ctx.lookup("java:/comp/env/"); -> 이후 내 ID
			// 팩토리 패턴 > 값에 (java, oracle, mySQL) 종류에 따라 알아서 처리해주는 공장식 패턴.
			// 커넥션 풀 관리자.
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			try (Connection conn = dataFactory.getConnection();) {
				String query = "select * from signIn"; // 세미콜론 안씀!
				try (

						PreparedStatement ps = conn.prepareStatement(query); // 오라클용으로 컴파일

						// SQL 실행 및 결과 확보
						ResultSet rs = ps.executeQuery(); // 데이터 가져옴
				) { // 결과 활용
					while (rs.next()) {

						int num = rs.getInt("num");
						int empno = rs.getInt("empno");
						String id = rs.getString("id");
						String pw = rs.getString("pw");
						String email = rs.getString("email");
						Date hiredate = rs.getDate("hiredate");
						int working = rs.getInt("working");

						Map map = new HashMap();

						map.put("num", num);
						map.put("empno", empno);
						map.put("id", id);
						map.put("pw", pw);
						map.put("email", email);
						map.put("hiredate", hiredate);
						map.put("working", working);

						list.add(map);

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// test
		System.out.println("/dao DB list: " + list.size());

		return list;
	}

	// 데이터 넣기
	public void insertDB(String id, String pw, String email, int empno, String hireDate) {

//			Connection conn = null;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// data -> DB
			String query = "INSERT INTO signIn ( num, id, pw, email, empno, hiredate) "
					+ "VALUES ( num.nextval, ?, ?, ?, ?, ?)";

			try (Connection conn = dataFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
				System.out.println("/DTO 실행 확인");

				ps.setString(1, id);
				ps.setString(2, pw);
				ps.setString(3, email);
				ps.setInt(4, empno);
				ps.setString(5, hireDate);

				ps.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
