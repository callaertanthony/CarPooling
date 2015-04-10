<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                    <h1>Trouver un trajet<br/></h1>
                    <form:form name="form" action="${pageContext.request.contextPath}/journey/search" method="post" modelAttribute="form" class="form-horizontal">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <div class="form-group">
                            <form:label for="departure" path="departure" class="col-xs-2 control-label">De </form:label>
                            <div class="col-xs-10">
                                <input type="text" id="departure" required="true" class="form-control geocomplete" placeholder="Entrez une ville de départ" autocomplete="off">
                                <input id="departure-hidden" name="departure" data-geo="locality" type="hidden" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label for="arrival" path="arrival" class="col-xs-2 control-label">Vers</form:label>
                            <div class="col-xs-10">
                                <input type="text" id="arrival" required="true" class="form-control geocomplete" placeholder="Entrez une ville d'arrivé" autocomplete="off">
                                <input id="arrival-hidden" name="arrival" data-geo="locality" type="hidden" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-offset-2 col-xs-10">
                                <form:errors/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-offset-2 col-xs-10">
                                <button type="submit" class="btn btn-warning btn-lg">Chercher</button>
                            </div>
                        </div>
                    </form:form>

                <h1>Publier un trajet<br/></h1>
                <a class="btn btn-warning btn-lg" href="<spring:url value="/journey/create"/>" role="button">Publier</a>
            </div><!-- /col-lg-6 -->
            <div class="col-lg-6">
                <img class="img-responsive" src="<spring:url value="/img/Logo_carpool.png"/>" alt="">
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
<script src="https://maps.googleapis.com/maps/api/js?libraries=places&sensor=false&key=AIzaSyC7CeEiotpx6dQBasBgb-ENCDAqTpHkhNQ"></script>
<script type="text/javascript" src="<spring:url value="/js/jquery.geocomplete.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/js/home.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/js/reset-search-inputs.js"/>"></script>
</body>
</html>
