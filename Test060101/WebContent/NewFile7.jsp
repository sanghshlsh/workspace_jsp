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
<%!
	int a = 10;
	//a=2;	대입불가
	//me2(); 메소드 호출 불가
	public void me2(){
		a=111;
		//out.print(""); 내장객체는 scriptlet tag에서만 사용가능
		me3();
	}
	
	public void me3(){
		
	}
%>

</body>
</html>