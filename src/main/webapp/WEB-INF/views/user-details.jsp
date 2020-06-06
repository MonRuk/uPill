<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welcome at uPill</title>
</head>
<body>
<h1>Witaj ${user.username}!</h1>
<p>Twoje dane:</p>
<p>Nazwa użytkownika: ${user.username}</p>
<p>Email: ${user.email}</p>

<%--<a href="/category/delete/${c.id}">Delete</a>
<a href="/category/update/${c.id}">Edit</a>--%>
<hr/>

</body>
</html>

