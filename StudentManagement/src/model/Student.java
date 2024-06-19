package model;

public class Student {
	
	private int rollno;
	private String sname;
	private String clg_name;
	private String studaddress;
	private double percentage;
	
	public Student(){
		
	}
	public Student(String sname, String clg_name, String studaddress, double percentage) {
		super();
		this.sname = sname;
		this.clg_name = clg_name;
		this.studaddress = studaddress;
		this.percentage = percentage;
	}
	public Student(int rollno, String sname, String clg_name, String studaddress, double percentage) {
		super();
		this.rollno = rollno;
		this.sname = sname;
		this.clg_name = clg_name;
		this.studaddress = studaddress;
		this.percentage = percentage;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getClg_name() {
		return clg_name;
	}
	public void setClg_name(String clg_name) {
		this.clg_name = clg_name;
	}
	public String getStudaddress() {
		return studaddress;
	}
	public void setStudaddress(String studaddress) {
		this.studaddress = studaddress;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + ", clg_name=" + clg_name + ", studaddress="
				+ studaddress + ", percentage=" + percentage + "]";
	}
}
