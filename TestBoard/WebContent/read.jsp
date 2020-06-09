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
<h1>${dto.title }</h1>
작성자 : ${dto.writer }
<br> 
<textarea rows="5" readonly>${dto.content }</textarea><br>
<a href="list.do">목록</a> | <a href="reply.do?num=${dto.num }">답글</a> | <a href="updateui.do?num=${dto.num }">수정</a> | <a href="delete.do?num=${dto.num }">삭제</a>
</body>
</html>