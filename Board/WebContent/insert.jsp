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
	<h1> 글쓰기	</h1>
	<%--
	upload기능을 넣고자한다면
	enctype="multipart/form~"을 넣어 준다.
	 --%>
	<form action="write.do" method="post">
	작성자 : <input name="writer"><br>
	제목 : <input name="title"><br>
	내용 : <br>
	<textarea rows="5" name="content"></textarea><%-- <textarea></textarea>사이 줄바꿈하면 안된다. --%>
	<input type="submit" value="등록">
	</form>



</body>
</html>