<%--
  Created by IntelliJ IDEA.
  User: binh1
  Date: 01/08/2023
  Time: 9:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/hello-servlet" method="post">
  <input type="text" placeholder="name..." name="name"/> <br>
  <input type="text" placeholder="age..." name="age"/> <br>
  <button type="submit" value="ADD" name="action">ADD</button>
</form>
</body>
</html>
