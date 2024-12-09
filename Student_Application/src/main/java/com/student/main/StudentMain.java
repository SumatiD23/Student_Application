package com.student.main;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.student.dao.StudentDAO;
import com.student.dao.StudentiDAOimplementation;
import com.student.dto.Student;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Student s = new Student();
		// Creating studentimplem reference to interface object so that the overriden
		// methods can be executed
		StudentDAO sdao = new StudentiDAOimplementation();

		System.out.println("Enter 1 for inserting data");
		System.out.println("Enter 2 for deleting a data based on id");
		System.out.println("Enter 3 for getting the data in the form of list");
		System.out.println("Enter 4 for getting data through mail_id and password");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Enter student name");
			String name = sc.next();
			s.setName(name);// to set the user given value to the POJO class using setters

			// or you can use s.setName(sc.next()); //takes input and sets value directly

			System.out.println("Enter phone");
			s.setPhone(sc.nextLong()); // method 2 setting to all the following inputs

			System.out.println("Enter mail id");
			s.setMailid(sc.next());

			System.out.println("Enter branch");
			s.setBranch(sc.next());

			System.out.println("Enter location");
			s.setLocation(sc.next());

			System.out.println("Enter password");
			String pass = sc.next();
			System.out.println("Confirm password");
			String confirmpass = sc.next();

			if (pass.equals(confirmpass)) {
				s.setPassword(pass);
				boolean result = sdao.insertStudent(s);
				if (result) {
					System.out.println("Data added successfully");
				} else {
					System.out.println("Failed to add data");
				}
			}

			else {
				System.out.println("Password mismatch");
			}

		} else if (choice == 2) {
			System.out.println("Enter the id of the data to be removed");
			int del_id = sc.nextInt();
			s.setId(del_id);
			boolean result = sdao.deleteStudent(s);
			if (result) {
				System.out.println("Data deleted succesfully");
			} else {
				System.out.println("Failed to delete data");
			}

		}
		else if(choice ==3)
		{
			List<Student> studentsList= sdao.getStudent();
					Iterator<Student> it=studentsList.iterator();
					while(it.hasNext())
					{
						s=it.next();
						System.out.println(s);
					}
			
		}
		else if(choice ==4)
		{
			System.out.println("Enter the mail_id");
			String maill=sc.next();
			System.out.println("Enter the password");
			String pwd=sc.next();
			Student s1=sdao.getStudent(maill, pwd);
			System.out.println(s1);
			
		}
	}

}

