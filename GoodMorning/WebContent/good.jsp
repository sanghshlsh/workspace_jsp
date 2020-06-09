<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>안녕하세요</h1>
<form action="ms1" method="post">
<!--post방식 사용 시 doPost method실행
그외 get방식은 doGet method실행-->
ID: <input name="id"><br>
PW: <input name="pw" type="password"><br>
<input type="submit" value="로그인">
</form>
</body>
</html>