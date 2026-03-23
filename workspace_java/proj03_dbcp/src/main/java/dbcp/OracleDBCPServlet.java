package dbcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/dbcp")

public class OracleDBCPServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long before = System.currentTimeMillis();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cnt = 1;
		// String count = "00" + cnt;

		// if (count.length() > 3) {
		// count =
		// }

		try {

			// JNDI 방식
			// context.xml에 있는 DB 정보로 커넥션 툴을 가져온다
			Context ctx = new InitialContext();

			// ctx.lookup("java:/comp/env/"); -> 이후 내 ID
			// 팩토리 패턴 > 값에 (java, oracle, mySQL) 종류에 따라 알아서 처리해주는 공장식 패턴.
			// 커넥션 풀 관리자.
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 데이터 커넥션 풀 중에 하나 가져와라. (배달 기사 고용해)
			conn = dataFactory.getConnection();

			// SQL 준비
			String query = "select * from emp"; // 세미콜론 안씀!
			ps = conn.prepareStatement(query);// 오라클용으로 컴파일

			// SQL 실행 및 결과 확보
			System.out.println("hello world");
			rs = ps.executeQuery(); // 데이터 가져옴

			PrintWriter out = response.getWriter();

			print(rs, response);

			// 결과 활용
//			while (rs.next()) { // set 형태라서 Next
//				
//				// 데이터 컬럼별 가져오기
//				int empno = rs.getInt("empno");
//				String ename = rs.getString("ename");
//				Date hiredate = rs.getDate("hiredate");
//
//				//System.out.print("No." + cnt);
//				//System.out.print(", empno : " + empno);
//				//System.out.println(", ename : " + ename);
//
//
//				out.println("<div>");
//				out.println("	<strong>No : </strong>" + cnt + " /");
//				out.println("	<strong>empno : </strong>" + empno + " /");
//				out.println("	<strong>ename : </strong>" + ename + " /");
//				out.println("	<strong>hiredate : </strong>" + hiredate);
//				out.println("</div>");
//
//				cnt++;
//
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			long after = System.currentTimeMillis();
			System.out.println("걸린 시간 : " + (after - before));

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

		}
	}

	void print(ResultSet rs, HttpServletResponse response) throws IOException, SQLException {

		PrintWriter out = response.getWriter();

		int cnt = 1;

		out = response.getWriter();

		while (rs.next()) { // set 형태라서 Next

			// 데이터 컬럼별 가져오기
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			Date hiredate = rs.getDate("hiredate");

			out.println("<div>");
			out.println("	<strong>No : </strong>" + cnt + " /");
			out.println("	<strong>empno : </strong>" + empno + " /");
			out.println("	<strong>ename : </strong>" + ename + " /");
			out.println("	<strong>hiredate : </strong>" + hiredate);
			out.println("</div>");
			cnt++;
		}

	}

}
