<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 30/03/15
  Time: 20:36
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

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fonts from Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,900' rel='stylesheet' type='text/css'>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<!------------------------------------------------
                HEADER NAVBAR
------------------------------------------------>
<jsp:include page="../core/navbar.jsp" />

<div id="headerwrap">
    <div class="container">

        <!-- Display the profile picture or the default picture if user doesn't have any -->
        <c:choose>
            <c:when test="${not empty userSeen.getPicturePath()}">
                <img src="${pageContext.request.contextPath}/users/photos/${userSeen.getPicturePath()}" alt="profil photo" class="img-circle pull-right"/>
            </c:when>
            <c:otherwise>
                <img src="${pageContext.request.contextPath}/users/photos/man.gif" alt="profil photo" class="img-circle pull-right"/>
            </c:otherwise>
        </c:choose>
        <!-- Lookng if the profile visualised is the profile of our currently logged user -->
        <c:choose>
            <c:when test="${userSeen.getId() == userConnected.getId()}">
                <h1>Votre profil:</h1>
            </c:when>
            <c:otherwise>
                    <h1>Profil de:</h1>
            </c:otherwise>
        </c:choose>

        <h2 class="">${userSeen.getFirstName()} ${userSeen.getLastName()}</h2>

        <table class="table textWhite">
            <tr>
                <td>Email: </td>
                <td>${userSeen.getEmail()}</td>
            </tr>
            <tr>
                <td>Sexe: </td>
                <td>${userSeen.getGender()}</td>
            </tr>

        </table>
        <!-- If the profile is owned by the connected user, allow edition & remove -->
        <c:if test="${userSeen.getId() == userConnected.getId()}">
        <div style="text-align:center;">
            <div class="btn-group" role="group" style="text-align: center;">
                <a href="${pageContext.request.contextPath}/account/modify">
                    <button type="button" class="btn btn-default">Modifier</button>
                </a>
                <a href="<c:url value="${pageContext.request.contextPath}/account/remove/${userConnected.getId() }"/>">
                    <button type="button" class="btn btn-default">Supprimer</button>
                </a>
            </div>
        </div>
        </c:if>
    </div>
</div><!-- /headerwrap -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>

