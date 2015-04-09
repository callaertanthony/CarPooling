<%--
  Created by IntelliJ IDEA.
  User: Guillaume
  Date: 31/03/2015
  Time: 12:34
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

    <title>Oops..</title>

    <!-- Bootstrap core CSS -->
    <link href="<spring:url value="/css/bootstrap.css"/> " rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<spring:url value="/css/main.css"/> " rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="<spring:url value="/js/html5shiv.js"/>"></script>
    <![endif]-->

    <script type="text/javascript" src="<spring:url value="/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/scripts.js"/>"></script>
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
                <h1>Ooops, une erreur a eu lieu.<br/></h1>
                <c:if test="${null != exception}">
                    <p>
                        ${exception.getMessage()}
                    </p>
                </c:if>
                <a href="${pageContext.request.contextPath}/" class="btn btn-warning btn-lg" role="button">Me ramener en lieu sûr!</a>
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
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="<spring:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>
