<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 페이지</title>
<link rel = "stylesheet" href="/apple/static/css/style.css">
</head>
<body>
<header>
<h1>게시글 상세 페이지</h1>
</header>
<hr/>
<nav>
		<a href="/apple/member?cmd=loginform">로그인</a>
		<a href="/apple/member?cmd=joinform">회원가입</a>
</nav>
<section>
		<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>			
			<th>제목</th>
			<th>내용</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<tr>
			<th>1</th>
			<th>ssar</th>
			<th>방가</th>
			<th>오늘이욤</th>
			<th> <a href="/apple/post?cmd=updateForm&id=1"></a>수정</a></th>
			<th><a href="/apple/post?cmd=deleteProc&id=1"></a>삭제</a></th>
		</tr>
	</table>
</section>
<footer>
<p>Created By Apple.</p>
<p>부산진구 중앙대로 708</p>
</footer>
</body>
</html> 