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
	
	<%--
		forward action tag	<jsp:forward page=""/> (dispatcher 방식)
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
		
		 역할을 함
	--%>
	
	<jsp:forward page="NewFile.jsp"/>

</body>
</html>