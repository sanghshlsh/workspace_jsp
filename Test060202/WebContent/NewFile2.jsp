<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo"%>
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
	<%
		String msg = "good";
	
	pageContext.setAttribute("p", "pageContext");
	request.setAttribute("r", "request");
	session.setAttribute("s", "session");
	application.setAttribute("a", "application");
	
	%>
	${msg }<br><%--자리는 차지한다. --%>
	${p }<br>
	${r }<br>
	${s }<br>
	${a }<br>
	<jsp:forward page="NewFile3.jsp"/>
	<%--scope
	pageContext만 scpoe를 벗어나 사라진다.-new3
	redirect방식으로 forwading한다면 request또한 scpoe를 벗어나 사라진다.	-new4
	다른브라우져에서 url주소를 복사하여 붙여넣는다면 session또한 scope를 벗어나 사라진다
	
	${pageScope.p}
	${requestScope.r}
	${sessionScope.s}
	${applicationScope.a}
	사용가능하긴하다.
	${pageScope["p"]}
	${requestScope["r"]}
	${sessionScope["s"]}
	${applicationScope["a"]}
	위와 동일
	
	${initParam.url} <-- ContextParameter의 name이 url인것
	
	${param.id}<------이는 기억할것 select.bo?id=sdfa--->에서 sdfa출력
	
	
	--%>

</body>
</html>