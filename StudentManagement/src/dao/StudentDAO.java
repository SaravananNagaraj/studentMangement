package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DBConnection;
import model.Student;

public class StudentDAO implements StudentDAOInterface {

	@Override
	public boolean insertStudent(Student s) {
		boolean flag = false;
		try {
			Connection con = DBConnection.createConnection();
			String query = "Insert into student_details(sname, clgname, address, percentage) value(?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, s.getSname());
			pst.setString(2, s.getClg_name());
			pst.setString(3, s.getStudaddress());
			pst.setDouble(4, s.getPercentage());
			pst.executeUpdate();
			
			flag = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean update(int roll_no, String update, int ch, Student s, double per) {
		int choice = ch;
		boolean flag = false;
		try {
			if(choice==1) {
				Connection con = DBConnection.createConnection();
				String query = "update student_details set sname=? where rollnum=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, update);
				ps.setInt(2, roll_no);
				ps.executeUpdate();
				flag = true;
			}
			if(choice==2) {
				Connection con = DBConnection.createConnection();
				String query = "update student_details set address=? where rollnum=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, update);
				ps.setInt(2, roll_no);
				ps.executeUpdate();
				flag = true;
			}
			if(choice==3) {
				Connection con = DBConnection.createConnection();
				String query = "update student_details set percentage=? where rollnum=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, update);
				ps.setInt(2, roll_no);
				ps.executeUpdate();
				flag = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int roll_no) {
		
		boolean flag = false;
		try {
			Connection con = DBConnection.createConnection();
			String query = "delete from student_details where rollnum=" + roll_no;
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeUpdate();
			
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public void showAllStudennt() {
		
		try {
			Connection con = DBConnection.createConnection();
			String query = "select * from student_details";
			Statement st = con.createStatement();	
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println("--------------------------------------");
				System.out.println("Roll number : " + rs.getInt(1) + "\n" +
						"Student name : " + rs.getString(2) + "\n" +
						"College name : " + rs.getString(3) + "\n" +
						"Address : " + rs.getString(4) +"\n" +
						"Percentage : " + rs.getDouble(5));
				System.out.println("--------------------------------------");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean showStudentById(int roll_no) {
		
		try {
			Connection con = DBConnection.createConnection();
			String query = "select * from student_details where rollnum=" +roll_no;
			Statement st = con.createStatement();	
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Roll number : " + rs.getInt(1) + "\n" +
						"Student name : " + rs.getString(2) + "\n" +
						"College name : " + rs.getString(3) + "\n" +
						"Address : " + rs.getString(4) +"\n" +
						"Percentage : " + rs.getDouble(5));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

}
