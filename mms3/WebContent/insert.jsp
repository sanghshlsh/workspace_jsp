<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 등록</h1>
		<%--
	<form action="checkID.bo" method="post">
	<a href="checkid.bo?id=">중복확인</a>

	</form> 
	 --%>	
	<form action="insert.bo" method = "post">
	ID : <input name = "id" > <br>
	<!-- 아이디중복체크 패스워드 확인 두개하고넘어가야한다. -->
	PW : <input name = "pw1" type="password"><br>
	PW확인 : <input name = "pw2" type="password"><br>
	Name : <input name = "name"><br>
	Age : <input name = "age" type ="number"><br>
 	<input type="submit" value="회원등록">
	</form><form action="select.bo"><input type="submit" value="뒤로가기"></form>
</body>
</html>