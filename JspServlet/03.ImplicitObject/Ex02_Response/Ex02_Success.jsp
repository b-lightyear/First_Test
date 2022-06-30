<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	성공~!
	
	<%
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i <cookies.length; i++) {
			/* if(cookies[i].getName().equals("id")) */
	%>
		<p><%= cookies[i].getName() %></p>
		<p><%= cookies[i].getValue() %></p>
			
	<% } %>
	
</body>
</html>