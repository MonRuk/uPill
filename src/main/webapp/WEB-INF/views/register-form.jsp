<%--
  Created by IntelliJ IDEA.
  User: monika
  Date: 19.04.2020
  Time: 07:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Welcome at uPill</title>
</head>
<body>
<h1>Zarejestruj się</h1>
<h3>To zajmie tylko chwilę</h3>

<form:form method="post" modelAttribute="user" action="/uPill/register">
    <form:label path="username">Username:</form:label>
    <form:input path="username"/>

    <form:label path="email">Email:</form:label>
    <form:input path="email"/>

    <form:label path="password">Password:</form:label>
    <form:password path="password"/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>

