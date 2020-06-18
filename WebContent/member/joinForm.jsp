<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel = "stylesheet" href="/apple/static/css/style.css">
</head>
<body>
<header>
<h1>회원가입 페이지</h1>
</header>
<hr/>
<%@include file= "/include/nav.jsp"  %>
<section>
<form action="/apple/member?cmd=joinProc" method="post">
	<table border="1">
		<tr>
			<th>유저네임</th>
			<th><input type="text" name="username"/></th>
			</tr>
			<tr>
			<th>패스워드</th>
			<th><input type="password" name = "password"/></th>
		</tr>
		<tr>
		<th>이메일</th>
		<th><input type="email" name = "email"/></th>
		</tr>
	</table>
	<button>회원가입 완료</button>
</form>
</section>
<footer>
<p>Created By Apple.</p>
<p>부산진구 중앙대로 708</p>
</footer>
</body>
</html> 