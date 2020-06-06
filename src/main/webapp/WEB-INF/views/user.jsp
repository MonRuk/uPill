<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welcome at uPill</title>
</head>
<body>
<h1>Witaj ${user.username}!</h1>
<p>
<div><a href="/uPill/user/meds/add">Dodaj lek</a></div>
<p>
<div>    <a href="/uPill/user/stock/add">Dodaj zapas</a></div>
</p>
<p>
<div>    <a href="/uPill/user/meds/list">Lista leków</a></div>
</p>
<p>
<div>    <a href="/uPill/user/stock/list">Lista zapasów</a></div>
</p>
<p>
<div>    <a href="/uPill/user/details">Szczegóły konta</a></div>
</p>
<p>
<div>    <a href="/uPill/logout">Wyloguj się</a></div>
</p>
</body>
</html>

