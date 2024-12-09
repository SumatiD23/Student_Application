<%@page import="com.student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
<head> 
<style> 
.heading { 
color: #000080; 
} 
.sub { 
color: #1e90ff; 
} 
.success{
color:green;
}
</style> 
</head> 
<body bgcolor='#add8e6'> 
<div align="center"> 
<h1 class="heading">Pentagon Space</h1> 
<h3 class="sub">Login</h3> 
<form action="UpdateAccount" method="post"> 
<%Student s=(Student)session.getAttribute("student");%>
<%String success=(String)request.getAttribute("success");
if(success!=null){%>
<h3 class="success"><%=success%></h3>
<%} %>
<%String failure=(String)request.getAttribute("failure");
if(failure!=null){%>
<h3><%=failure %></h3>
<%} %>
<br> 
   <table> 
   <td><b>Enter name to update:</b></td> 
     <td><input type="text" name="name" value="<%= s.getName()%>"
required="required"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    
   
    <tr> 
     <td><b>Enter  mail ID to update:</b></td> 
     <td><input type="email" name="mail" value="<%=s.getMailid() %>"
required="required"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    
    <td><b>Enter phone number to update:</b></td> 
     <td><input type="tel" name="pnumber" value="<%=s.getPhone() %>"
required="required"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    <td><b>Enter the location to update:</b></td> 
     <td><input type="text" name="location" value="<%= s.getLocation()%>"
required="required"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    <td><b>Enter the branch to update:</b></td> 
     <td><input type="text" name="branch" value="<%=s.getBranch() %>"
required="required"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    
    <tr> 
     <td><input type="submit" value="UpdateAccount"></td> 
<td><a href="dashboard.jsp">Back</a></td> 
</tr> 
<tr> 
<td><br></td> 
<td><br></td> 
</tr> 
</table> 
Don't have a account?<a href="Signup.html">SignUp</a>  
</form> 
</div> 
</body> 
</html>