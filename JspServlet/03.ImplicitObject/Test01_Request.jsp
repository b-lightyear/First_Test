<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Form 태그 이용해서 서블릿 요청
	파라매터 100개 보내기
	
	Test01_Request에 요청받기. 100개 출력 -->
	
	<h3>파라매터 100개 보내기</h3>
	<form action="../Test01_Request" method="get">
	<% for(int i = 1; i <= 100; i++) { %>
		<%= i %>번 출력<input type="text" name="param1"<%= i %> value="100번 출력"> <br>
	<% } %>
	</form>
	
		
	<!--  get방식을 이용해서 Request를 사용할수가있음 -->
	<% if(request.getParameter("cnt") != null){
		int cnt = Integer.parseInt(request.getParameter("cnt") );
	%>
		
	<form action="../Test02_Request" method="get">
		<!-- 인풋타입 텍스트 주고 이름하고 아이디 비밀번호 입력받게만들기  -->
		<%for (int i = 0 ; i <cnt ; i ++){ %>
		<p>파라메터<%=i %> : <input type="text" name="param<%=i %>" value="param<%=i%>"></p>
		<%} %>
		<input type="text" name="cnt" value="<%=cnt%>">
	<input type="submit">
	</form>	
	<%} %>
	
	
	
</body>
</html>