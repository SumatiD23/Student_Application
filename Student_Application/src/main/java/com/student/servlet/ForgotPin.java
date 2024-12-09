package com.student.servlet;

import com.student.dao.*;
import com.student.dto.Student;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forgotpin")
public class ForgotPin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//collect data from user
		String phone=req.getParameter("phone");
		String mail_id=req.getParameter("mailid");
		String password=req.getParameter("password");
		String confirm_password=req.getParameter("confirmpass");
		
		//chnage datattypes
		long phoneNumber=Long.parseLong(phone);
		
		//jdbc implemmetation
		PrintWriter out=resp.getWriter();
		StudentDAO sdao=new StudentiDAOimplementation();
		Student s=sdao.getStudent(phoneNumber, mail_id);
		
		if(s!=null && password.equals(confirm_password)) {
			
			s.setName(s.getName());
			s.setMailid(s.getMailid());
			s.setPhone(s.getPhone());
			s.setLocation(s.getLocation());
			s.setBranch(s.getBranch());
			s.setId(s.getId());
			s.setPassword(password);
			
			boolean result=sdao.updateStudent(s);
			if(result) {
				//out.println("<h1> Pin updated successfully</h1>");
				req.setAttribute("success", s);
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
			}
			else {
				//out.println("<h1> Pin updation unsuccessful</h1>");
				req.setAttribute("failure","failed to update password");
				RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			//out.println("<h1> Password and confirm password mismatch</h1>");
			req.setAttribute("mismatch","Password mismatched");
			RequestDispatcher rd=req.getRequestDispatcher("Forgotpin.jsp");
			rd.forward(req, resp);
		}

}
}