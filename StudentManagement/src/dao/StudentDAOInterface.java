package dao;

import model.Student;

public interface StudentDAOInterface {
	
	public boolean insertStudent(Student s);
	public boolean update(int roll_no, String update, int ch, Student s, double per);
	public boolean delete(int roll_no);
	public void showAllStudennt();
	public boolean showStudentById(int roll_no);
	

}
