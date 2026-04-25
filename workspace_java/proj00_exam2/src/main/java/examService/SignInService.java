package examService;

import java.util.List;

import examDAO.SignInDAO;
import examDTO.SignInDTO;

public class SignInService {

	
	SignInDAO siDAO = new SignInDAO();
	
	public List select(SignInDTO siDTO){
		return siDAO.selectDB(siDTO);
	}

	public int insert(SignInDTO siDTO){
		return siDAO.insertDB(siDTO);
	}
	
	public int update(SignInDTO siDTO){
		return siDAO.updateDB(siDTO);
	}
	
	// 선택 삭제 생각 통일성(협업 확장성 고려해서 '굳이' DTO로 전송 )
	public void delete(List<SignInDTO> list){
		for( SignInDTO sidto : list) {
			SignInDAO siDAO = new SignInDAO();
			siDAO.deleteDB(sidto);
		}
	}
	
	
	

}
