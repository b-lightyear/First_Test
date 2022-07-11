<%@page import="java.util.List"%>
<%@page import="customer.CustomerDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
</style>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>이메일</th>
			<th>핸드폰</th>
		</tr>
		
		<% List<CustomerDTO> list = (List<CustomerDTO>) request.getAttribute("list"); 
		 for(int i = 0; i < list.size(); i++) { %>
		<tr>
		<td><%= list.get(i).getId() %></td>
		<td><%= list.get(i).getName() %></td>
		<td><%= list.get(i).getGender() %></td>
		<td><%= list.get(i).getEmail() %></td>
		<td><%= list.get(i).getPhone() %></td>
		<% } %> 
		</tr>
		</table>
	
	<%@ include file="/include/footer.jsp" %>
</body>
</html>