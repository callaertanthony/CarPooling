<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 31/03/15
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Détail du trajet</title>

    <link href="<spring:url value="/css/bootstrap.css"/> " rel="stylesheet">  <!-- Bootstrap core CSS -->
    <link href="<spring:url value="/css/main.css"/> " rel="stylesheet">       <!-- Custom styles for this template -->
    <link href="<spring:url value="/css/timeline.css"/> " rel="stylesheet">  <!-- Custom style for the timeline -->

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src='<spring:url value="/js/html5shiv.js"/>'></script>
    <![endif]-->
</head>

<body>
    <!------------------------------------------------
                    HEADER NAVBAR
    ------------------------------------------------>
    <jsp:include page="../core/navbar.jsp" />

    <div id="headerwrap">
        <div class="container">
            <div class="row col-lg-2"></div>
            <div class="row col-lg-6">
                <form:form name="journeyForm" modelAttribute="journeyForm" method="post">
                    <ul id="user-journey" class="timeline-centered list-unstyled">
                        <c:import url="step.jsp" var="stepTemplate">
                            <c:param name="cities" value="${cities}"/>
                        </c:import>

                        <!-- we show 1 default start step -->
                        ${stepTemplate}

                        <li class="timeline-entry begin ui-state-disabled">
                            <div class="timeline-entry-inner">
                                <div class="timeline-icon">
                                    <a id="add-new-step" href="#" data-template="<c:out value="${stepTemplate}"/>">
                                        <i class="glyphicon glyphicon-plus"></i>
                                    </a>
                                </div>
                            </div>
                        </li>
                    </ul>
                <button type="submit" class="btn btn-warning btn-lg">Créer le trajet</button>
                </form:form>

            </div>
            <div class="row col-lg-4">
                <div id="map-canvas" style="height: 400px;">
                    Please wait during map is loading.
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery-ui.min.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/bootstrap.min.js"/>"></script>
    <script src="https://maps.googleapis.com/maps/api/js?libraries=places&sensor=false&key=AIzaSyC7CeEiotpx6dQBasBgb-ENCDAqTpHkhNQ"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery.geocomplete.min.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/scripts.js"/>"></script>
</body>
</html>