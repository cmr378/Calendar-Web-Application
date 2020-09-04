<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<h3>${message}</h3>
	<h3>${secondMessage}<h3>
</body>
</html>



<!-- <% if(response.getStatus() == 500){ %>
<font color="red">Error: <%=exception.getMessage() %></font><br>
<%-- include login page --%>
<%@ include file="index.jsp"%>
<%}else {%>
User email already exists please log in or use another email<br>
Please go to <a href="create">home page</a>
<%} %> -->