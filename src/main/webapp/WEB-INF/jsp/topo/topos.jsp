<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <div class="jumbotron text-center">
        <h1>Liste de tous les topos disponible</h1>
    </div>
    <div class="table-responsive">

        <table class="table table-bordered">
            <tr>
                <th>name</th>
                <th>description</th>
                <th>places</th>
                <th>releaseDate</th>
                <sec:authorize access="hasAnyRole('ADMIN')">
                    <th>Modification</th>
                    <th>Suppression</th>
                </sec:authorize>
            </tr>

            <c:forEach items="${topo}" var="topo">
                <tr>
                    <th>${topo.name}</th>
                    <th>${topo.description}</th>
                    <th>${topo.places}</th>
                    <th>${topo.releaseDate}</th>
                    <sec:authorize access="hasAnyRole('ADMIN')">
                        <th><a href="editTopo/${topo.id}" class="btn btn-success">Modifier</a></th>
                        <th><a href="deleteTopo/${topo.id}" class="btn btn-success">suprimer</a></th>
                    </sec:authorize>

                    <c:if test="${topo.available.equals(true)}">
                        <th>
                            <div class="col-sm"><a href="bookingTopo/${topo.id}" class="btn btn-secondary">Reserver
                                Topo</a></div>
                        </th>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        <a class="button" href="addTopo" class="btn btn-secondary">Ajouter un topo </a><br>
    </div>
    <jsp:include page="../footer.jsp"/>
