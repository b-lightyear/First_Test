<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 인클루드 태그 안에서 param(매개변수)을 전달이 가능하다 -->
	<jsp:include page="Ex02_IncludeHeader.jsp">
		<jsp:param value="SHS" name="name"/>
	</jsp:include>
	<h1>JSP인클루드 시키기</h1>
	<jsp:include page="Ex02_IncludeFooter.jsp"></jsp:include>
</body>
</html>