<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

현재 시각: 2020년05월25일오후2시08분
<!-- 정적인 코드를 사용했기에 새로고침을 해도 변하지 않는다. -->
<hr>
<%
	Date d = new Date();
	out.print(d);
	//다이나믹 웹 프로그래밍
%>
</body>
</html>