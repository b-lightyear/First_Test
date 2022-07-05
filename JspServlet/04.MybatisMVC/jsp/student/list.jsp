<%@page import="student.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 보기</title>
<style>
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

	<%@ include file="/include/header.jsp" %>	<!-- header 연결, 경로 확인 필수 -->
	
	<h1>학생 정보 보여줍니다~!</h1>
	<table>
		<tr>
			<th>학생번호</th>
			<th>학생이름</th>
			<th>아이디</th>
			<th>이름</th>
			<th>성</th>
		</tr>
	
	<%	ArrayList<StudentDTO> list = (ArrayList<StudentDTO>) request.getAttribute("list");
		for(int i = 0 ;  i<list.size(); i ++){ %>
		<tr>
			<td><a href="detail.st?student_no=<%= list.get(i).getStudent_no() %>&user_id=<%=list.get(i).getUser_id() %>"><%= list.get(i).getStudent_no() %></a></td>
			<td><%=list.get(i).getStudent_name() %></td>
			<td><%=list.get(i).getUser_id() %></td>
			<td><%=list.get(i).getFirst_name() %></td>
			<td><%=list.get(i).getLast_name() %></td>
			
			<td><form action="detail.st" method="get">
			<input type="hidden" name="student_no" value="<%= list.get(i).getStudent_no() %>">
			<input type="hidden" name="user_id" value="<%= list.get(i).getUser_id() %>">
			<input type="submit" value="detail.st로 요청">
			</form></td>
		</tr>
		
	<% } %>
	
	</table>
	<%@ include file="/include/footer.jsp" %>	<!-- footer 연결, 경로 확인 필수 -->
</body>
</html>