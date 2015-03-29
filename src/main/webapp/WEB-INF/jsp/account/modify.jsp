<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 30/03/15
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify account</title>
</head>
<body>
<form name="form" method="post" action="">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

  <div>
    <label for="email">Email address</label>
    <input type="email" name="email" id="email" value="${form.email}" required autofocus/>
  </div>

  <button type="submit">Save</button>
</form>
</body>
</html>
