package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public abstract class ParentDAO<T> {

	// 구현해서 사용할 메소드
	// set Query / set DTO(rs)
	protected abstract String selectQuery(String selector);
	protected abstract T setDTO(ResultSet rs); // DTO 세팅

	protected abstract String insertQuery();
	protected abstract PreparedStatement setInsertPs(PreparedStatement ps); 

	protected abstract String modifyQuery();
	protected abstract PreparedStatement setModifyPs(PreparedStatement ps); // set ps 합칠 수 있는지 확인 필요

	protected abstract String deleteQuery(); // ps 없음


	// 주요 메소드 로직 (DTO 수정해서 사용 사용 고정)
	// select
	public List selectDB(T dto, String selector) {

		List list = new ArrayList();

		try (Connection conn = getConn();) {

			try (PreparedStatement ps = conn.prepareStatement(selectQuery(selector)); // 오라클용으로 컴파일
					// SQL 실행 및 결과 확보
					ResultSet rs = ps.executeQuery(); // 데이터 가져옴
			) { // 결과 활용
				while (rs.next()) {

					list.add(setDTO(rs));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("/select list : " + list);
		return list;
	}

	// insert
	public T insertDB(T dto) {

		T result = dto;

		try (Connection conn = getConn(); PreparedStatement ps = conn.prepareStatement(insertQuery())) {

			// set ? 쿼리 채우기
			setInsertPs(ps).executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("/insert result : " + result);
		return result;
	}

	// modify
	public T modifyDB(T dto) {

		try ( Connection conn = getConn(); 
				PreparedStatement ps = new LoggableStatement(conn, modifyQuery()); ) {
			
			setModifyPs(ps).executeUpdate();

			ps.executeUpdate();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("/modify result : " + dto);
		return dto;
	}
	
	//delete
	public int deleteDB(T dto) {

		int result = -1;
		
			try ( Connection conn = getConn(); 
					PreparedStatement ps = new LoggableStatement(conn, deleteQuery()); ) {
				
				result = ps.executeUpdate();
			}

		 catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("/delete result : " + result);
		return result;

	}

	// 사용 고정
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
}
