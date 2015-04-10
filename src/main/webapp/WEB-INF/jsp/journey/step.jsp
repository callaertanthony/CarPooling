<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 01/04/15
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<li class="timeline-entry">
    <div class="timeline-entry-inner">
        <span class="timeline-time">
            <button type="button" class="btn btn-danger btn-sm deleteStep">Remove</button>
        </span>
        <div class="timeline-icon bg-success">
            <i class="entypo-feather"></i>
        </div>
        <div class="timeline-label">
            <input id="geocomplete[__index__]" type="text" class="geocomplete form-control"/>
            <fmt:formatDate value="${todayDate}" var="formattedDate" type="both" pattern="yyyy-MM-dd" />
            <input id="steps[__index__].date" name="steps[__index__].date" type="date" required="true" min="${formattedDate}" value="${formattedDate}" onchange="calcJourney()" class="form-control"/>
            <input id="steps[__index__].time" name="steps[__index__].time" type="time" required="true" value="12:00:00" onchange="calcJourney()" class="form-control"/>
            <input name="steps[__index__].lat" data-geo="lat" type="hidden" value="" class="form-control">
            <input name="steps[__index__].lng" data-geo="lng" type="hidden" value="" class="form-control">
            <input name="steps[__index__].locality" data-geo="locality" type="hidden" value="">
        </div>
    </div>
</li>