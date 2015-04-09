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
    <script src="<spring:url value="/js/html5shiv.js"/>"></script>
    <![endif]-->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/bootstrap.min.js"/>"></script>
    <script src="https://maps.googleapis.com/maps/api/js?libraries=places&sensor=false&key=AIzaSyC7CeEiotpx6dQBasBgb-ENCDAqTpHkhNQ"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery.geocomplete.min.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/map-utils.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/journey-view-gmap.js"/>"></script>
</head>

<body>
    <!------------------------------------------------
                    HEADER NAVBAR
    ------------------------------------------------>
    <jsp:include page="../core/navbar.jsp" />

    <div id="headerwrap">
        <div class="container">
            <div class="row col-lg-6">
                <div class="timeline-centered">
                    <script type="text/javascript">
                        setTotal(${journey.getSteps().size()});
                    </script>
                    <c:forEach items="${journey.getSteps()}" var="step">
                        <fmt:formatDate value="${step.dateCalendar.time}" var="formattedDate" type="both" pattern="MM-dd-yyyy" />
                        <article class="timeline-entry">
                            <div class="timeline-entry-inner">
                                <time class="timeline-time" datetime="2014-01-10T03:45"><span>${formattedDate}</span></time>
                                <div class="timeline-icon bg-success">
                                    <i class="entypo-feather"></i>
                                </div>
                                <div class="timeline-label">
                                    <h2><a href="#">${step.getCity().getLocality()}</a></h2>
                                    <p></p>
                                    <script type="text/javascript">
                                        addStepToArray(${step.getCity().getLatitude()},${step.getCity().getLongitude()});
                                    </script>
                                </div>
                            </div>
                        </article>
                    </c:forEach>

                    <article class="timeline-entry begin">
                        <div class="timeline-entry-inner">
                            <div class="timeline-icon" style="-webkit-transform: rotate(-90deg); -moz-transform: rotate(-90deg);">
                                <i class="glyphicon glyphicon-arrow-left"></i>
                            </div>
                        </div>
                    </article>
                </div>
            </div>
            <div class="row col-lg-6" style="height: 400px;">
                <div id="map-canvas" style="height: 400px;">
                    Please wait during map is loading.
                </div>
            </div>
        </div>
    </div>
</body>
</html>