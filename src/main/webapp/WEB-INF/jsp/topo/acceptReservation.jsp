<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Acceptée réservation</title>
</head>
<body>
<div class="container">

    <h1>Reserver Topo</h1>
    <form:form method="POST" modelAttribute="topo" action="/acceptReservation">

        <form:input type="hidden" path="id"/>

        <p>Utilisateur id : ${topo.userWithTopo.id}</p>
        <p>Nom du topo : ${topo.name}</p>
        <p>Date de parution : ${topo.releaseDate}</p>
        <p>Lieu du topo : ${topo.places}</p>
        <p>Description : ${topo.description}</p>
        <p>Est disponible ? : ${topo.available}</p>
        <p>Nom du membre voulant reserver le topo : ${topo.userWithTopo.email}</p>

        <input type="submit" class="btn btn-success" value="Confirmer la réservation"/>
        <a class="btn btn-danger" href="/topos">Annuler la demande de réservation</a>

    </form:form>

</div>
</body>
</html>
