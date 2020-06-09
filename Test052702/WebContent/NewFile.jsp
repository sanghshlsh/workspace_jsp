<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String hello =(String) application.getAttribute("hello");
List<StringBuffer> list = (List<StringBuffer>) application.getAttribute("list");
Integer count = (Integer) application.getAttribute("count");//반드시 integer로받아야한다.

out.print(hello+"<br>");
for(int i = 0; i< list.size();i++){
	out.print(list.get(i)+"<br>");
}
out.print(count+"<br>");

%>
</body>
</html>