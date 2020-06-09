<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ${3+4} ->7 -->
<!-- ${login.id} ->  --><%-- el은 null point exception에 관대하다. --%>
<%-- ${} 위둘은 html 코드가 될 수 있지만 이는 html코드가 될 수 없다. ${} 비어있다면 나오는값이 없기에 --%>
<!-- <h1>html</h1> html주석태그 페이지 소스에 노출-->
 //<h1> /* java */ java주석태그</h1>
<% //이곳엔 java주석태그가 적용 이또한 페이지 소스에 노출
	int a = 0;
/*	out.print(a);*/
%>
<%--
<h1>jsp</h1> jsp 주석태그 이것만  페이지 소스에 노출되지 않는다. 보안이 가장우수하다.
--%>
</body>
</html>