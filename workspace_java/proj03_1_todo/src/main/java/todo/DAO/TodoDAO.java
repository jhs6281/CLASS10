package todo.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import todo.DTO.TodoDTO;

// DAO : Data Access Object -> 데이터 접속 담당자
public class TodoDAO {

	// todo 테이블의 모든 항목을 돌려주는 메소드
	// 메소드명 : selectAll
	// 전달인자 : 없음
	// 리턴타입 : List

	public List<TodoDTO> selectAll() {

//		List list = new ArrayList();
		List<TodoDTO> list = new ArrayList<TodoDTO>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cnt = 1;

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
			String query = "select * from todo"; // 세미콜론 안씀!
			ps = conn.prepareStatement(query);// 오라클용으로 컴파일

			// SQL 실행 및 결과 확보
			rs = ps.executeQuery(); // 데이터 가져옴

			// 결과 활용 while
			while (rs.next()) {

				int todo_id = rs.getInt("todo_id");
				Date duedate = rs.getDate("duedate");
				int done = rs.getInt("done");
				String content = rs.getString("content");
				Date ctime = rs.getDate("ctime");

				TodoDTO todoDTO = new TodoDTO();
				todoDTO.setTodo_id(todo_id);
				todoDTO.setDuedate(duedate);
				todoDTO.setDone(done);
				todoDTO.setContent(content);
				todoDTO.setCtime(ctime);

				list.add(todoDTO);

//				Map map = new HashMap();

//				map.put("todo_id", todo_id);
//				map.put("duedate", duedate);
//				map.put("done", done);
//				map.put("content", content);
//				map.put("ctime", ctime);
//
//				list.add(map);

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

		}

		return list;
	}

	// todo 테이블의 한 줄만 돌려준다
	// 메소드명 : selectOne
	// 전달인자 : int todo_id
	// 리턴 타입 : TodoDTO

	public TodoDTO selectOne(int todo_id) {

		TodoDTO todoDTO = new TodoDTO();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 1. DB 접속

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			conn = dataFactory.getConnection();

			// 2. SQL 준비 // 방법 2
			String query = "select * from todo where todo_id=?";
			ps = conn.prepareStatement(query);// 오라클용으로 컴파일
			ps.setInt(1, todo_id); // 파라미터 전달인자 == todo_id 셀렉트 / get실행

			// 3. 실행 및 결과 확보
			rs = ps.executeQuery(); // 데이터 가져옴

			// 4. 결과 활용
			if (rs.next()) {

				// 컬럼 전부 출력
				todoDTO.setTodo_id(rs.getInt("todo_id"));
				todoDTO.setDuedate(rs.getDate("duedate"));
				todoDTO.setDone(rs.getInt("done"));
				todoDTO.setContent(rs.getString("content"));
				todoDTO.setCtime(rs.getDate("ctime"));

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

		}

		// 4. 결과 활용
		return todoDTO;
	}

	////////////////
	public int insertTodo(TodoDTO todoDTO) {

		String content = (String) todoDTO.getTodo_content();
		int result = -1;
		
		try { // 1. DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			String query = 
					  " INSERT INTO todo" 
					+ " VALUES (seq_todo.nextval, NULL, 0, ?, sysdate)";
			
			// 2. SQL 준비
			try (Connection conn = dataFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
				
				ps.setString(1, content); 
				
				result = ps.executeUpdate(); // Add
				System.out.println("/todoDAO insertDB 완료: " + result);
					
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	////////////////
	public int updateTodo(TodoDTO todoDTO) {

		String content = (String) todoDTO.getTodo_content();
		int id = (int) todoDTO.getTodo_id();
		
		int result = -1;
		
		///////////////////////////////////////////////////////
		
		try { // 1. DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			String query = "UPDATE todo SET Content = ? WHERE todo_id = ?";
			
			// 2. SQL 준비
			try (Connection conn = dataFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);) {
				
				ps.setString(1, content); 
				ps.setInt(2, id); 
				
				result = ps.executeUpdate(); // Add
				System.out.println("/todoDAO updateDB 완료: " + result);
					
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	///////////////
}
