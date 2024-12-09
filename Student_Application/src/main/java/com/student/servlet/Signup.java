package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.StudentDAO;
import com.student.dao.StudentiDAOimplementation;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		
		//collecting data from user
		String name=req.getParameter("name");
		String phonenumber=req.getParameter("pnumber");
		String email=req.getParameter("email");
		String branch=req.getParameter("branch");
		String location =req.getParameter("location");
		String password=req.getParameter("password");
		String confirm_pass=req.getParameter("confirmpass");
		
		//converting necessary dattatypes
		long phone=Long.parseLong(phonenumber);
		//PrintWriter out;
		//out = resp.getWriter();
		
		
		Student s=new Student();
		StudentDAO sdao=new StudentiDAOimplementation();
		if(password.equals(confirm_pass)) {

			
			s.setName(name);
			s.setPhone(phone);
			s.setMailid(email);
			s.setBranch(branch);
			s.setLocation(location);
			s.setPassword(password);
			
			//JDBC Implememnation
			boolean result=sdao.insertStudent(s);
			if(result) {
				req.setAttribute("success", "Signup successful");
				RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
				rd.forward(req,resp);
				//out.println("<h1>Data added successfully</h1>");
			}
			else {
				//out.println("<h1>Data failed to add</h1>");
				req.setAttribute("failure", "Signup failed");
				RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
				rd.forward(req,resp);
			}
			
		}
	}
	
}