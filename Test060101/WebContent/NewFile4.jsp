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
	<c:out value="hello"></c:out>
	${"hello"}
	<%="hello"%>
	<%
	out.print("hello");
	%>
	<%--taglib directory tag/el/expression tag/scriptlet tag 4가지 모두 동일 EL을 주로 사용--%>
	
</body>
</html>