<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="test6" method="get">
	
	당신의 취미는?<br>
	<input type="checkbox" name = "h" value="football">축구<br><!-- 한체크박스이기에 name은  통일해야한다. -->
	<input type="checkbox" name = "h" value="baseball">야구<br>
	<input type="checkbox" name = "h" value="basketball">농구<br>	
		<input type="submit" value="get">
	</form>
	
	<form action="test3" method="post">
		<input type="submit" value="post">
	</form>
	

</body>
</html>
