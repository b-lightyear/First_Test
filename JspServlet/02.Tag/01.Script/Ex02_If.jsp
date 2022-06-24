<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>if문 사용해보기</h1>
	<!-- 전역변수 선언 : 변수나 메소드를 정의할 때 쓴다. -->
	<%! int iVar = 4; %>
	
	<!-- 자바 로직을 넣을 수 있는 스클립틀릿 태그를 이용해서 제어문 사용해보기 -->
	<!-- 스크립트 태그 열림과 닫힘까지의 사이는 자바코드 영역, 그 외에는 html 영역이다. -->
	<!-- 전역변수라서 가능하다~!! -->
	<% if(iVar % 2 == 0) { %>
	<p>iVar는 <%= iVar %>로 짝수입니다</p>
	<% }else { %> 
	<p>iVar는 <%= iVar %>로 홀수입니다</p>
	<% } %> 
	
	<!-- 갓신향 -->
	<%
		out.println("와 <br>");
		out.print("와");
		out.print("와");
	%>
</body>
</html>