package todo.service;

import java.util.List;

import todo.DAO.TodoDAO;
import todo.DTO.TodoDTO;

public class TodoService {
	
	TodoDAO todoDAO = new TodoDAO();
	
	// Select
	public List getList() {
		TodoDAO todoDAO = new TodoDAO();
		List list = todoDAO.selectAll();
		return list;
	}
	
	// Select One
	public TodoDTO getTodo(int todo_id) {
		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.selectOne(todo_id);
	}
	
	// Insert
	public int addTodo(TodoDTO todoDTO) { // 왜 int 반환 했는지 사용 용도?
		
		return todoDAO.insertTodo(todoDTO);
	} 
	
	// Update
	public int updateTodo(TodoDTO todoDTO) { 
		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.updateTodo(todoDTO);
	}
}
