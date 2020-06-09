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

<h1>${param.title }검색 결과</h1>
<a href="insertui.do">글쓰기</a>
<form action="search.do?title="><input type="search" name="title"><input type="submit" value="검색"></form>
<form action="list.do"><input type="submit" value="목록"></form>
<table border="1">
<thead>
<tr>
<th>글번호</th>
<th>제목</th>
<th>작성자</th>
<th>작성일</th>
<th>조회수</th>
</tr>
</thead>

<tbody>
<c:forEach items="${list }" var="dto">
<tr>
<td>${dto.num }</td>
<td>
<c:forEach begin="1" end="${dto.repIndent }">&nbsp;</c:forEach>
<a href="read.do?num=${dto.num }">${dto.title }</a></td>
<td>${dto.writer }</td>
<td>${dto.writeday }</td>
<td>${dto.readcnt }</td>
</tr>
</c:forEach>
</tbody>



</table>
</body>
</html>