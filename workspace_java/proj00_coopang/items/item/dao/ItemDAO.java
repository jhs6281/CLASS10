package item.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import item.dto.ItemDTO;

public class ItemDAO {
	// select
		public List selectDB(ItemDTO dto) {
			
			List list = new ArrayList();
			
			try {
				Context ctx = new InitialContext();
				DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

				try (Connection conn = dataFactory.getConnection();) {

					String query = null;

					query = "select * from coopang_items ";
					
				
					if (dto.getItem_num() > 0) {
							query += "where item_num = " + dto.getItem_num();
						}
					
					
					try (PreparedStatement ps = conn.prepareStatement(query); // 오라클용으로 컴파일
							// SQL 실행 및 결과 확보
							ResultSet rs = ps.executeQuery(); // 데이터 가져옴
					) { // 결과 활용
						while (rs.next()) {

							if (rs.getString("item_num") == null) { // 이메일 비번 or 불일치
								return null;
							} else if (rs.getString("item_num") != null){
								
								ItemDTO item = new ItemDTO();
								
								item.setItem_num(rs.getInt("item_num"));
								item.setItem_img(rs.getString("item_img"));
								item.setCategory(rs.getString("category"));
								item.setItem_id(rs.getString("item_id"));
								item.setItem_name(rs.getString("item_name"));
								item.setPrice(rs.getInt("price"));
								item.setItem_info(rs.getString("item_info"));
								item.setScore(rs.getInt("score"));
								item.setSetTime(rs.getDate("setTime"));
								item.setShipping_Level(rs.getInt("shipping_Level"));
								
								list.add(item);
								
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("/item/service/dao - select : " + list);
			return list;
		}

		// insert
		public int insertDB(ItemDTO dto) {
			
			String item_img =  dto.getItem_img();
			String category = dto.getCategory();
			String item_id = dto.getItem_id();
			String item_name = dto.getItem_name();
			String item_info = dto.getItem_info();
			int price = dto.getPrice();
			//int score = dto.getScore();
			int shipping_Level = dto.getShipping_Level();

			int result = -1;

			try {
				Context ctx = new InitialContext();
				DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

				// data -> DB
				String query = "INSERT INTO coopang_items ( item_num, item_img, category, item_id, item_name, price, item_info, shipping_Level)"
						+ " VALUES ( item_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

				try (Connection conn = dataFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

					ps.setString(1, item_img);
					ps.setString(2, category);
					ps.setString(3, item_id);
					ps.setString(4, item_name);
					ps.setInt(5, price);
					ps.setString(6, item_info);
					//ps.setInt(6, score);
					ps.setInt(7, shipping_Level);

					result = ps.executeUpdate();

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("/item/service/dao - insert : " + result);
			return result;
		}
	
		//modify
		public int modifyDB(ItemDTO dto) {

			int item_num = dto.getItem_num();
			String item_img = dto.getItem_img();
			String category = dto.getCategory();
			String item_id =dto.getItem_id();
			String item_name = dto.getItem_name();
			int price = dto.getPrice();
			String item_info = dto.getItem_info();
			int score = dto.getScore();
			Date setTime = dto.getSetTime();
			int shipping_Level = dto.getShipping_Level();

			int result = -1;

			try {
				Context ctx = new InitialContext();
				DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

				// data -> DB
				String query = 
						  "UPDATE coopang_items SET "
								  + "item_img = ?, "
								  + "category = ?, "
								  + "item_id = ?, "
								  + "item_name = ?, "
								  + "price = ?, "
								  + "item_info = ?,"
								  + "score = ?, "
								  + "setTime = ?, "
								  + "shipping_Level = ? "
								  + "WHERE item_num = ? ";

				try (Connection conn = dataFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

					ps.setString(1, item_img);
					ps.setString(2, category);
					ps.setString(3, item_id);
					ps.setString(4, item_name);
					ps.setInt(5, price);
					ps.setString(6, item_info);
					ps.setInt(7, score);
					ps.setDate(8, setTime);
					ps.setInt(9, shipping_Level);
					ps.setInt(10, item_num);
					
					result = ps.executeUpdate();

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("/item/service/dao - modify : " + result);
			return result;

		}
		
//		//delete
		public int deleteDB(ItemDTO dto) {

			int num = dto.getItem_num();

			int result = -1;

			try {
				Context ctx = new InitialContext();
				DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

				// data -> DB
				String query = 
						  "DELETE FROM coopang_items WHERE item_num = ?";

				try (Connection conn = dataFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
					
					ps.setInt(1, num);
					result = ps.executeUpdate();

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("/user/service/dao - delete : " + result);
			return result;

		}
}
