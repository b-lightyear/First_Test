<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table {
	 border: 1px solid black;
	}
	
	td {
	 border: 1px solid black;
	 padding: 5px;
	}
	
	.color:nth-child(odd) {
		background-color: #C70A80;
	}
	.color:nth-child(even) {
		background-color: #FBCB0A;
	}
</style>
<title>구구단 출력</title>
</head>
<body>
	<!-- 구구단 출력, table 태그를 이용해서 출력 -->
	<h1>구구단 출력1</h1>
	<table>
	<% for(int i = 2; i <= 9; i++) { %>
		<tr>
		<% for(int j = 1; j <= 9; j++) { %>
		<td><%= j %> * <%= i %> = <%= (i*j) %></td>
		<% } %>
		</tr>
	<% } %>
	</table>
	
	<h1>구구단 출력2</h1>
	<table>
	<% for(int i = 1; i <= 9; i++) { %>
		<tr>
		<% for(int j = 2; j <= 9; j++) { %>
			<td><%= j %> * <%= i %> = <%= i*j %></td>
		<% } %>
		</tr>
	<% } %>
	</table>

	<h1>구구단 출력3</h1>
	<table>
	<% for(int i = 2; i <= 9; i++) { %>
		<tr class="color">
		<% for(int j = 1; j <= 9; j++) { %>
			<td><%= j %> * <%= i %> = <%= i*j %></td>
		<% } %>
		</tr>
	<% } %>
	</table>
	
</body>
</html>