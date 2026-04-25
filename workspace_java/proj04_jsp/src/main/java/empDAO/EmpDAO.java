package empDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import empDTO.EmpDTO;

public class EmpDAO {
	public List select() {
		
		List list = new ArrayList();
		System.out.println("/DAO 실행");
		
			try {
				Context ctx = new InitialContext();
				DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

				try (Connection conn = dataFactory.getConnection();) {
					
						String query = "select * from emp";
				
					try (PreparedStatement ps = conn.prepareStatement(query); // 오라클용으로 컴파일
							// SQL 실행 및 결과 확보
							ResultSet rs = ps.executeQuery(); // 데이터 가져옴
					) { // 결과 활용
						while (rs.next()) {

							EmpDTO eDTO = new EmpDTO();

							eDTO.setEmpNo(rs.getInt("empno"));
							eDTO.seteName(rs.getString("ename"));
							eDTO.setJob(rs.getString("job"));
							eDTO.setMgr(rs.getInt("mgr"));
							eDTO.setHireDate(rs.getDate("hiredate"));
							eDTO.setSal(rs.getInt("sal"));
							eDTO.setComm(rs.getInt("comm"));
							eDTO.setDeptno(rs.getInt("deptno"));

							list.add(eDTO);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(list.size());
		return list;
	}
}
