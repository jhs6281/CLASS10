package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpDAO {
	public EmpDTO selectMember(EmpDTO dto) {

		EmpDTO result = null;
		// select
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			try (Connection conn = dataFactory.getConnection();) {

				String query = null;

				query = "select * from emp ";

				// login
				if (dto.getEmpno() != null && dto.getEname() != null) {
					query += "where empno ='" + dto.getEmpno() + "' and ename = '" + dto.getEname() + "'";
				}

				try (PreparedStatement ps = conn.prepareStatement(query); // 오라클용으로 컴파일
						// SQL 실행 및 결과 확보
						ResultSet rs = ps.executeQuery(); // 데이터 가져옴
				) { // 결과 활용

					if (rs.next()) {

						if (rs.getString("empno") == null) { // 이메일 비번 or 불일치
							return result;
						} else if (rs.getString("empno") != null) {

							result = new EmpDTO();

							result.setEmpno(rs.getInt("empno"));
							result.setEname(rs.getString("ename"));
							result.setJob(rs.getString("job"));
							result.setMgr(rs.getInt("mgr"));
							result.setHireDate(rs.getDate("hiredate"));
							result.setSal(rs.getInt("sal"));
							result.setComm(rs.getInt("comm"));
							result.setDeptno(rs.getInt("deptno"));

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("/check/service/dao - select : " + result);

		return result;
	}
}
