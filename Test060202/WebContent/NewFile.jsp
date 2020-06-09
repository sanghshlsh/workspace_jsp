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

	<h1>Expression Language(표현언어)</h1>
	${111}<br>
	<%-- jstl과 사용하는것이 더욱 효과적 
		산술연산 가능
		문자열 입력 가능
		비교연산 가능
	--%>
	${"hello" }<br>
	${1+2 }<br>
	${1-2 }<br>
	${1*2 }<br>
	${1/2 }<br>
	${1%2 }<br>
	<hr>
	${1>2 }<br>
	${1>=2 }<br>
	${1<2 }<br>
	${1<=2 }<br>
	${1==2 }<br>
	${1!=2 }<br>
	<hr>
	${true&&true }<br>
	${(3>4)&&(5<6) }<br>
	${true||false }<br>
	<hr>
	${ 3>4?100:-5}<br>
	<%
		request.setAttribute("a", 11);
	
	%>
	<%-- 밖이 이미 ""로 묶여있을 때 내부에 ""를 다시 써야 할 때는 밖의 ""나 내부의 ""둘중 하나를 ''로 바꿔야 한다. --%>
	<a href='${ a > 3 ? "http://www.naver.com" : "http://www.google.com" }'>hello</a>
	

</body>
</html>