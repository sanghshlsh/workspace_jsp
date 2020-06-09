<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보 수정</h1>

<form action="update.do" method="post">
ID : <input name="id" value="${dto.id}" readonly><br>   <!-- dto.getId() 동일하다(EL) -->
Name : <input name="name" value="${dto.name}"><br>
Age : <input name="age" type="number" value="${dto.age}"><br>
<input type="submit" value="수정">

</form>



</body>
</html>