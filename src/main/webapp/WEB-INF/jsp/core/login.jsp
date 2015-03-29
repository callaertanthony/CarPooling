<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 29/03/15
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="error">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

  <div>
    <label for="email">Email address</label>
    <input type="email" name="email" id="email" required autofocus/>
  </div>
  <div>
    <label for="password">Password</label>
    <input type="password" name="password" id="password" required/>
  </div>
  <div>
    <label for="remember-me">Remember me</label>
    <input type="checkbox" name="remember-me" id="remember-me"/>
  </div>

  <button type="submit">Sign in</button>
</form:form>
</body>
</html>
