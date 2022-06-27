<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 요청 방식은 크게 두 가지 (GET/POST)
		- GET : URL에 보낸 파라매터가 그대로 찍힘(보안X)
		- POST : URL에 보낸 파라매터가 공개가 되지 않음 (보안O) 테스트 X
		- 요청을 URL로 함(Servlet(servlet을 통해서 이동(M View Controller))), JSP 페이지로 이동(Jsp로 바로 이동))-->
	
	<!-- Ex01_Request라는 서블릿을 만들고 요청해보기 -->
	<h3>get 방식 요청</h3>
	<form action="../Ex01_Request" method="get">
		<!-- inputType 텍스트 주고 이름 아이디 비밀번호 입력받게 만들기 -->
		이름 : <input type="text" name="name" placeholder="이름"><br />
		아이디 : <input type="text" name="id" placeholder="아이디"><br />
		비밀번호 : <input type="password" name="pw" placeholder="비밀번호"><br />
		<input type="submit">
	</form>
	
	<h3>post 방식 요청</h3>
	<form action="../Ex01_Request" method="post">
		이름 : <input type="text" name="name" placeholder="이름"><br />
		아이디 : <input type="text" name="id" placeholder="아이디"><br />
		비밀번호 : <input type="password" name="pw" placeholder="비밀번호"><br />
		<input type="submit" >
	</form>
	
	<h3>페이지 to 페이지</h3>
	<form action="Ex01_RequestResult.jsp" method="get">
		이름 : <input type="text" name="name" placeholder="이름"><br />
		아이디 : <input type="text" name="id" placeholder="아이디"><br />
		비밀번호 : <input type="password" name="pw" placeholder="비밀번호"><br />
		<input type="submit" value="이동">
	</form>
</body>
</html>