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

<%--
<a href=${empty login?'loginui.bo':'logout.bo'}>${empty login?'로그인':'로그아웃'}</a><br>
3항연산자를 c if문을 이용 변환하라 / choose when 사용또한 가능
<c:choose>
<c:when test="${empty login }"><a href="loginui.bo">로그인</a></c:when>
<c:otherwise><a href="logout.bo">로그아웃</a></c:otherwise>
</c:choose>
 --%>
 <c:if test="${empty login }">
<a href="loginui.bo">
로그인
</a> 
 </c:if>
 <c:if test="${!empty login }">
<a href="logout.bo">
로그아웃
</a> 
 </c:if>
<br>


<a href="insertui.bo">회원등록</a>

<h3>전체 회원 목록</h3>
<c:forEach items="${list}" var="dto">
<a href="selectById.bo?id=${dto.id}">
${dto}</a><br>
</c:forEach>




</body>
</html>