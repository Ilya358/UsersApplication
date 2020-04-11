<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 11.04.2020
  Time: 2:30
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
        <a href="/untitled2_war_exploded/adminAdd">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/untitled2_war_exploded/adminAll">Users List</a>

    </h1>
</center>
<div align="center">
    <form action="adminUpdate" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Update Users</h2>
            </caption>
            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
            <tr>
                <th>Role: </th>
                <td>
                    <input type="text" name="role" size="45"
                           value="<c:out value='${user.role}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45"
                           value="<c:out value='${user.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${user.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Surname: </th>
                <td>
                    <input type="text" name="surname" size="45"
                           value="<c:out value='${user.surname}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Submit" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
