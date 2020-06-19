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
<%@include file= "/include/nav.jsp"  %>
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
			<th>${detailDto.postDto.id}</th>
			<th>${detailDto.username}</th>
			<th>${detailDto.postDto.title}</th>
			<th>${detailDto.postDto.content}</th>
<%-- 		<c:choose> --%>
<%-- 			<c:when test="${sessionScope.principal.id != Member.username}"> --%>
			<th> <a href="/apple/post?cmd=updateForm&id=1">수정</a></th>
			<th><a href="/apple/post?cmd=deleteProc&id=1">삭제</a></th>		
<%-- 			</c:when>	 --%>
<%-- 			<c:otherwise> --%>
<!-- 			<th>권한X</th> -->
<!-- 			<th>권한X</th> -->
<%-- 			</c:otherwise> --%>
<%-- 			</c:choose> --%>


			
<!-- 			<th> <a href="/apple/post?cmd=updateForm&id=1">수정</a></th> -->
<!-- 			<th><a href="/apple/post?cmd=deleteProc&id=1">삭제</a></th> -->
		</tr>
	</table>
</section>
<footer>
<p>Created By Apple.</p>
<p>부산진구 중앙대로 708</p>
</footer>
</body>
</html> 