<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welcome at uPill</title>
</head>
<body>
<h1>Witaj ${user.username}!</h1>
<p>Twoje leki:</p>
<c:forEach items="${user.meds}" var="m">
    <p>Nazwa: ${m.name}</p>
    <p>Na receptę: ${m.forPrescription}</p>
    <p>Jednostka: ${m.measureUnit}</p>
    <p>Jednostka: ${m.dosage}</p>
</c:forEach>

<%--<a href="/category/delete/${c.id}">Delete</a>
<a href="/category/update/${c.id}">Edit</a>--%>
<hr/>

</body>
</html>

