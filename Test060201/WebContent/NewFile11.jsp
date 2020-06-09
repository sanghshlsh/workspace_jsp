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
		<%-- application --%>
	<%! int count = 0; %>
	<% 
		count++;
	application.setAttribute("count", count);
	%>
	
	
	
	<label>방문자수: </label>${count }<%-- 방문자수는 언제나 거쳐가는 frontcontroller에 작성하는것이 일반적 --%>
	${applicationScope.count }
	<%-- application/session/xxScope.asd xx에 binding되어있는 asd --%>
</body>
</html>