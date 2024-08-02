<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style type="text/css">
.container{
background: red;
position: absolute;
top: 50%;
left: 50%;
transform: translate(-50%,-50%);
padding: 30px;
border-color: yellow;
box-shadow: green;

}
.field{
	padding: 10px;
}
.btn{
	display: block;
	margin: auto;
	width: 100px;
	border-radius: 20px;
	color: green;
	background-color: yellow;
	text-align: center;
}
.title{
text-align: center;

}
</style>
</head>
<body>
<div class="container">
<form action="login" method="post">
	<div class="title">
		<h1><b>Login</b> </h1>
	</div>
	<div class="field">
		<label>user name:-</label>
		<input type="text" name="username">
	</div>
	<div class="field">
		<label>password:-</label>
		<input type="password" name="pass">
	</div>
	<div>
	<input type="submit" name="login" value="login" class="btn">
	</div>
	<div><a href="forgetpassword.jsp" style="">Forget password</a></div>
	<div><a href="Register.jsp">register here</a></div>
	
		
	
	
</form>
</div>
</body>
</html>