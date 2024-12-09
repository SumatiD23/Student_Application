<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Forgot Pin</title>
<style>
.heading { 
 color: #000080; 
} 
 
.sub { 
 color: #1e90ff; 
} 
</style>
</head>
<body bgcolor='#add8e6'> 
 <div align="center"> 
  <h1 class="heading">Pentagon Space</h1> 
  <h3 class="sub">Forgot Pin</h3> 
  <form action="forgotpin" method="post"> 
  <%String failure=(String)request.getAttribute("failure");
if(failure!=null){%>
<h3><%=failure %></h3>
<%} %>

<%String mismatch=(String)request.getAttribute("mismatch");
if(mismatch!=null){%>
<h3><%=mismatch%></h3>
<%}%>
   <table> 
    <tr> 
     <td><b>Enter your email:</b></td> 
     <td><input type="text" name="mailid"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
<td><br></td> 
    </tr> 
    <tr> 
     <td><b>Enter the Phone number:</b></td> 
     <td><input type="tel" name="phone"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    <tr> 
     <td><b>Password</b></td> 
     <td><input type="password" name="password"></td> 
    </tr> 
    <tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    <tr> 
     <td><b>Confirm password: </b></td> 
     <td><input type="password" name="confirmpass"></td> 
    </tr><tr> 
     <td><br></td> 
     <td><br></td> 
    </tr> 
    <tr>
     <td><input type="submit" value="change password"></td> 
    </tr> 
   </table> 
  </form> 
 </div> 
</body> 
</html>