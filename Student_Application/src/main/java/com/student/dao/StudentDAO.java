
package com.student.dao;

import java.util.List;

import com.student.dto.Student;

//create and interface with all the CRUD operations as methods

public interface StudentDAO {

	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	public Student getStudent(String mail_id,String password);
	public Student getStudent(long phone,String mail_id);
	public List<Student> getStudent();
}