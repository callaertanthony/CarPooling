<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 27/03/15
  Time: 08:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Profil</title>

    <link href="<spring:url value="/css/bootstrap.css"/> " rel="stylesheet"> <!-- Bootstrap core CSS -->
    <link href="<spring:url value="/css/main.css"/> " rel="stylesheet"> <!-- Custom styles for this template -->

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <![endif]-->
</head>
<!------------------------------------------------
                HEADER NAVBAR
------------------------------------------------>
<jsp:include page="../../core/navbar.jsp" />

<div id="headerwrap">
    <div class="container">
        <table class="table textWhite">
            <tr>
                <th>Id</th>
                <th>Prénom</th>
                <th>Nom</th>
                <th>Mail</th>
                <th>Sexe</th>
                <th>Droits</th>
                <th>Editer</th>
                <th>Supprimer</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>
                        <a href="<c:url value="${pageContext.request.contextPath}/account/view/${user.getId()}"/>">
                            ${user.getId()}
                        </a>
                    </td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getGender()}</td>
                    <td>${user.getRole()}</td>
                    <td><a href="<c:url value="${pageContext.request.contextPath}/crud/user/edit/${user.getId() }"/>"><span class="glyphicon glyphicon-pencil"/></a></td>
                    <td><a href="<c:url value="${pageContext.request.contextPath}/crud/user/remove/${user.getId() }"/>"><span class="glyphicon glyphicon-trash"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div><!-- /headerwrap -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="<spring:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/js/scripts.js"/>"></script>
</body>
</html>