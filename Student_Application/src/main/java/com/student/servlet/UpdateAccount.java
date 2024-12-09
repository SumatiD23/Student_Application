package com.student.servlet;

import java.io.IOException;

import com.student.dao.StudentDAO;
import com.student.dao.StudentiDAOimplementation;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession(false);
	Student s=(Student)session.getAttribute("student");
	String name=req.getParameter("name");
	String mail=req.getParameter("mail");
	String location=req.getParameter("location");
	String branch=req.getParameter("branch");
	String phonenumber=req.getParameter("pnumber");
	long phone=Long.parseLong(phonenumber);

	//Student s=new Student();
	StudentDAO sdao=new StudentiDAOimplementation();
		
		s.setName(name);
		s.setPhone(phone);
		s.setMailid(mail);
		s.setBranch(branch);
		s.setLocation(location);
		
		
		boolean result=sdao.updateStudent(s);
		if(result) {
			req.setAttribute("success", "Account Updated successfully");
			RequestDispatcher rd=req.getRequestDispatcher("UpdateAccount.jsp");
			rd.forward(req,resp);
			//out.println("<h1>Data added successfully</h1>");
		}
		else {
			//out.println("<h1>Data failed to add</h1>");
			req.setAttribute("failure", "Account updation failed");
			RequestDispatcher rd=req.getRequestDispatcher("UpdateAccount.jsp");
			rd.forward(req,resp);
		}
}
}
