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
	<%-- paging 1~10 11~20 부분별로 찍고싶다. 
		step의 경우 default값이 1이라 생략가능
	begin end 의경우 상수로 진행하는 경우가 많지만 혹시나 이를 유지보수를 쉽게하기 위해서는 db에 저장하고 넘겨받게 만들어야한다.
	--%>
	<c:forEach begin="1" end="10" var="num" step="2">
		<a href="select.bo?page=${num }">${num} |</a>
	</c:forEach>
	
	<hr>
	
	
	<%-- varstatus 
		status.index status.count 기억 이 두개를 가장많이사용 
		
		newfile1 list에 적용.
	--%>
	<c:forEach begin="200" end="210" var="num" varStatus="status" >
	${status.current } : ${num } : ${status.index } : ${status.count }<br>
	
	</c:forEach>
</body>
</html>