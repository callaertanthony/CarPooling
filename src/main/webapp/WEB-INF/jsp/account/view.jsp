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
    <link href="../../css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../../css/main.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fonts from Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,900' rel='stylesheet' type='text/css'>

    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/scripts.js"></script>
</head>
<!------------------------------------------------
                HEADER NAVBAR
------------------------------------------------>
<jsp:include page="../core/navbar.jsp" />

<div id="headerwrap">
    <div class="container">
        <div>
            <c:choose>
                <c:when test="${user.getPicturePath() != null }">
                    <img src="../../users/photos/${user.getPicturePath()}" alt="profil photo" class="img-circle pull-right"/>
                </c:when>
                <c:otherwise>
                    <img src="../../users/photos/man.gif" alt="profil photo" class="img-circle pull-right"/>
                </c:otherwise>
            </c:choose>
            <br />
        </div>
        <h1 class="text-center">Votre profil</h1>
        <h2 class="text-center">"${user.getFirstName()} ${user.getLastName()}".</h2>

        <table class="table textWhite">
            <tr>
                <td>Id : </td>
                <td>${user.getId()}</td>
            </tr>
            <tr>
                <td>Prénom: </td>
                <td>${user.getFirstName()}</td>
            </tr>
            <tr>
                <td>Nom : </td>
                <td>${user.getLastName()}</td>
            </tr>
            <tr>
                <td>Email : </td>
                <td>${user.getEmail()}</td>
            </tr>
            <tr>
                <td>Gender : </td>
                <td>${user.getGender()}</td>
            </tr>

        </table>
        <div style="text-align:center;">
            <div class="btn-group" role="group" style="text-align: center;">
                <a href="<c:url value="/account/edit/${user.getId() }"/>">
                    <button type="button" class="btn btn-default">Edit</button>
                </a>
                <a href="<c:url value="/account/remove/${user.getId() }"/>">
                    <button type="button" class="btn btn-default">Remove</button>
                </a>
            </div>
        </div>
    </div>
</div><!-- /headerwrap -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

