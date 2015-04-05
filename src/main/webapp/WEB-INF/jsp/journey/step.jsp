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
    <time class="timeline-time" datetime="2014-01-10T03:45"><span>00-00-00</span></time>
    <div class="timeline-icon bg-success">
      <i class="entypo-feather"></i>
    </div>
    <div class="timeline-label">
      <select id="steps__index__.city" name="steps[__index__].city">
        <c:forEach items="${cities}" var="city">
          <option value="${city.id}">${city.name}</option>
        </c:forEach>
      </select>
      <fmt:formatDate value="${todayDate}" var="formattedDate" type="both" pattern="yyyy-MM-dd" />
      <input id="steps[__index__].date" name="steps[__index__].date" type="date" required="true" min="${formattedDate}" value="${formattedDate}"/>
      <input id="steps[__index__].time" name="steps[__index__].time" type="time" required="true"/>
    </div>
  </div>
</li>