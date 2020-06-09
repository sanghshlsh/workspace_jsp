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
<h1>게시글 목록</h1>
<a href="writeui.do">글쓰기</a>


<table border="1">
<thead>
<tr>
<th>Num</th>
<th>Title</th>
<th>Writer</th>
<th>Writeday</th>
<th>Readcnt</th>
<th>RepRoot</th>
<th>RepStep</th>
<th>RepIndent</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="dto">
<tr>
<td>${dto.num}</td>
<td>
<c:forEach begin="1" end="${dto.repIndent }">&nbsp;</c:forEach>
<a href="read.do?num=${dto.num}">
${dto.title}</a></td>
<td>${dto.writer}</td>
<td>${dto.writeday}</td>
<td>${dto.readcnt}</td>
<td>${dto.repRoot}</td>
<td>${dto.repStep}</td>
<td>${dto.repIndent}</td>
</tr>

</c:forEach>



</tbody>
</table>




<form action="search.do?title=">
검색 : <input name="title"><input type="submit" value="검색">
</form>









</body>
</html>