<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  -->
	<h1>쿠키, URL/URI, 요청방식 등등 Request 속성들을 일단 따라쳐보기</h1>
	<table border="1">
		<tr>
			<td>쿠키 정보</td>
			<% Cookie[] cookie = request.getCookies();
				if(cookie == null) {
			%>
				<td>쿠키가 존재하지 않습니다.</td>
			<% }else {
					for(int i = 0; i < cookie.length; i++) { %>
					<td><%= cookie[i].getName() %> &nbsp; <%= cookie[i].getValue() %> </td>
					<% } %>
			<% } %>
		</tr>
		
		<tr>
			<td>서버 도메인명</td>
			<td><%= request.getServerName() %></td>
		</tr>
		
		<tr>
			<td>서버 포트</td>
			<td><%= request.getServerPort() %></td>
		</tr>
		
		<tr>
			<td>요청 URL</td>
			<td><%= request.getRequestURL() %></td>
		</tr>
		
		<tr>
			<td>요청 URI</td>
			<td><%= request.getRequestURI() %></td>
			<!-- 범위 : URI > URL
				URI(통합 자원 식별자, Uniform REsource Identifier) : 웹기술에서 사용되는 논리, 물리적 리소스를 식별하는 고유한 문자열 시퀀스
				URL(웹주소) : 리소스가 어디에 있는지를 알려주기 위한 URI에 서브셋(편하게 보기 만듦) -->
		</tr>
		
		<tr>
			<td>요청 쿼리</td> <!-- 쿼리 : 지리어. 전부 String으로 들어온다 -->
			<td><%= request.getQueryString() %></td>
		</tr>
		
		<tr>
			<td>클라이언트 호스트명</td>
			<td><%= request.getRemoteHost() %></td>
		</tr>
		
		<tr>
			<td>클라이언트 IP 주소</td>
			<td><%= request.getRemoteAddr() %></td>
		</tr>
		
		<tr>
			<td>프로토콜</td>
			<td><%= request.getProtocol() %></td>
		</tr>
		
		<tr>
			<td>메소드(요청방식)</td>
			<td><%= request.getMethod() %></td>
		</tr>
		
		<tr>
			<td>컨텍스트 경로</td>
			<td><%= request.getContextPath() %></td>
		</tr>
		
	</table>
</body>
</html>