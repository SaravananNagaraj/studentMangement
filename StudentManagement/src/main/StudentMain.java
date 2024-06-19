package main;

import java.util.Scanner;

import dao.StudentDAO;
import dao.StudentDAOInterface;
import model.Student;

public class StudentMain {
	public static void main(String[] args) {
		
		StudentDAOInterface dao = new StudentDAO();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n1.Add student" + "\n2.Show all student" + 
								"\n3.Get student based on roll number" +
								"\n4.Delete student" +
								"\n5.Update student" + "\n6.Exit");
			System.out.print("Enter your choice : ");
			int ch = scanner.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Add student \n");
				System.out.print("Enter student name : ");
				String name = scanner.next();
				System.out.print("Enter college name : ");
				String clgName = scanner.next();
				System.out.print("Enter the address : ");
				String address = scanner.next();
				System.out.print("Enter the percentage : ");	
				double perg = scanner.nextDouble();
				
				Student st = new Student(name, clgName, address, perg);
				boolean ans = dao.insertStudent(st);
				
				if(ans) {
					System.out.println("Record inserted successfully !!");
				}
				else 
					System.out.println("Something went wrong, pleas try again...");
				break;
			case 2:
				System.out.println("Show all student\n");
				dao.showAllStudennt();
				break;
			case 3:
				System.out.println("Get student based on roll number\n");
				System.out.print("Enter the roll number : " + "\n");
				int roll_no = scanner.nextInt();
				boolean f = dao.showStudentById(roll_no);
				if(!f) {
					System.out.println("Student id is not available...");
				}
				break;
			case 4:
				System.out.println("Delete student\n");
				System.out.println("Enter the roll number : ");
				int roll = scanner.nextInt();
				boolean rs =dao.delete(roll);
				if(rs) 
					System.out.println("Student detail deleted successfully...");
				else
					System.out.println("Something went wrong!!");
				break;
			case 5:
				System.out.println("Update student");
				System.out.println("\n1.Update student name" + "\n2.Update address" + "\n3.Update student percentage");
				System.out.println("Enter the choice : ");
				int choice = scanner.nextInt();
				if(choice==1) {
					System.out.println("Enter the roll number : ");
					int rno = scanner.nextInt();
					System.out.println("Update student name : ");
					String sname = scanner.next();
					Student std = new Student();
					std.setSname(sname);
					boolean flag = dao.update(rno, sname, choice, std, (Double) null);
					if(flag) 
						System.out.println("Student name updated successfully...");
					else
						System.out.println("Something went wrong!!");
				}
				if(choice==2) {
					System.out.println("Enter the roll number : ");
					int rno = scanner.nextInt();
					System.out.println("Update the address : ");
					String saddress = scanner.next();
					Student std = new Student();
					std.setStudaddress(saddress);
					boolean flag = dao.update(rno, saddress, choice, std, (Double) null);
					if(flag) 
						System.out.println("Address updated successfully...");
					else
						System.out.println("Something went wrong!!");
				}
				if(choice==3) {
					System.out.println("Enter the roll number : ");
					int rno = scanner.nextInt();
					System.out.println("Update the percentage : ");
					double per = scanner.nextDouble();
					Student std = new Student();
					std.setPercentage(per);
					boolean flag = dao.update(rno, null, choice, std, per);
					if(flag) 
						System.out.println("Percentage updated successfully...");
					else
						System.out.println("Something went wrong!!");
				}
				break;
			case 6:
				System.out.println("Thanks for using !!");
				System.exit(0);
				
			default:
				System.out.println("Please enter valid choice...");
			}
		}
		
	}
}
