package todo.service;

import java.util.List;

import todo.DAO.TodoDAO;
import todo.DTO.TodoDTO;

public class TodoService {
	
	
	
	public List getList() {
		
		// TodoDAO의 selectAll을 호출하고
		// 그 List를 return 해주세요
		
		TodoDAO todoDAO = new TodoDAO();
		List list = todoDAO.selectAll();
		return list;
		
	}
	
	public TodoDTO getTodo(int todo_id) {
		
		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.selectOne(todo_id);
		
	}
}
