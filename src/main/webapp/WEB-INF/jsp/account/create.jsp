<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 26/03/15
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Carpooling</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/main.css" rel="stylesheet">

    <!-- Fonts from Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,900' rel='stylesheet' type='text/css'>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
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
            <div class="col-lg-6">
                <h1>Créer mon compte<br/></h1>
                <form:form name="form" action="" method="post" modelAttribute="form" class="form-horizontal">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <div class="form-group">
                        <form:label for="email" path="email" class="col-sm-4 control-label">Email</form:label>
                        <div class="col-sm-8">
                            <form:input type="email" name="email" value="${form.email}" id="email" required="true" path="email" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label for="password" path="password" class="col-sm-4 control-label">Mot de passe</form:label>
                        <div class="col-sm-8">
                            <form:input type="password" name="password" id="password" required="true" path="password" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label for="passwordRepeated" path="passwordRepeated" class="col-sm-4 control-label">Confirmer</form:label>
                        <div class="col-sm-8">
                            <form:input type="password" name="passwordRepeated" id="passwordRepeated" required="true" path="passwordRepeated" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label for="firstName" path="firstName" class="col-sm-4 control-label">Prénom</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" name="firstName" id="firstName" required="true" path="firstName" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label for="lastName" path="lastName" class="col-sm-4 control-label">Nom</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" name="lastName" id="lastName" required="true" path="lastName" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label for="gender" path="gender" class="col-sm-4 control-label">Sexe</form:label>
                        <div class="col-sm-8">
                            <form:select name="gender" id="gender" required="true" path="gender"  class="form-control">
                                <form:option value="MAN">Homme</form:option>
                                <form:option value="WOMAN">Femme</form:option>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <form:errors/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-warning btn-lg">Créer le compte</button>
                        </div>
                    </div>
                </form:form>
            </div><!-- /col-lg-6 -->
            <div class="col-lg-6">
                <img class="img-responsive" src="../img/Logo_carpool.png" alt="">
            </div><!-- /col-lg-6 -->

        </div><!-- /row -->
    </div><!-- /container -->
</div><!-- /headerwrap -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>