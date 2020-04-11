<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 11.04.2020
  Time: 2:25
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
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of User</h2></caption>
        <tr>
            <th>ID</th>
            <th>Role</th>
            <th>Name</th>
            <th>Password</th>
            <th>Surname</th>
            <th>Actions</th>
        </tr>
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.role}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td><c:out value="${user.surname}" /></td>
                <td>
                    <a href="/untitled2_war_exploded/userUpdate?id=<c:out value='${user.id}' />">Update</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/untitled2_war_exploded/userDelete?id=<c:out value='${user.id}' />">Delete</a>
                </td>
            </tr>
    </table>
</div>
</body>
</html>
