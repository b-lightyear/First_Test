<%@page import="student.StudentDTO"%>
<%@page import="student.StudentDAO"%>
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
	
	<h3> 정보 보기~~</h3>
	
	<%
		StudentDTO dto = (StudentDTO) request.getAttribute("dto");
	%>
	
	<table>
	<tr>
		<th>학생 번호</th>
		<td> <%= dto.getStudent_no() %> </td>
	</tr>
	<tr>
		<th>아이디</th>
		<td> <%= dto.getUser_id() %> </td>
	</tr>
	<tr>
		<th>학생이름</th>
		<td> <%= dto.getStudent_name() %> </td>
	</tr>
	<tr>
		<th>성</th>
		<td> <%= dto.getLast_name() %> </td>
	</tr>
	<tr>
		<th>이름</th>
		<td> <%= dto.getFirst_name() %> </td>
	</tr>
	<tr>
		<th>요청</th>
		<td><form action="detail.st" method="get">
			<input type="hidden" name="student_no" value="<%= dto.getStudent_no() %>">
			<input type="hidden" name="user_id" value="<%= dto.getUser_id() %>">
			<input type="submit" value="detail.st로 요청">
			</form></td>
	</tr>
	<tr>
		<td><a href="update.st?student_no=<%= dto.getStudent_no() %>&user_id=<%=dto.getUser_id() %>">수정하기</a></td>
		<td><a onclick="deleteInfo('<%= dto.getStudent_no() %>', '<%=dto.getUser_id() %>');">삭제하기</a></td>
	
	</tr>
	</table>
	<script type="text/javascript">
	function deleteInfo(student_no, user_id) {
		
		if(confirm('정말 삭제하시겠습니까?')) {
			//삭제를 하기 위한 키 값, url에 찍히게 해보기
			location.href = 'delete.st?student_no=' + student_no + '&user_id=' + user_id;
			
		}else {
			alert('삭제 취소')
		}//if
		
	}//deleteInfo()
	</script>
	<%@ include file="/include/footer.jsp" %>
</body>
</html>