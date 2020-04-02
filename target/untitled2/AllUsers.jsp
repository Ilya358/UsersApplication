<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 31.03.2020
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users Application</title>
</head>
<body>
<center>
    <h1>
        <a href="/untitled2_war_exploded/add">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/untitled2_war_exploded/all">List All Users</a>

    </h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.surname}" /></td>
                <td>
                    <a href="/untitled2_war_exploded/update?id=<c:out value='${user.id}' />">Update</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/untitled2_war_exploded/delete?id=<c:out value='${user.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
