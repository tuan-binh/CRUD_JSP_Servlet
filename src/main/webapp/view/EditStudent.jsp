<%--
  Created by IntelliJ IDEA.
  User: binh1
  Date: 01/08/2023
  Time: 9:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<title>Title</title>
</head>
<body>
<form action="/hello-servlet" method="post">
	<input type="hidden" value="${requestScope.data.id}" name="id"> <br>
	<input type="text" placeholder="name..." value="${requestScope.data.name}" name="name"/> <br>
	<input type="text" placeholder="age..." value="${requestScope.data.age}" name="age"/> <br>
	<button type="submit" value="EDIT" name="action">EDIT FINISH</button>
</form>
</body>
</html>
