<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Method</title>
</head>
<body>
	
	<%! int getSum(int x, int y)  {
		return x + y;
	} 
	
	// getMinus, getDevide, getMulti
	//	 두 수를 입력하고 메소드를 호출해서 하나의 기능을 수행
	
	int getMin(int x, int y) {
		return x - y;
	}
	
	int getDiv(int x, int y) {
		return x / y;
	}
	
	int getMul(int x, int y) {
		return x * y;
	}
	
	%>
		
	<p> 1 + 2 = <%= getSum(1, 2) %> </p>
	<p> 1 - 2 = <%= getMin(1, 2) %> </p>
	<p> 1 / 2 = <%= getDiv(1, 2) %> </p>
	<p> 1 * 2 = <%= getMul(1, 2) %> </p>
	
</body>
</html>