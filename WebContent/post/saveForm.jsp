<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 페이지</title>
<link rel = "stylesheet" href="/apple/static/css/style.css">
</head>
<body>
<header>
<h1>게시글 작성 페이지</h1>
</header>
<hr/>
<nav>
		<a href="/apple/member?cmd=loginform">로그인</a>
		<a href="/apple/member?cmd=joinform">회원가입</a>
</nav>
<section>
<form action="/apple/post?cmd=saveProc" method="post">
	<table border="1">
		<tr>
			<th>제목</th>
			<th><input type="text" name="title"/></th>
			</tr>
			<tr>
			<th>내용</th>
			<th><textarea  rows="3"  cols ="22" name="content"></textarea></th>
		</tr>
	</table>
	<button>글쓰기 완료</button>
</form>
</section>
<footer>
<p>Created By Apple.</p>
<p>부산진구 중앙대로 708</p>
</footer>
</body>
</html> 