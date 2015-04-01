<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 31/03/15
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Détail du trajet</title>

    <link href="../../css/bootstrap.css" rel="stylesheet">  <!-- Bootstrap core CSS -->
    <link href="../../css/main.css" rel="stylesheet">       <!-- Custom styles for this template -->
    <link href="../../css/timeline.css" rel="stylesheet">  <!-- Custom style for the timeline -->

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="../../js/html5shiv.js"></script>
    <![endif]-->
</head>

<body>
    <!------------------------------------------------
                    HEADER NAVBAR
    ------------------------------------------------>
    <jsp:include page="../core/navbar.jsp" />

    <div id="headerwrap">
        <div class="container">
            <div class="row col-lg-9">
                <form:form name="journeyForm" modelAttribute="journeyForm" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div id="user-journey" class="timeline-centered">

                    <article class="timeline-entry">
                        <div class="timeline-entry-inner">
                            <time class="timeline-time" datetime="2014-01-10T03:45"><span>00-00-00</span></time>
                            <div class="timeline-icon bg-success">
                                <i class="entypo-feather"></i>
                            </div>
                            <div class="timeline-label">
                                <form:select path="steps[0].city">
                                    <form:options items="${cities}" itemValue="id" itemLabel="name"/>
                                </form:select>
                                <form:input path="steps[0].date" type="time" required="true"/>
                            </div>
                        </div>
                    </article>

                    <article class="timeline-entry begin">
                        <div class="timeline-entry-inner">
                            <div class="timeline-icon">
                                <a id="add-new-step" href="#">
                                    <i class="glyphicon glyphicon-plus"></i>
                                </a>
                            </div>
                        </div>
                    </article>
                </div>
                <button type="submit" class="btn btn-warning btn-lg">Créer le trajet</button>
                </form:form>

            </div>
            <div class="row col-lg-3" style="height: 400px;">
                <p>ZONE DE TEST:u</p>
                <form:form name="journeyForm" modelAttribute="journeyForm" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <c:forEach var="i" begin="1" end="5">
                        <jsp:include page="step.jsp">
                            <jsp:param name="y" value="${i}" />
                        </jsp:include>
                    </c:forEach>
                    <button type="submit" class="btn btn-warning btn-lg">Créer le trajet</button>
                </form:form>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/scripts.js"></script>
</body>
</html>