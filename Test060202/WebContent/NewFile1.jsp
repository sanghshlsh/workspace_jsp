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
pageContext.setAttribute("m", null);

%>
${dto }<br><%-- dto는 현재 없다 null --%>
${m }<br><%-- m값은 현재 위에서 null로 바인딩 --%>
<hr>
${m.id }<br><%-- null의 속성출력메시지 - nullpointexception조차 안뜬다. --%>
<hr>

${empty m }<br><%-- m이 null인가? 아래와 동일하나 일반적으로 empty m이라 작성한다.--%>
${m == null }<br>
<hr>
${!empty m }<br><%-- m이 null이 아닌가? 의 표현법 마찬가지로 일반적인표현볍  --%>
${m != null }<br>
</body>
</html>