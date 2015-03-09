<%--
  Created by IntelliJ IDEA.
  User: anthonycallaert
  Date: 23/02/15
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.3.2/css/bootstrap.min.css'>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Carpooling</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active">
                            <a href="#">S'inscrire</a>
                        </li>
                        <li>
                            <a href="user/login">Se connecter</a>
                        </li>
                        <li>
                            <a href="user/register"> Comment ça marche</a>
                        </li>
                    </ul>
                </div>

            </nav>
            <div class="jumbotron">
                <form role="search" id ="searchpath">
                    <input type="text" class="col-md-4 " value="De">
                    <input type="text" class="col-md-4" value="Vers">
                    <button type="submit" class="col-md-4">Rechercher</button>
                </form>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
            <h2>
                Infos pratiques
            </h2>
            <p>
                Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
            </p>
            <p>
                <a class="btn" href="#">View details »</a>
            </p>
        </div>
        <div class="col-md-4 column">
            <h2>
                A propos
            </h2>
            <p>
                Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
            </p>
            <p>
                <a class="btn" href="#">View details »</a>
            </p>
        </div>
        <div class="col-md-4 column">
            <h2>
                Carpooling news
            </h2>
            <p>
                Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
            </p>
            <p>
                <a class="btn" href="#">View details »</a>
            </p>
        </div>
    </div>
</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/2.1.3/jquery.min.js"></script>
</body>
</html>