<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: binh1
  Date: 01/08/2023
  Time: 4:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <style>
    .add,h1 {
      padding:20px 0;
    }
  </style>
</head>
<body>
<h1>Danh Sách Sinh Viên</h1>
<a href="/view/NewStudent.jsp">Add Students</a>
<table border="10" cellpadding="10" cellspacing="10">
  <thead>
  <tr>
    <th>STT</th>
    <th>Name</th>
    <th>Age</th>
    <th colspan="2">Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${students}" var="s">
    <tr>
      <td>${s.id}</td>
      <td>${s.name}</td>
      <td>${s.age}</td>
      <td><a href="${pageContext.request.contextPath}/hello-servlet?action=EDIT&id=${s.id}">Edit</a></td>
      <td><a onclick="return confirm('Do you want to delete this students')" href="${pageContext.request.contextPath}/hello-servlet?action=DELETE&id=${s.id}">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
