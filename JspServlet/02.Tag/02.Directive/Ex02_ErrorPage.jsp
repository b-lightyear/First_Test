<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>오류 발생</h1>
	<h2>개발자가 수정중입니다. 최대한 빠르게 대응하겠습니다.</h2>
	<!-- JSP 컨테이너(내장객체) 중 exception(예외) -->
	<h3>exception 내장객체 변수를 이용해서 에러를 표시</h3>
	
	<%
		//out : 내장객체
		exception.printStackTrace(new PrintWriter(out));
	%>
	
</body>
</body>
</html>