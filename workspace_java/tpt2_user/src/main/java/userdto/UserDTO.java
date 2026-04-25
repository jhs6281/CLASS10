package userdto;

import oracle.sql.DATE;

public class UserDTO {

	int empno;
	String ename;
	String email;
	String id;
	String pw;
	int grade;
	Integer mgr;
	DATE hireDate;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public DATE getHireDate() {
		return hireDate;
	}
	public void setHireDate(DATE hireDate) {
		this.hireDate = hireDate;
	}
	@Override
	public String toString() {
		return "UserDTO [empno=" + empno + ", ename=" + ename + ", email=" + email + ", id=" + id + ", pw=" + pw
				+ ", grade=" + grade + ", mgr=" + mgr + ", hireDate=" + hireDate + "]";
	}
	
	
}
