<%@page import="common.commonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<body>
	<%@ include file="include/layout.jsp" %>
	<h3>내용 아무거나</h3>
		<div class="card-body">
		    <table id="datatablesSimple">
		        <thead>
		            <tr>
		                <th>번호</th>
		                <th>이름</th>
		                <th>성별</th>
		                <th>이메일</th>
		                <th>핸드폰번호</th>
		            </tr>
		        </thead>
		        <tfoot>
		            <tr>
		             	<th>번호</th>
		                <th>이름</th>
		                <th>성별</th>
		                <th>이메일</th>
		                <th>핸드폰번호</th>
		            </tr>
		        </tfoot>
		        <tbody>
		            <tr>
		                <td>Tiger Nixon</td>
		                <td>System Architect</td>
		                <td>Edinburgh</td>
		                <td>61</td>
		                <td>2011/04/25</td>
		            </tr>
		        </tbody>
		    </table>
		</div>
                       
	<%@ include file="include/footer.jsp" %>
</body>
</html>
