<%@page import="com.naver.LoginDTO"%>
<%@page import="com.naver.MemberDTO"%>
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
	<h1>회원 정보 자세히 보기</h1>
	ID : ${dto.id}
	<br> Name : ${dto.name}
	<br> Age : ${dto.age}
	<br>



	<a href="updateui.bo?id=${dto.id}">수정</a> |
	<a href="delete.bo?id=${dto.id}">삭제</a> |
	<a href="select.bo">목록</a>|
	
	
</body>
</html>