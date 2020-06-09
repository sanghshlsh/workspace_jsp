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
	<%-- request
	
	내장객체 - scriptlet tag에서만 사용가능
		mvc2에서는 parameter가 넘어올 일이 거의 없어 getParameter()의 사용이 적다.
		request - 내장객체인 동시에 영역객체
	 --%>
	
	<% 
		String id = request.getParameter("id");
		out.print(id);
		
		request.setAttribute("id", id);
		id = (String) request.getAttribute("id");
		String pw = request.getParameter("pw");
		request.setAttribute("pw", pw);
	%>
	${id} : ${pw }
	
	
	<%
		request.getRequestDispatcher("NewFile8.jsp").forward(request, response);
	
	
	%>
</body>
</html>