<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 전역 변수 만들어보기, 전역변수는 느낌표 -->
	<!-- String 변수 1개, double 변수, String[] 배열 4개 이상의 크기(T, E, S, T) -->
	<%! int vInt = 99;
	String str = "문자";
	Double db = 1.2345;
	String[] arr = {"T", "E", "S", "T"};
	%>
	
	<!-- 지역변수 -->
	<% int lvInt = 10;
		vInt ++ ;
		lvInt ++;
	%> 
	
	<!-- 전역 변수 표현하기 -->
	<p>vInt의 값 :  <%= vInt %> <!-- 새로고침을 하면 값이 올라간다. -->
	lvInt의 값 : <%= lvInt %></p>
	
	<p>str의 값 : <%= str %></p>
	<p>db의 값 : <%= db %></p>
	<p><%= arr %><!-- 메모리값... index값을 추출해줘야한다~~ -->
	<p>arr의 값 : <%= arr[0] %></p>
	<p>arr의 값 : <%= arr[1] %></p>
	<p>arr의 값 : <%= arr[2] %></p>
	<p>arr의 값 : <%= arr[3] %></p>
	
</body>
</html>