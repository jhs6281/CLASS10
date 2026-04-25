package emp;

import java.sql.Date;

public class EmpDTO {

		Integer empno;
		String ename;
		String job;
		Integer mgr;
		Date hireDate;
		Integer sal;
		Integer comm;
		Integer deptno;
		
		
		public String getJob() {
			return job;
		}
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
		public void setJob(String job) {
			this.job = job;
		}
		
		public Integer getMgr() {
			return mgr;
		}
		public void setMgr(Integer mgr) {
			this.mgr = mgr;
		}
		
		public Date getHireDate() {
			return hireDate;
		}
		public void setHireDate(Date hireDate) {
			this.hireDate = hireDate;
		}
		
		public Integer getSal() {
			return sal;
		}
		public void setSal(Integer sal) {
			this.sal = sal;
		}
		
		public Integer getComm() {
			return comm;
		}
		public void setComm(Integer comm) {
			this.comm = comm;
		}
		
		public Integer getDeptno() {
			return deptno;
		}
		
		public void setDeptno(Integer deptno) {
			this.deptno = deptno;
		}
		@Override
		public String toString() {
			return "EmpDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hireDate="
					+ hireDate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
		}

}
