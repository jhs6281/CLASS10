package user.service;

import java.util.List;

import user.dao.UserDAO;
import user.dto.UserDTO;

public class UserService {
	
	UserDAO dao = new UserDAO();
	
	// 회원가입
	public int insert(UserDTO dto){
		return dao.insertDB(dto);
	}

	// select
	public List select(UserDTO dto){
		System.out.println("/user/Service - select");
		return dao.selectDB(dto);
	}
	
	public UserDTO modify(UserDTO dto){
		System.out.println("/user/Service - modify");
		return dao.modifyDB(dto);
	}
	
	public int delete(UserDTO dto){
		System.out.println("/user/Service - delete");
		return dao.deleteDB(dto);
	}
	
}
