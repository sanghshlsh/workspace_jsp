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
	<%--
		getinit~ - > 초기화파라미터
	 --%>
	<%
		String url = config.getInitParameter("url");
		
	%>
	<%=url %>
	
	<%--
	web.xml
	<servlet>
 	<servlet-name>test1</servlet-name>
 	<jsp-file>/NewFile13.jsp</jsp-file>
  	<init-param>
  	<param-name>url</param-name>
  	<param-value>hello wrold</param-value>
    </init-param>
	</servlet>
 
	<servlet-mapping>
	<servlet-name>test1</servlet-name>
  	<url-pattern>/NewFile13.jsp</url-pattern
	</servlet-mapping>
	 --%>

</body>
</html>