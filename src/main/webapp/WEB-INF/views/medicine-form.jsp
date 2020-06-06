<%--
  Created by IntelliJ IDEA.
  User: monika
  Date: 19.04.2020
  Time: 07:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Welcome at uPill</title>
</head>
<body>
<h1>Dodaj lek</h1>

<form:form method="post" modelAttribute="medicine" action="/uPill/user/meds/add">
    <form:label path="name">Nazwa:</form:label>
    <form:input path="name"/>

    <form:label path="forPrescription">Na receptę:</form:label>
    <form:checkbox path="forPrescription"/>
    <form:label path="measureUnit">Postać leku:</form:label>
    <form:input path="measureUnit"/>

    <form:label path="dosage">Ile dziennie bierzesz?</form:label>
    <form:input path="dosage"/>

 <%--   <form:label path="stock">Jaki jest zapas leku?</form:label>
    <form:input path="stock"/>--%>
    <form:hidden path="id"/>
    <form:hidden path="${user.id}" itemValue="user_id"/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
