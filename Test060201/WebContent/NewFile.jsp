<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>본문입니다.</h1>
	
	<%@include file="part1.jsp"%>
	<hr>
	
	<jsp:include page="part2.jsp"></jsp:include>
	<hr>
	<jsp:include page="part3.jsp">
		<jsp:param value="teacheryo" name="id"/>
		<jsp:param value="kim" name="name"/>
		<jsp:param value="안녕" name="hello"/>
	</jsp:include>
	<%-- <jsp: > </jsp:> 넘겨주는데이터가있는형태 내부에에 <jsp:param>을 사용한다 --%>

</body>
</html>