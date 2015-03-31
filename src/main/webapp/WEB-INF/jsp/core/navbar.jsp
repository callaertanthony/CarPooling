<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <c:choose>
                    <c:when test="${null != userConnected}">
                        <form:form action="${pageContext.request.contextPath}/logout" method="post" class="form-inline left">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"  class="form-control"/>
                            <button type="submit" class="submitLink">Se déconnecter</button>
                        </form:form>
                        <li><a href="${pageContext.request.contextPath}/account/view/${userConnected.getId()}">Mon compte</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/login">Se connecter?</a></li>
                        <li><a href="${pageContext.request.contextPath}/account/create">S'enregistrer?</a></li>

                    </c:otherwise>
                </c:choose>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>