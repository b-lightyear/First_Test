<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	text-align: center;
}

h1 {
	margin-top: 30px;
}

table {
	margin: 00px auto;
}

td {
	padding: 10px;
}
</style>
</head>
<body>
<%@ include file="/include/header.jsp" %>
	<h1>JSTL 사용</h1>
	<p>JSP 개발을 좀 더 편하고 단순화하기 위한 library(JSP standard Tag Library)</p>
	<a href="listfmt.js"> 포맷태그</a> <!-- listfmt.jsp 파일을 만들고 해당하는 파일로 연결되게 controller 처리 -->
	<a href="listfn.js"> 펑션태그</a> <!-- listfmt.jsp 파일을 만들고 해당하는 파일로 연결되게 controller 처리 -->
	<!-- Spring Boot(HTML) 타임리프, Spring legacy(JSP) -->
	
	<h3>CORE(JSTL/core)</h3><!-- 내가 사용할 기능이 들어있는 library를 taglib 태그를 통해서 추가한다. -->
	
	<!-- 자바 코드 이용해서 변수 선언 -->
	<% int num = 100; %> 
	
	<!-- JSTL을 이용한 변수 선언 -->
	<c:set var="num1" value="200" /> 
	<p>JSTL로 만든 변수 출력 : ${num1}</p>
	<p>JAVA로 만든 변수 EL문법으로 출력 : ${num}</p> <!-- 자바 코드로는 안됨!! -->
	
	<c:set var="num2" value="300" />
	<p>num1과 num2의 합 : ${num1 + num2}</p>
	
	<!-- attribute(req)에 들어있는 값을 판단해서 사용을 해야 금방 익숙해짐 -->
	<c:choose>
		<c:when test="${num1 == 200 }">
			<p>200이 맞습니다</p>
		</c:when>
		<c:when test="${num1 != 200 }">
			<p>200이 아닙니다</p>
		</c:when>
		<c:otherwise>
			<a>test</a>
		</c:otherwise>
	</c:choose>
	
	<h1>코어 if</h1>
	<c:if test="${num1 == 200 }">
		<p>200이랑 같습니다</p>
	</c:if>
	
	<h1>코어 for-each</h1>
	데이터가 한 건 이상일 때는 collection 자료구조를 사용하기 때문에 안쪽에 있는 Object를 빼내올 때 유용하다. <br>
	<% for(int i = 0; i <= 10; i++) { %>
		<p><%= i %> 자바 for문을 이용한 반복문</p>
		
	<% } %>
	<c:forEach var="i" begin="0" end="10">
		<p>${i} 자바 for-each문을 이용한 반복문</p>
	</c:forEach>
	<br>
	- 구구단 출력하기(2단, core)
	<c:forEach var="i" begin="1" end="9">
		<p>2 x ${i} = ${2*i}</p>
	</c:forEach> <br>
	
	
	- 구구단 출력하기(2단~9단)<br>
	<c:forEach var="i" begin="2" end="9">
	<table>
		<tr>
		<c:forEach var="j" begin="1" end="9">
			<td>${i} X ${j} = ${j*i}</td>
		</c:forEach>
		</tr>
	</table>
	</c:forEach>
	
	
	
<%@ include file="/include/footer.jsp" %>
</body>
</html>