package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.*;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		PrintWriter out=resp.getWriter();
		//collect data from user
		String username=req.getParameter("mail");
		String passwword=req.getParameter("password");
		
		//jdbc implementation
		StudentDAO sdao=new StudentiDAOimplementation();
		Student s=sdao.getStudent(username, passwword);
		if(s!=null) {
			session.setAttribute("student",s);//using session
			//req.setAttribute("student",s);
			RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			rd.forward(req,resp);
		}
		else {
			req.setAttribute("failure","failed to login");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req,resp);
		}
	}	
}