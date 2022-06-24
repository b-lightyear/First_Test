<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러페이지</h1>
	<!-- 에러가 발생한 코드가 있다면 다른 어떤 페이지에서 처리할 건지 가능 -->
	<%@page errorPage="Ex02_ErrorPage.jsp" %>
	
		
	<%! int[] arr = {1,2,3,4}; %>
	<%= arr[5] %>
	
</body>
</html>