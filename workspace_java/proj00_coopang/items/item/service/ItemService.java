package item.service;

import java.util.List;

import item.dao.ItemDAO;
import item.dto.ItemDTO;

public class ItemService {
	ItemDAO dao = new ItemDAO();

	 // insert
	public int insert(ItemDTO dto) {
		System.out.println("/item/Service - insert" + dto);
		return dao.insertDB(dto);
	}

	// select
	public List select(ItemDTO dto) {
		System.out.println("/item/Service - select" + dto);
		return dao.selectDB(dto);
	}

	public int modify(ItemDTO dto) {
		System.out.println("/item/Service - modify");
		return dao.modifyDB(dto);
	}

	public int delete(ItemDTO dto) {
		System.out.println("/user/Service - delete");
		return dao.deleteDB(dto);
	}
}
