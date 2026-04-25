package userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.sql.DATE;
import userdto.UserDTO;

public class UserDAO {
		// select
//		public List selectDB(UserDTO dto) {
//			
//			List list = new ArrayList();
//			
//				try (Connection conn = getConn();) {
//
//					String query = "select * from coopang_userInfo ";
//					
//					// login
//					if (dto.getUser_id()!=null) {
//						// id 중복
//						query += "where user_id = '" + dto.getUser_id() + "'";
//					} else if(dto.getUser_email()!=null && dto.getUser_pw()!=null) {
//						query +="where user_email ='" + dto.getUser_email() + "' and user_pw ='"
//							+ dto.getUser_pw() + "'";
//						} else if (dto.getUser_num() > 0) {
//							query += "where user_num = " + dto.getUser_num() ;
//						}
//					
//					try (PreparedStatement ps = conn.prepareStatement(query); // 오라클용으로 컴파일
//							// SQL 실행 및 결과 확보
//							ResultSet rs = ps.executeQuery(); // 데이터 가져옴
//					) { // 결과 활용
//						while (rs.next()) {
//							if (rs.getString("user_num") == null) { // 이메일 비번 or 불일치
//								return list;
//							} else if (rs.getString("user_num") != null){
//								
//								UserDTO member = new UserDTO();
//								
//								member.setUser_num(rs.getInt("user_num"));
//								member.setUser_nickname(rs.getString("user_nickname"));
//								member.setUser_email(rs.getString("user_email"));
//								member.setUser_name(rs.getString("user_name"));
//								member.setUser_tel(rs.getString("user_tel"));
//								member.setUser_id(rs.getString("user_id"));
//								member.setUser_pw(rs.getString("user_pw"));
//								member.setUser_addr(rs.getString("user_addr"));
//								member.setHiredate(rs.getDate("hiredate"));
//								member.setGrade(rs.getInt("grade"));
//								
//								list.add(member);
//								
//							}
//						}
//					}
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println("/user/service/dao - select : " + list);
//			return list;
//		}
//
//		// insert
		public int insertDB(UserDTO dto) {

			int empno = dto.getEmpno();
			String ename = dto.getEname();
			String email = dto.getEmail();
			String id = dto.getId();
			String pw = dto.getPw();
			int grade = dto.getGrade();
			////////
			Integer mgr;
			DATE hireDate;
			
			
			int result = -1;

			try {
				Context ctx = new InitialContext();
				DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

				// data -> DB
				String query = "INSERT INTO coopang_userInfo ( user_num, User_nickname, User_email, User_name, User_tel,"
						+ " User_id, User_pw, User_addr) " + "VALUES ( user_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

				try (Connection conn = dataFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

					ps.setString(1, User_nickname);
					ps.setString(2, User_email);
					ps.setString(3, User_name);
					ps.setString(4, User_tel);
					ps.setString(5, User_id);
					ps.setString(6, User_pw);
					ps.setString(7, User_addr);
					
					result = ps.executeUpdate();

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("/user/service/dao - insert : " + result);
			return result;
		}
//		
//		//modify
//		public UserDTO modifyDB(UserDTO dto) {
//			
//				try (Connection conn = getConn(); 
//						PreparedStatement ps = new LoggableStatement(conn,
//											"UPDATE coopang_userInfo SET "
//													+ "User_nickname = ?, "
//													+ "User_email = ?, "
//													+ "User_name = ?, "
//													+ "User_tel = ?, "
//													+ "User_id = ?, "
//													+ "User_pw = ?,"
//													+ "User_addr = ?, "
//													+ "hireDate = ?, "
//													+ "grade = ? "
//													+ "WHERE user_num = ? ");) {
//
//					ps.setString(1, dto.getUser_nickname());
//					ps.setString(2, dto.getUser_email());
//					ps.setString(3, dto.getUser_name());
//					ps.setString(4, dto.getUser_tel());
//					ps.setString(5, dto.getUser_id());
//					ps.setString(6, dto.getUser_pw());
//					ps.setString(7, dto.getUser_addr());
//					ps.setDate(8, dto.getHiredate());
//					ps.setInt(9, dto.getGrade());
//					ps.setInt(10, dto.getUser_num());
//					
//					ps.executeUpdate();
//
//				}
//
//			 catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println("/user/service/dao - modify : " + dto);
//			return dto;
//		}
//		
//		//delete
//		public int deleteDB(UserDTO dto) {
//
//			int num = dto.getUser_num();
//			int result = -1;
//			
//				try (Connection conn = getConn(); 
//						PreparedStatement ps = new LoggableStatement(conn,
//								"DELETE FROM coopang_userInfo WHERE user_num = ?"); ) {
//					
//					ps.setInt(1, num);
//					result = ps.executeUpdate();
//
//				}
//
//			 catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println("/user/service/dao - delete : " + result);
//			return result;
//
//		}
//		////////////////////
//		//// 재활용 메소드 ////
//		////////////////////
//		
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
			private UserDTO setVariable (UserDTO dto) {
				
				return dto;
			}
	

}
