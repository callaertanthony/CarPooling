<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 31/03/15
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create journey</title>
</head>
<body>
  <form:form name="journeyForm" modelAttribute="journeyForm" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <button type="submit" class="btn btn-warning btn-lg">Créer le trajet</button>
  </form:form>
</body>
</html>
