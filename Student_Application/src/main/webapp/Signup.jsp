<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Signup.css">
    <title>Sign Up</title>
    <style>
    body{
    background-color: hsl(190, 76%, 87%);;
}

.container{
    border: 2px solid black;
}

h2{
    color: purple;
}
h2,h3{
   margin-left: 50px;
}
.signup{
    
   padding: 80px auto;
   margin-top: 100px ;
   margin-left:600px ;
}

input{
padding: 4px;
margin: 5px;
}

#btn1,#btn2{   
     margin-top: 30px;
    margin-left:30px;
    border-radius: 7px;
    padding: 5px;
}
#btn1{
    background-color: hsla(5, 90%, 51%, 1) ;
}

#btn2{
    background-color:hsla(148, 78%, 71%);
}
    </style>
</head>
<body>
    <div class="container">
    <div class="signup">
        <h2>Pentagon Space</h2>
        <h3>Application Form</h3>
        <%String success=(String)request.getAttribute("success");
        if(success!=null){%>
        <h3 class="success"><%=success %></h3>
        <%} %>
         <%String failure=(String)request.getAttribute("failure");
        if(failure!=null){%>
        <h3 class="failure"><%=failure %></h3>
        <%} %>
        <form action="signup" method="post"  class="form" >
            Enter Your Name:
            <input type="text" name="name" placeholder="Name">              <br>
            Enter Your  Number:
            <input type="number" name="pnumber" placeholder="9956231XXX">   <br>
            Enter Your Email-ID: 
            <input type="email" name="email" placeholder="example123@gmail.com">    <br>
            Enter Your Branch:
            <input type="text" name="branch" id="" placeholder="ex:CSE">    <br>
            Enter Yoyr Location:
            <input type="text" name="location" placeholder="Bangalore"> <br>
            Enter Password:
            <input type="password" name="password" >     <br>
            Conform Password:
            <input type="password" name="confirmpass" >     <br>
            <input type="button" name="reset" value="Reset" id="btn1">    
            <input type="submit" name="Create Account" value="Create Account" id="btn2">      <br>
            <h4>Already have an Account? <a href="Login.html">Login</a></h4>
        </form>
    </div>
</div>
</body>
</html>