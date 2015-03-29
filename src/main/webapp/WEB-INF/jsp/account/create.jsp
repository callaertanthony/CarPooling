<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 26/03/15
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create an account</title>
</head>
<body>

<form:form name="form" method="post" action="" modelAttribute="form">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div>
        <form:label path="email">Email address</form:label>
        <form:input type="email" value="${form.email}" required="true" path="email"/>
    </div>
    <div>
        <form:errors/>
        <form:label for="password" path="password">Password</form:label>
        <form:input type="password" name="password" id="password" required="true" path="password"/>
    </div>
    <div>
        <form:label for="passwordRepeated" path="passwordRepeated">Repeat</form:label>
        <form:input type="password" name="passwordRepeated" id="passwordRepeated" required="true" path="passwordRepeated"/>
    </div>
    <div>
        <form:label for="firstName" path="firstName">First name</form:label>
        <form:input type="text" name="firstName" id="firstName" required="true" path="firstName"/>
    </div>
    <div>
        <form:label for="lastName" path="lastName">Last name</form:label>
        <form:input type="text" name="lastName" id="lastName" required="true" path="lastName"/>
    </div>
    <div>
        <form:label for="gender" path="gender">Gender</form:label>
        <form:select name="gender" id="gender" required="true" path="gender">
            <form:option value="MAN"/>
            <form:option value="WOMEN"/>
        </form:select>
    </div>
    <button type="submit">Save</button>
</form:form>

</body>
</html>
