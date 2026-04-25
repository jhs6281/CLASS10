package examDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import examDTO.SignInDTO;

public class SignInDAO {

	public List selectDB(SignInDTO checkNum) {

		List list = new ArrayList();
		/////
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			try (Connection conn = dataFactory.getConnection();) {
				
				String query = null;
				int chk = checkNum.getNum();
				
				if(chk < 0) {
					query = "select * from signIn";
				} else {
					query = "select * from signIn where num =" + chk;
				}
				try (PreparedStatement ps = conn.prepareStatement(query); // 오라클용으로 컴파일
						// SQL 실행 및 결과 확보
						ResultSet rs = ps.executeQuery(); // 데이터 가져옴
				) { // 결과 활용
					while (rs.next()) {

						SignInDTO siDTO = new SignInDTO();

						siDTO.setNum(rs.getInt("num"));
						siDTO.setEmpno(rs.getInt("empno"));
						siDTO.setId(rs.getString("id"));
						siDTO.setPw(rs.getString("pw"));
						siDTO.setEmail(rs.getString("email"));
						siDTO.setHireDate(rs.getDate("hiredate"));
						siDTO.setWorking(rs.getInt("working"));

						list.add(siDTO);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int insertDB(SignInDTO siDTO) {

		String id = (String) siDTO.getId();
		String pw = (String) siDTO.getPw();
		String email = (String) siDTO.getEmail();
		int empno = (int) siDTO.getEmpno();
		Date hireDate = (Date) siDTO.getHireDate();

		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// data -> DB
			String query = 
					  "INSERT INTO signIn ( num, id, pw, email, empno, hiredate) "
					+ "VALUES ( num.nextval, ?, ?, ?, ?, ?)";

			try (Connection conn = dataFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

				ps.setString(1, id);
				ps.setString(2, pw);
				ps.setString(3, email);
				ps.setInt(4, empno);
				ps.setDate(5, hireDate);

				result = ps.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	public int updateDB(SignInDTO siDTO) {

		int num = (int) siDTO.getNum();
		int empno = (int) siDTO.getEmpno();
		String id = (String) siDTO.getId();
		String pw = (String) siDTO.getPw();
		String email = (String) siDTO.getEmail();
		Date hireDate = (Date) siDTO.getHireDate();
		int working = (int) siDTO.getWorking();

		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// data -> DB
			String query = 
					  "UPDATE signIn SET "
							  + "empno = ?, "
							  + "id = ?, "
							  + "pw = ?, "
							  + "email = ?, "
							  + "hiredate = ?, "
							  + "working = ? "
							  + "WHERE num = ? ";

			try (Connection conn = dataFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

				ps.setInt(1, empno);
				ps.setString(2, id);
				ps.setString(3, pw);
				ps.setString(4, email);
				ps.setDate(5, hireDate);
				ps.setInt(6, working);
				ps.setInt(7, num);

				result = ps.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	public int deleteDB(SignInDTO siDTO) {

		int num = (int) siDTO.getNum();

		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// data -> DB
			String query = 
					  "DELETE FROM signIn WHERE num = ?";

			try (Connection conn = dataFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
				
				ps.setInt(1, num);
				result = ps.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}
