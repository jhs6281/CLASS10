package loginCheck;

public class CheckDTO {

	Integer empno;
	String ename;
	String job;
	Integer mgr;
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	
	@Override
	public String toString() {
		return "CheckDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + "]";
	}
	
}
