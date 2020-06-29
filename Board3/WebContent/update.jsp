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
<h1>글 수정</h1>
<form action="update.do">
Num : <input name="num" value ="${dto.num }" readonly><br>
작성자 : <input name="writer" value="${dto.writer }"><br>
제목 : <input name ="title" value="${dto.title }"><br>
내용 : <textarea name = "content" rows="5">${dto.content }</textarea><br>


<input type="submit" value="등록">



</form>

</body>
</html>