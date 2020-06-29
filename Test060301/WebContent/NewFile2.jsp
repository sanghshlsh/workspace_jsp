<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
	<%-- FrontController 상황 
		jsp+servlet+java로 작성한 mms의 frontcontroller 또한 이 동적객체생성/ map 이용 을 통하면 간결해진다
	--%>
	<%
		Map<String, String> map = new HashMap<String, String>();
		map.put("/select.bo", "SelectCommand");
		map.put("/insertui.bo", "InsertUICommand");
		map.put("/insert.bo", "InsertCommand");
		
		request.setAttribute("map", map);
		if(map.get("/select.bo?id=name").equalsIgnoreCase("/select.bo")){out.print("a");}
	%>
	<%-- map의 el문은 기억해두자 
	
	--%>
	<c:forEach items="${map}" var="dto">
		${dto.key } : ${dto.value }<br>
	
	</c:forEach>

</body>
</html>