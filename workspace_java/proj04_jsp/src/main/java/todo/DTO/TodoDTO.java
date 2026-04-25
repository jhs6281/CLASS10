package todo.DTO;

import java.sql.Date;

//DTO : Data Transfer Object
public class TodoDTO {

	private int todo_id;
	private Date duedate;
	private int done;
	private String content;
	private Date ctime;

	public int getTodo_id() {
		return this.todo_id;
	}

	public Date getTodo_duedate() {
		return this.duedate;
	}

	public int getTodo_done() {
		return this.done;
	}

	public String getContent() {
		System.out.println("DTO get Content 실행");
		return this.content;
	}

	public Date getTodo_ctime() {
		return this.ctime;
	}
	

	public void setTodo_id(int todo_id) {
		this.todo_id = todo_id;
	} //
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public void setDone(int done) {
		this.done = done;
	}
	public void setContent(String content) {
		System.out.println("DTO set Content 실행");
		this.content = content;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	
	@Override
	public String toString() {
		return "TodoDTO [todo_id=" + todo_id + ", duedate=" + duedate + ", done=" + done + ", content=" + content
				+ ", ctime=" + ctime + "]";
	}

}
