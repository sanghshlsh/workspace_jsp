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

<%-- 내장객체또한 scriptlet tag 안에서만 사용가능
(
간단히 method나  생성자처럼생각해라/
즉 scriptlet 내부 scriptlet 생성불가/method/constructor 또한 생성불가
변수 선언가능(지역변수)ex) int a = 10;
변수대입가능 ex)a=5;
method 호출 가능 ex) out.print("");
멤버변수 선언가능
멤버변수/지역변수 모두 사용가능하다면 반드시 지역변수 사용
)
--%>
<% 

	request.getAttribute("");
	int a = 10;
	a= 5;
	//public void me1(){} 불가
	//method 호출 가능 
	out.print(a);
	a=100;
%>

<h1>분리X</h1>
<%
	
	/* 위 scriptlet tag 와 나누어져있는것 처럼보여도 이어져 있다. 이를 이용해 다음과 같이 사용가능*/
	out.print(a);
%>
<%
	a =10;
	for(int i = 0 ; i < a ; i++){	
%>
		hello : + <%out.print(i);%><%=i%>
		<br>
<%
	}

%>

</body>
</html>