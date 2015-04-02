
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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Trajets</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">  <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">       <!-- Custom styles for this template -->

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/html5shiv.js"></script>
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

                <h1 class="text-center"> ${journeys[0].getSteps()[0].getCity().getName()} -> ${journeys[0].getSteps()[fn:length(journeys[0].getSteps())-1].getCity().getName()}</h1> <!-- TODO -->
                <c:forEach items="${journeys}" var="journey">
                    <article class="container well">
                        <div class="row user-menu-container square">
                            <div class="col-md-4 user-details">
                                <div class="row coralbg white">
                                    <div class="col-md-6 no-pad">
                                        <div class="user-pad">
                                            <h3>UserName</h3>
                                            <h4 class="white">Lille</h4>
                                            <h4 class="white">Lorem Ipsum</h4>
                                            <button type="button" class="btn btn-labeled btn-info" href="#">Voir le profil</button>
                                        </div>
                                    </div>
                                    <div class="col-md-6 no-pad">
                                        <div class="user-image">
                                            <img src="http://media.cargocollective.com/1/0/16982/headerimg/Jxnblk-ShortHair-Circle.png" class="img-responsive thumbnail">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-8 user-menu user-pad">
                                <div class="user-menu-content">
                                    <div class="col-md-10 no-pad">
                                        Départ: ${journey.getFirstStep().getCity().getName()} <br />
                                        Arrivée: ${journey.getLastStep().getCity().getName()} <br />
                                        <br />
                                        Les étapes:<br />
                                        <c:forEach items="${journey.getSteps()}" var="step">
                                            <fmt:formatDate value="${step.getDateCalendar().getTime()}" var="formattedDate" type="date" pattern="MM-dd-yyyy" />
                                            <span>
                                                ${step.getCity().getName()} <span>(${formattedDate})</span>
                                            </span>
                                            <br>
                                        </c:forEach>

                                        <button type="button" class="btn btn-labeled btn-success" href="#">Details</button>
                                    </div>
                                    <div class=" col-md-2 no-pad">
                                        test
                                    </div>
                                </div>
                            </div>
                        </div>
                    </article>
                </c:forEach>
            </div>
        </div><!-- /row -->
    </div><!-- /container -->
</div><!-- /headerwrap -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</body>
</html>