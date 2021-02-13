<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Les amis de l'escalade !!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body>
    <div class="jumbotron text-center" style="margin-bottom:0">
        <h1>Les amis de l'escalade</h1>
    </div>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"/>
        </button>
        <div class="container">
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/">Accueil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/sites">Sites</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/research">Recherche</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/topos">Topos</a>
                    </li>
                    <sec:authorize var="loggedIn" access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="/personalPages">Page personnelle</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize var="loggedIn" access="isAnonymous()">
                        <li class="nav-item">
                            <a class="nav-link" href="/login">Se connecter</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize var="loggedIn" access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="/logout">Se déconnecter</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize var="loggedIn" access="isAnonymous()">
                        <li class="nav-item">
                            <a class="nav-link" href="/registration">Inscription</a>
                        </li>
                    </sec:authorize>
                </ul>
            </div>
        </div>
    </nav>
</body>