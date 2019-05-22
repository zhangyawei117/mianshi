<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录页面</title>
	</head>
	<body>
		<form action="LoginServlet" method="post">
			用户名：<input type="text" name="username" size="30px"/><br />
			密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" size="30px"/><br />
			验证码：<input type="text" name="verifyCode" size="12px"/>
			<!-- 图片的路径：相对路径(带/，相对的是当前主机；不带/，相对当前文件) -->
			<input type="submit" value="登录" />
		</form>
	</body>
</html>