package model;

public class Department {

	String deptname;
	String deptemail;
	String deptlocation;
	public Department(String deptname, String deptemail, String deptlocation) {
		super();
		this.deptname = deptname;
		this.deptemail = deptemail;
		this.deptlocation = deptlocation;
	}
	@Override
	public String toString() {
		return "Department [deptname=" + deptname + ", deptemail=" + deptemail + ", deptlocation=" + deptlocation + "]";
	}
	
}
