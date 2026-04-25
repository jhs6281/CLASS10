package emp_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import emp_DTO.EmpDTO;

public class EmpDAO {
	public List select(EmpDTO empDTO) {

		List list = new ArrayList();
		System.out.println("/DAO 실행");
		
			try (Connection conn = getConn();) {

				// LoggableStatement 라이브러리 필요 (DAO 패키지에 넣어주기)
				PreparedStatement ps = new LoggableStatement(conn,
						"SELECT * FROM (" + "	SELECT rownum AS rnum, e.* FROM (" + "		SELECT * FROM emp"
								+ "		ORDER BY hiredate) e)" + " WHERE rnum >= ? AND rnum <= ?");

				ps.setInt(1, empDTO.getStart());
				ps.setInt(2, empDTO.getEnd());

				System.out.println(((LoggableStatement) ps).getQueryString());

				try (// SQL 실행 및 결과 확보
						ResultSet rs = ps.executeQuery(); // 데이터 가져옴
				) {
					while (rs.next()) {

						list.add(setEmpDTO(rs));
					}
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("list size : " + list.size());
		return list;
	}

	public int cntTable() {
		
		System.out.println("/DAO 실행");
		int cnt = -1;
		
			try (
					Connection conn = getConn();
					// LoggableStatement 라이브러리 필요 (DAO 패키지에 넣어주기)
					PreparedStatement ps = new LoggableStatement(conn,
							"SELECT count(*) cnt FROM emp");
					) {
				// DB 조회 결과
				System.out.println(((LoggableStatement) ps).getQueryString());
				
				try (ResultSet rs = ps.executeQuery();) {
					
					if (rs.next()) {
						
						cnt = rs.getInt("cnt");
					}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("count : " + cnt);
		return cnt;
	}

	// DB 접속 메소드로 분리
	private Connection getConn() {
		Connection conn = null;
		try {
			// JNDI 방식
			// context.xml에 있는 DB 정보로 커넥션 풀을 가져온다
			Context ctx = new InitialContext();
			// DataSource : 커넥션 풀 관리자
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// DB 접속(그런데 이제 커넥션 풀로)
			conn = dataFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// Set EmpDTO for rs
	private EmpDTO setEmpDTO(ResultSet rs) {
		
		EmpDTO eDTO = new EmpDTO();

		try {
			
			eDTO.setEmpno(rs.getInt("empno"));
			eDTO.setEname(rs.getString("ename"));
			eDTO.setJob(rs.getString("job"));
			eDTO.setMgr(rs.getInt("mgr"));
			eDTO.setHireDate(rs.getDate("hiredate"));
			eDTO.setSal(rs.getInt("sal"));
			eDTO.setComm(rs.getInt("comm"));
			eDTO.setDeptno(rs.getInt("deptno"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return eDTO;
	}
	
}
