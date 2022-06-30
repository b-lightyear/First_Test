<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		http://localhost/imo/Ex02_ResLogin이라는 맵핑을 입력받으면
		Ex02_ResLogin.jsp까지 이동하는 서블릿은 만든다
		
		URL을 통해서 파라메터 id와 pw를 입력받는다. id가 admin이고 pw가 admin1234면
		a태그를 이용해서 성공이라고 출력
		그 외에는 실패라고 출력
	
		Forward(파라매터나 어떤 넘겨줄 값을 보내줄 수가 있음. 다음 페이지로
		Response : 어떠한 파라메터도 못 보내고 강제로 페이지를 전환함

	 	|| : OR, 논리합, 더하기, 하나의 조건이라도 True가 반환이 되면 그 다음 조건은 비교안함
	 	&& : AND, 논리곱, 곱하기, 하나의 조건이라도 TRUE가 나와도 뒤에 조건이 false가 나오면 비교 안 함
	 	김 또는 이 == 로그인 OR
	 	김씨만!!!!! AND -->
	 
	 <%
		if( request.getParameter("id") != null && /* 500 오류 안 뜨게, 조건만 추가 */
			request.getParameter("pw") != null && 
			request.getParameter("id").equals("admin") &&
			request.getParameter("pw").equals("admin1234")){
			
			/* Cookie : Response를 통해서 페이지 전환이 일어났을 때 일정시간 후에
				어떤 데이터를 삭제해야하는 상황 등에서 임시로 사용할 수 있는 데이터 저장공간 */
			Cookie cookie = new Cookie("id", "admin");
			response.addCookie(cookie);	// 응답객체에 쿠키(임시데이터 저장)을 추가함, 많이 사용 안함.
			
			response.sendRedirect("Ex02_Success.jsp");
		}else {
			response.sendRedirect("Ex02_Failed.jsp");
		}
	%>
	 
	 
	 <!-- 
	 	http://localhost/imo/Ex02_ResLogin : 포워트를 통해서 여기까지 왔을 때 URL JSP 경로가 안 나와있다.
	 	http://localhost/imo/index.html : 인덱스의 경로가 그대로 찍힘.
	  -->
	 
	
	 
</body>
</html>