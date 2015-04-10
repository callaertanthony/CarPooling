
<%--
  Created by IntelliJ IDEA.
  User: Guillaume
  Date: 31/03/2015
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Trajets</title>

    <link href="<spring:url value="/css/bootstrap.css"/> " rel="stylesheet">  <!-- Bootstrap core CSS -->
    <link href="<spring:url value="/css/main.css"/> " rel="stylesheet">       <!-- Custom styles for this template -->
    <link href="<spring:url value="/css/timeline.css"/> " rel="stylesheet">   <!-- Custom styles for timelines -->

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="<spring:url value="/js/html5shiv.js"/>"></script>
    <![endif]-->
</head>

<body>
<!------------------------------------------------
                HEADER NAVBAR
------------------------------------------------>
<jsp:include page="../core/navbar.jsp" />

<div id="headerwrap">
    <div class="container">
        <div class="row">
            <div class=".col-xs-12 .col-md-8">
                <c:choose>
                    <c:when test="${not empty error}">
                        <h1 class="error">${error}</h1>
                        <a class="btn btn-warning btn-lg" href="<spring:url value="/"/>" role="button">Refaire une recherche</a>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${null != journeys}">
                                <h1 class="text-center"> ${departure.getLocality()} -> ${arrival.getLocality()}</h1>
                                <c:forEach items="${journeys}" var="journey">
                                    <article class="container well" style="background-color: #eeeeee;">
                                        <div class="row user-menu-container square">
                                            <div class="col-md-4 user-details">
                                                <div class="row coralbg white">
                                                    <div class="col-md-6 no-pad">
                                                        <div class="user-pad">
                                                            <h3>${journey.getCreator().getFirstName()} ${journey.getCreator().getLastName()}</h3>
                                                            <span class="white">Sexe: ${journey.getCreator().getGender()}</span>
                                                            <a href="${pageContext.request.contextPath}/account/view/${journey.getCreator().getId()}">
                                                                <button type="button" class="btn btn-labeled btn-info">Voir le profil</button>
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6 no-pad">
                                                        <div class="user-image">
                                                            <c:choose>
                                                                <c:when test="${not empty journey.getCreator().getPicturePath()}">
                                                                    <img src="<spring:url value="/users/photos/${journey.getCreator().getPicturePath()}"/>" alt="profil photo" class="img-circle pull-right"/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <img src="<spring:url value="/users/photos/man.gif"/>" alt="profil photo" class="img-circle pull-right"/>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-8 user-menu user-pad">
                                                <div class="user-menu-content">
                                                    <div class="col-md-10 no-pad">
                                                        <div class="row bs-wizard" style="border-bottom:0;">
                                                            <c:set var="destinationReached" value="false"/>
                                                            <c:forEach items="${journey.getSteps()}" var="step">
                                                            <c:choose>
                                                            <c:when test="${destinationReached == true}">
                                                            <div class="col-xs-3 bs-wizard-step disabled" style="width: 16%;">
                                                                </c:when>
                                                                <c:otherwise>
                                                                <div class="col-xs-3 bs-wizard-step complete" style="width: 16%;">
                                                                </c:otherwise>
                                                                    </c:choose>
                                                                    <div class="text-center bs-wizard-stepnum">${step.getCity().getLocality()}</div>
                                                                    <div class="progress"><div class="progress-bar"></div></div>
                                                                    <c:if test="${journey.getFirstStep().getCity().getId() == step.getCity().getId()}">
                                                                        <div class="bs-wizard-info text-center">Départ</div>
                                                                    </c:if>
                                                                    <c:if test="${journey.getLastStep().getCity().getId() == step.getCity().getId()}">
                                                                        <div class="bs-wizard-info text-center">Arrivée</div>
                                                                    </c:if>
                                                                    <span class="bs-wizard-dot"></span>
                                                                </div>
                                                                <c:if test="${step.getCity().getId() == arrival.getId() && fn:length(journey.getSteps()) gt 2}">
                                                                    <c:set var="destinationReached" value="true"/>
                                                                </c:if>
                                                                </c:forEach>
                                                            </div>
                                                            <a href="<spring:url value="/journey/view/${journey.getId()}"/>">
                                                                <button type="button" class="btn btn-labeled btn-success">Details</button>
                                                            </a>
                                                        </div>
                                                        <div class=" col-md-2 no-pad">
                                                            Id: ${journey.getId()}
                                                            <a href="<spring:url value="/journey/book/${journey.getId()}"/>">
                                                                <button type="button" class="btn btn-labeled btn-success">Réserver</button>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                    </article>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <h1>Désolé, aucun trajet ne correspond à la recherche.</h1>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </div>
        </div><!-- /row -->
    </div><!-- /container -->
</div><!-- /headerwrap -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<spring:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/js/scripts.js"/>"></script>
</body>
</html>