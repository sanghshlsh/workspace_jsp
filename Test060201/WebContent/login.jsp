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
	<form action="NewFile8.jsp" method="post">
	Id: <input name="id"><br><%--javaBeain 클래스의 멤버변수와 name이 동일해야 한다. --%>
	PW: <input name="pw"><br><%--javaBeain 클래스의 멤버변수와 name이 동일해야 한다. --%>
	<input type="submit" value="login">
	
	
	</form>

</body>
</html>