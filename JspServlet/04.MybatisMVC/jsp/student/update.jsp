<%@page import="student.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h3 {
	text-align: center;
	margin: 30px;
}

table {
  font-family: 'Arial';
  margin: 25px auto;
  border-collapse: collapse;
  border: 1px solid #eee;
  border-bottom: 2px solid #00cccc;
  box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1), 0px 10px 20px rgba(0, 0, 0, 0.05), 0px 20px 20px rgba(0, 0, 0, 0.05), 0px 30px 20px rgba(0, 0, 0, 0.05);
}
table tr:hover {
  background: #f4f4f4;
}
table tr:hover td {
  color: #555;
}
table th, table td {
  color: #999;
  border: 1px solid #eee;
  padding: 12px 35px;
  border-collapse: collapse;
}
table th {
  background: #00cccc;
  color: #fff;
  text-transform: uppercase;
  font-size: 12px;
}
table th.last {
  border-right: none;
}

h1 {
  margin : 0px auto;
}
</style>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	
	<h3>수정 페이지</h3>
	<%
		StudentDTO dto = (StudentDTO) request.getAttribute("dto");
	%>
	
	<form action="modify.st" method="get">
	<input type="hidden" name="student_no" value="<%= dto.getStudent_no() %>">
	<input type="hidden" name="user_id" value="<%= dto.getUser_id() %>">
	
	<table>
	<tr>
		<th>학생 번호</th>
		<td><p><%= dto.getStudent_no() %></p></td>
		<!-- p태그 뜸, a태그 안 뜸 -->
	</tr>
	<tr>
		<th>아이디</th>
		<td><p><%= dto.getUser_id() %></p></td>
	</tr>
	<tr>
		<th>학생이름</th>
		<td><input type="text" name="student_name"  value="<%= dto.getStudent_name() %>"></td>
	</tr>
	<tr>
		<th>성</th>
		<td><input type="text" name="last_name" value="<%= dto.getLast_name() %>"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="first_name"  value="<%= dto.getFirst_name() %>"></td>
	</tr>
	<tr>
		<td><input type="submit" value="수정완료"></td>
		<td><a href="#">삭제하기</a></td>
	</tr>
	</table>
	
	<input type="submit" value="전송">
	</form>
	
	<%@ include file="/include/footer.jsp" %>
</body>
</html>