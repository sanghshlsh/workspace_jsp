<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="${empty login ? 'loginui.do' : 'logout.do'}" >
	${empty login ? '로그인' : '로그아웃'}
	</a>
	
	<br>
	<a href="insertui.do">회원등록</a>
	<br><br>
	<h1>전체 회원 목록</h1>
	<%-- for(memberdto dto:list){} <-->  <c:forEach items="${list}" var="dto">  같음--%>
	<c:forEach items="${list}" var="dto">
	<a href="selectById.do?id=${dto.id}">${dto.id} : ${dto.name} </a>	
	<br>	
	</c:forEach>



<%--JSTL 설치후 위와같이 변경가능 	
	<%
		List<MemberDTO> list = (List<MemberDTO>) request.getAttribute("list");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				MemberDTO dto = list.get(i);

				out.print("<a href='selectById.do?id=" + dto.getId() + "'>");
				out.print(dto.getId());
				out.print(":");
				out.print(dto.getName());
				out.print("</a>");
				out.print("<br>");
			}
		}
	%>
--%>
</body>
</html>