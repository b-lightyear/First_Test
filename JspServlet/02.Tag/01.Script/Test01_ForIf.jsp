<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- For와 If 중첩시키기 -->
	<!-- 1~100까지의 수 중에서 짝수의 합과 홀수의 합을 출력 -->
	<!-- 짝수도 출력(빨간), 홀수도 출력(파란) -->
	
	<%
	int even = 0;
	int odd = 0; 
	
	for(int i = 1; i <= 100; i++) {
		if(i % 2 == 0) {
			even += i; %>
	<p style="color:red;"> 짝수인 수 : <%= i %> </p>
	<% }else {
			odd += i; %>
	<p style="color:blue;"> 홀수인 수 : <%= i %> </p>
	<% }
	} %>

	<p>짝수의 합 : <%= even %></p>
	<p>홀수의 합 : <%= odd %></p>
</body>
</html>