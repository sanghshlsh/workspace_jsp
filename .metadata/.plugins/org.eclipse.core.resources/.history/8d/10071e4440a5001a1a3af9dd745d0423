<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원목록</h1>
<a href=${empty login?'loginui.bo':'logout.bo'}>${empty login?'로그인':'로그아웃'}</a><br>
<a href="insertui.bo">회원등록</a>

<h3>전체 회원 목록</h3>
<c:forEach items="${list}" var="dto">
<a href="selectById.bo?id=${dto.id}">
${dto}</a><br>
</c:forEach>




</body>
</html>