<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 10.04.2020
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<center>
    <h1>
        <a href="/untitled2_war_exploded/login">Login</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/untitled2_war_exploded/registration">Registration</a>
    </h1>
</center>
<div align="center">
    <form action="login" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Login User</h2>
            </caption>
            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
            <input type="hidden" name="role" value="<c:out value='${user.role}' />" />
            <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45" placeholder="Name"
                           value="<c:out value='${user.name}' />"
                    />
                </td>
            </tr>
            <tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45" placeholder="Password"
                           value="<c:out value='${user.password}' />"
                    />
                </td>
            </tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Submit" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
