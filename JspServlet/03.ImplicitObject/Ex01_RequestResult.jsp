<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	id : <%= request.getParameter("id") %>
	pw : <%= request.getParameter("pw") %>
	name : <%= request.getParameter("name") %>
</body>
</html>