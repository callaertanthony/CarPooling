<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 27/03/15
  Time: 08:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:forEach items="${users}" var="user">
        <p>${user}</p><br/>
    </c:forEach>
</body>
</html>
