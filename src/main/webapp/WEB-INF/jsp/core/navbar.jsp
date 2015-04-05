<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  userConnected: Guillaume
  Date: 30/03/2015
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><b>Carpooling</b></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication property="principal.user" var="userConnected" />
                    <spring:url var="logoutUrl" value="/logout"/>
                    <li>
                        <form:form action="${logoutUrl}" method="post" class="form-inline left">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"  class="form-control"/>
                            <button type="submit" class="submitLink">Se déconnecter</button>
                        </form:form>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/account/view/${userConnected.getId()}">Mon compte (${userConnected.getFirstName()} ${userConnected.getLastName()})</a></li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <sec:authentication property="principal" />
                    <li><a href="<spring:url value="/login"/>">Se connecter?</a></li>
                    <li><a href="<spring:url value="/account/create"/>">S'enregistrer?</a></li>
                </sec:authorize>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>