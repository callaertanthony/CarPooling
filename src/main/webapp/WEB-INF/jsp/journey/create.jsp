<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
${cities}
  <form:form name="journeyForm" modelAttribute="journeyForm" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <c:forEach var="i" begin="1" end="5">
        <jsp:include page="step.jsp"/>
    </c:forEach>
    <button type="submit" class="btn btn-warning btn-lg">Créer le trajet</button>
  </form:form>
</body>
</html>
