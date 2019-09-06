<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="account-form" action="<%=request.getContextPath()%>/account.do">
		입금액<input type="text" name = "money" /> <br/>
		<input type="submit" id="btn" value="전송"> 
</body>
</html>