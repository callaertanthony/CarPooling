<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Carpooling</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/main.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

    <!-- Fonts from Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,900' rel='stylesheet' type='text/css'>

    <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
</head>

<body>
<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><b>Carpooling</b></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal != null}">
                        <form:form action="${pageContext.request.contextPath}/logout" method="post" class="form-inline left">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"  class="form-control"/>
                            <button type="submit" class="submitLink">Se déconnecter</button>
                        </form:form>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/login">Se connecter?</a></li>
                    </c:otherwise>
                </c:choose>

                <li><a href="${pageContext.request.contextPath}/register">S'enregister?</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div id="headerwrap">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <h1>Trouver un trajet<br/></h1>
                <form class="form-inline" role="form">
                    <div class="form-group">
                        <input type="text" class="form-control" id="from" placeholder="De">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="to" placeholder="Vers">
                    </div>
                    <button type="submit" class="btn btn-warning btn-lg">Chercher!</button>
                </form>

                <h1>Publier un trajet<br/></h1>
                <form class="form-inline" role="form">
                    <div class="form-group">
                        <input class="btn btn-lg" TYPE="button" VALUE="Publier une annonce" onclick="window.location.href='${pageContext.request.contextPath}/publish'">
                    </div>
                </form>
            </div><!-- /col-lg-6 -->
            <div class="col-lg-6">
                <img class="img-responsive" src="img/Logo_carpool.png" alt="">
            </div><!-- /col-lg-6 -->

        </div><!-- /row -->
    </div><!-- /container -->
</div><!-- /headerwrap -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
