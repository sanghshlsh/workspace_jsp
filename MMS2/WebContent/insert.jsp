<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 가입</h1>
	<form action="insert.do" method="post">
	ID : <input name = "id"><br>
	Name : <input name = "name"><br>
	Age : <input type = "number" name = "age"><br>
	PW : <input type = "password" name = "pw"><br><!-- 2.회원가입시 비밀번호입력-->
	<input type="submit" value="가입">
	</form>
</body>
</html>