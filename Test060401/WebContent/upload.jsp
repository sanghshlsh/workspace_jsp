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
<%--file upload 데이터 전송 방식은 post방식으로 한다.
	get방식으로 보내는 데이터의 크기는 제약이 있기때문에 get방식으로 보낼 수 없다.
 --%>
 
 <form enctype="multipart/form-data"  action="upload" method="post">
 <%-- post방식으로 directive패턴으로 된 서블릿(action="upload" not [xxx.do xxx.jsp])
 enctype을 multipart/form-data로 변경시켜줘야 한다.
  --%>
  title : <input name="title"><br>
  첨부파일 : <input type="file" name="file"><br>
  <input type="submit" value="저장">
 </form>


</body>
</html>