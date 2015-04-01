<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 01/04/15
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:select path="steps[${param.y}].city">
  <form:options items="${cities}" itemValue="id" itemLabel="name"/>
</form:select>
<form:input path="steps[${param.y}].date" type="time" required="true"/>
