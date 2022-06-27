<%@page import="dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Bean : 태그를 통해서 DTO같은 객체를 만들어내는 방법. JSP 컨테이너에서 많이 사용 -->\
	<!-- form 태그 안에 inputType=text name=DTO의 필드변수와 같은 것.
		찾아서 setter 메소드를 실행 후, 하나의 dto 구조를 만들어냄(자동)
		form태그 이름과 필드명이 같아야 할 것!! -->
		
	<% UserDTO dto = new UserDTO();
		dto.setName("이름");
		dto.setNum(20);
	%>
	
	<!-- DTO 필드 : Form 태그 안에 들어있는 inputType 위젝 name이 같아야만 자동으로 bean을 생성해준다. -->
	<jsp:useBean id="user1" class="dto.UserDTO"></jsp:useBean>
	<jsp:setProperty property="name" value="이름" name="user1"/>
	<jsp:setProperty property="num" value="20" name="user1"/>
	
	<p>자바코드로 DTO 생성한 것 : <%= dto.getName() %> <%= dto.getNum() %></p>
	<p>Bean객체로 DTO 생성한 것 : <%= user1.getName() %> <%= user1.getNum() %></p>
	<p>액션태그로 출력(사용빈도X) : <jsp:getProperty property="name" name="user1"/>
									<jsp:getProperty property="num" name="user1"/> </p>
</body>
</html>