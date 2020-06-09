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

	<h1>Expression Tag</h1>
	<%
		out.print("hello");
		//가능하나 servlet에서 사용하는방법
	%>
	<%= "hello" %>

	<%
		out.print("<h1>hello</h1>");
	%>
	
	<h1><%="hello"%></h1>
	
	
	<%-- EL이 대부분 Expression Tag보다 편하지만 Expression Tag가 더 편한 경우 --%>
	<%
		request.setAttribute("name", "kim");
	%>
	${name}<br>
	<%-- 이렇게 간단한경우는 el이편하지만 --%>
	
	<% for(int i = 0 ; i < 10; i++){
		out.print(i);
	} %>
	
	<%
		for(int i = 0 ; i <10; i++){
		%>
		${i}
		<%--el은 scriptlet에서 선언된 변수를 인식하지 못함 이를 EL로 그대로 사용하려면 i를 영역변수에 binding해야한다
		ex) pageContext.setAttribute("i",i); --%>
		<%
		}
	%>
	
</body>
</html>