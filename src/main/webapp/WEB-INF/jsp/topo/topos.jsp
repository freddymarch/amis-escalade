<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <div class="jumbotron text-center">
        <h1>Liste de tous les topos disponible</h1>
    </div>
    <TABLE BORDER="1">
        <TR>
            <TH>name</TH>
            <TH>description</TH>
            <TH>places</TH>
            <TH>releaseDate</TH>


        <c:forEach items="${topos}" var="topo">

        <tr>
            <td>${topo.name}</td>
            <td>${topo.description}</td>
            <td>${topo.places}</td>
            <td>${topo.releaseDate}</td>

        <sec:authorize access="hasAnyRole('ADMIN')">
        <th><a href="editTopo/${topo.id}" class="btn btn-success">Modifier</a></th>
            <th><a href="deleteTopo/${topo.id}" class="btn btn-success">suprimer</a></th>
        </sec:authorize>
            <th><a href="topo/${topo.id}" class="btn btn-success">site</a></th>
        </tr>
        </TR>
        </c:forEach>
    </TABLE>
    <a class="button" href="addTopo" class="btn btn-secondary">Ajouter un topo </a><br>
</div>
</body>
</html>
