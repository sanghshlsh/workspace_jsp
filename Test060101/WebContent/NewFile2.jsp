<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>
	본문입니다.-static include
	</h1>
	
	<%@ include file="part.jsp" %>
	
	
	<%--
	이것을 모든파일에 작성하는것은 중복이 심해 include directive tag/include action tag를 이용하여 해결한다.
	<footer>
		<h1>푸터입니다.</h1>
	</footer>
		<%@ include file="part.jsp" %> 작성시 part.jsp안에 있는 <!DOCTYPE html> <html><head>등 모든 내용이 전부 다 기입된다.
		따라서 문제를 해결하려면 part.jsp 안에 있는 page directive tag 와 필요한 태그를 제외한 모든 코드를 제거해야한다.(특히 html 구조)
	 --%>

</body>
</html>