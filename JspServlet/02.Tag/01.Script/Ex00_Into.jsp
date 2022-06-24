<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문</title>
</head>
<body>

	<h4>선언문과 표현문</h4>
	
	<%! String var = "SHS"; %>	<!-- 선언문은 전역변수, 전역메소드를 선언하는 공간 -->
								<!-- html 상태가 아니라서 표현문으로 나타나게 해야 한다 -->
	<% var = "내용바꿈"; %>		<!-- 스크립틀릿. 자바코드라서 ';' 써야 함. -->
	
	JAVA로 작성된 코드를 표현하기 <%=var %> <!-- 표현문은 선언 된 변수나 메소드등의 결과를 보여주기 위한 태그. ';'는 안 된다 -->
</body>
</html>