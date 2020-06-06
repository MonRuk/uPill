
<%--
  Created by IntelliJ IDEA.
  User: monika
  Date: 19.04.2020
  Time: 07:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Log in</title>
</head>
<body>
<form method="post">
    <h2>Zaloguj się</h2>
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<p>
<div>Nie masz jeszcze konta? <a href="/uPill/register">Zarejestruj się</a> </div>
</p>
</body>
</html>