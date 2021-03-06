<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 펑션</h1>
	<c:set var="str" value="     hello jsp servlet     "/>
	<p>일반 EL문자 출력 : ${str }</p>
	<p>대문자로 바꾸기 : ${fn:toUpperCase(str)}</p>
	<p>소문자로 바꾸기 : ${fn:toLowerCase(str)}</p>
	<p>문자열의 길이 구하기 : ${fn:length(str)}</p>
	<p>공백 제거 : ${fn:trim(str)}</p>
	<p>공백 제거 후 길이 : ${fn:length(fn:trim(str))}</p>
	<p>jsp 문자를 자바로 바꿔보기 : ${fn:replace(str, "jsp", "JAVA")}</p>
</body>
</html>