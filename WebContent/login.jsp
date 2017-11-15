<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到宜企邦登录界面</title>
<link rel="stylesheet" href="bootstrap/dist/css/bootstrap.min.css">
<script src="JQuery/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="css/backgroundLogin.css">
</head>
<body>
	<div class="container">
		<div class="logo"><img src="img/logo.png"></div>
		<div class="user">
			用户名:<br><input type="text" placeholder="请输入用户名">
		</div>
		<div class="pwd">
			密&nbsp;&nbsp;&nbsp;码:<br><input type="password" placeholder="请输入密码">
		</div>
		<div class="code">
			验证码:<br>
			<img src="validate.jsp" alt="请点击刷新验证码" onclick="this.src='validate.jsp?rnd=' + Math.random();">
			<input type="text" placeholder="点击刷新验证码">
		</div>
		<div class="btn1">
			<button class="successBtn">&nbsp;&nbsp;&nbsp;&nbsp;登录&nbsp;&nbsp;&nbsp;&nbsp;</button>
			<button class="failBtn">忘记密码</button>
		</div>
	</div>
</body>
</html>