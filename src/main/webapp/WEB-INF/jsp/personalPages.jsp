<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>page perso</title>
</head>
<body>
<h1>page personnel "${user.name}" "${user.lastName}"</h1>

<h2> mes commentaires</h2>

<table border="1">
    <TR>
        <th>utilisateur</th>
        <th>date</th>
        <th>commentaire</th>

        <c:forEach items="${user.commentaires}" var="commentaire">

    <tr>
        <td>${commentaire.user.username}</td>
        <td>${commentaire.date}</td>
        <td>${commentaire.commentaireText}</td>
            <th><a href="/editCommentaire/${commentaire.id}" class="btn btn-success">Modifier</a></th>
            <th><a href="/deleteCommentaire/${commentaire.id}" class="btn btn-success">suprimer</a></th>
    </tr>
    </TR>
    </c:forEach>
</table>

<h2> mes secteurs</h2>

<TABLE BORDER="1">
    <TR>
        <TH>nom du secteur</TH>
        <TH>voies</TH>
        <TH>hauteur max</TH>
        <TH>equipment</TH>
        <TH>type de roche</TH>
        <TH>Information additionnelle</TH>

        <c:forEach items="${user.secteurs}" var="secteur">

    <tr>
        <td>${secteur.nameSecteur}</td>
        <td>${secteur.voies}</td>
        <td>${secteur.heightMax}</td>
        <td>${secteur.equipment}</td>
        <td>${secteur.typeOfSockets}</td>
        <td>${secteur.additionalInformation}</td>
            <th><a href="/editSecteur/${secteur.id}" class="btn btn-success">Modifier</a></th>
            <th><a href="/deleteSecteur/${secteur.id}" class="btn btn-success">suprimer</a></th>
    </tr>
    </TR>
    </c:forEach>
</TABLE>

<h2> mes topos</h2>

<TABLE BORDER="1">
    <TR>
        <TH>name</TH>
        <TH>description</TH>
        <TH>places</TH>
        <TH>releaseDate</TH>


        <c:forEach items="${user.userWithTopo}" var="topo">

    <tr>
        <td>${topo.name}</td>
        <td>${topo.description}</td>
        <td>${topo.places}</td>
        <td>${topo.releaseDate}</td>
            <th><a href="editTopo/${topo.id}" class="btn btn-success">Modifier</a></th>
            <th><a href="deleteTopo/${topo.id}" class="btn btn-success">suprimer</a></th>
        <th><a href="topo/${topo.id}" class="btn btn-success">site</a></th>
    <c:if test="${topo.available.equals(false) && topo.confirmReservation.equals(false)}">
        <th><div class="col-sm"><a href="acceptReservation/${topo.id}" class="btn btn-secondary">Reserver Topo</a></div></th>
            <th><a href="refuseReservation/${topo.id}" class="btn btn-danger">Refuser reservation</a></th>
    </c:if>

</tr>
    </TR>
    </c:forEach>
</TABLE>
</body>
</html>
