<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>site</title>
</head>
<body>
<h2>Secteurs :</h2>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Informations du site d'escalade "${site.nom}"</h1>
</div>

<div>

</div><br/>

<TABLE BORDER="1">
<TR>
    <TH>nom du secteur</TH>
    <TH>voies</TH>
    <TH>hauteur max</TH>
    <TH>equipment</TH>
    <TH>type de roche</TH>
    <TH>Information additionnelle</TH>

    <c:forEach items="${site.secteurs}" var="secteur">

    <tr>
        <td>${secteur.nameSecteur}</td>
        <td>${secteur.voies}</td>
        <td>${secteur.heightMax}</td>
        <td>${secteur.equipment}</td>
        <td>${secteur.typeOfSockets}</td>
        <td>${secteur.additionalInformation}</td>
    <sec:authorize access="hasRole('ADMIN')">
    <th><a href="editSecteur/${secteur.id}" class="btn btn-success">Modifier</a></th>
        <th><a href="deleteSecteur/${secteur.id}" class="btn btn-success">suprimer</a></th>
    </sec:authorize>
    </tr>
    </TR>
    </c:forEach>
</TABLE>
<a href="/addSecteur?id=${site.id}"class="btn btn-secondary">Ajouter un secteur </a><BR>

<table border="1">
    <TR>
        <th>utilisateur</th>
        <th>date</th>
        <th>commentaire</th>
        <th>modifier</th>
        <th>supprimer</th>

         <c:forEach items="${site.commentaires}" var="commentaire">

        <tr>
        <td>${commentaire.user.username}</td>
        <td>${commentaire.date}</td>
        <td>${commentaire.commentaireText}</td>
    <sec:authorize access="hasRole('ADMIN')">
    <th><a href="editCommentaire/${commentaire.id}" class="btn btn-success">Modifier</a></th>
        <th><a href="deleteCommentaire/${commentaire.id}" class="btn btn-success">suprimer</a></th>
    </sec:authorize>
</tr>
</TR>
    </c:forEach>
</table>
<a href="/addCommentaire?idSite=${site.id}"class="btn btn-secondary">Ajouter un commentaire </a>
</body>
</html>
