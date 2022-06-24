<%@page import="java.sql.Date"%>
<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> import (클래스 추가 등 기능)</h1>
	<%@ page import="java.util.Random" %>
	
	
	
	<h1>자바 랜덤 클래스 이용해서 랜덤한 값을 출력 1~100 : 
	<% Random random = new Random();
	int num = random.nextInt(100); %>
	<%= num %></h1>
	
	<h1>자바 랜덤 클래스 이용해서 랜덤한 값을 출력 1~100 :	<%= new Random().nextInt(100)+1 %></h1>
	<h1>자바 랜덤 클래스 이용해서 랜덤한 값을 출력 1~100 :	<%= UUID.randomUUID() %></h1>
	<%-- <h1>지금 날짜 출력 Date : <%= new Date() %></h1> --%>
</body>
</html>