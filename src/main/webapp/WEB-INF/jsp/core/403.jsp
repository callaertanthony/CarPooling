<%--
  Created by IntelliJ IDEA.
  User: Guillaume
  Date: 31/03/2015
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Halte-là!</title>

    <link href="<spring:url value="/css/bootstrap.css"/> " rel="stylesheet"> <!-- Bootstrap core CSS -->
    <link href="<spring:url value="/css/main.css"/> " rel="stylesheet"> <!-- Custom styles for this template -->

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="<spring:url value="/js/html5shiv.js"/>"></script>
    <![endif]-->
</head>

<body>
    <!------------------------------------------------
                    HEADER NAVBAR
    ------------------------------------------------>
    <jsp:include page="navbar.jsp" />

    <div id="headerwrap">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <h1>Désolé, vous ne disposez pas des autorisations suffisantes pour accéder à cette page.<br/></h1>
                    <a href="<spring:url value="/"/>" class="btn btn-warning btn-lg" role="button">Me ramener à la route connue la plus proche.</a>
                </div><!-- /col-lg-6 -->
                <div class="col-lg-6">
                    <img class="img-responsive" src="<spring:url value="/img/Logo_carpool-unhappy.png"/>" alt=""/>
                </div><!-- /col-lg-6 -->
            </div><!-- /row -->
        </div><!-- /container -->
    </div><!-- /headerwrap -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="<spring:url value="/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/scripts.js"/>"></script>
</body>
</html>