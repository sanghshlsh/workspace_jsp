<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${param.title }검색목록</h1>
	<a href="writeui.do">글쓰기</a>


	<table border="1">
		<thead>
			<tr>
				<th>Num</th>
				<th width="250">Title</th>
				<th>Writer</th>
				<th>Writeday</th>
				<th>Readcnt</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${list }" var="dto">

				<tr>
					<td>${dto.num}</td>

					<td><c:forEach begin="1" end="${dto.repIndent }">&nbsp;</c:forEach><a
						href="read.do?num=${dto.num }">${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.writeday}</td>
					<td>${dto.readcnt}</td>

				</tr>

			</c:forEach>



		</tbody>
	</table>
	<c:if test="${to.curPage>1 }">
		<a
			href="search.do?title=${param.title }&curPage=${to.beginPageNum>10?to.beginPageNum-10:to.beginPageNum }">&laquo;&laquo;</a>
&nbsp;
<a href="search.do?title=${param.title }&curPage=${to.curPage-1}">&laquo;</a>
&nbsp;&nbsp;
</c:if>
	<c:forEach begin="${to.beginPageNum }" end="${to.stopPageNum }"
		var="idx">

		<c:if test="${to.curPage == idx }">
			<a style="font-size: 20px"
				href="search.do?title=${param.title }&curPage=${idx }">${idx }</a> &nbsp; &nbsp;
</c:if>

		<c:if test="${to.curPage != idx }">
			<a href="search.do?title=${param.title }&curPage=${idx }">${idx }</a> &nbsp; &nbsp;
</c:if>

	</c:forEach>
	<c:if test="${to.curPage<to.totalPage }">
		<a href="search.do?title=${param.title }&curPage=${to.curPage+1}">&raquo;</a>
&nbsp;
<a
			href="search.do?title=${param.title }&curPage=${to.stopPageNum<to.totalPage?to.stopPageNum+1:to.stopPageNum}">&raquo;&raquo;</a>
	</c:if>
	<form action="search.do?title=">
		검색 : <input type="search" name="title"><input type="submit"
			value="검색">
	</form>

	<form action="list.do" method="get">
		<input type="submit" value="목록으로">
	</form>





</body>
</html>