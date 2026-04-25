package user.dto;

import java.sql.Date;

public class UserDTO {

	int user_num;
	String user_nickname;
	String user_email;
	String user_name;
	String user_tel;
	String user_id;
	String user_pw;
	String user_addr;
	Date hiredate;
	int grade;
	
	public int getUser_num() {
		return user_num;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "UserDTO [user_num=" + user_num + ", user_nickname=" + user_nickname + ", user_email=" + user_email
				+ ", user_name=" + user_name + ", user_tel=" + user_tel + ", user_id=" + user_id + ", user_pw="
				+ user_pw + ", user_addr=" + user_addr + ", hiredate=" + hiredate + ", grade=" + grade
				+ "]";
	}
	

	
	
	
	
}
