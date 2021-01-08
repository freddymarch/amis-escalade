<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a href="/addSecteur?id=${site.id}"class="btn btn-secondary">Ajouter un secteur </a><BR>
    <a href="/addCommentaire?id=${site.id}"class="btn btn-secondary">Ajouter un commentaire </a>

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
    <th><a href="/editSecteur/${secteur.id}" class="btn btn-success">Modifier</a></th>
        <th><a href="/deleteSecteur/${secteur.id}" class="btn btn-success">suprimer</a></th>
    </tr>
    </TR>
    </c:forEach>
</TABLE>

<table border="1">
    <TR>
        <th>commentaire</th>

         <c:forEach items="${commentaire}" var="commentaire">

             <td>${commentaire.commentaireText}</td>
        <th><a href="/editCommentaire/${commentaire.id}" class="btn btn-success">Modifier</a></th>
        <th><a href="/deleteCommentaire/${commentaire.id}" class="btn btn-success">suprimer</a></th>
</TR>
    </c:forEach>
</table>
</body>
</html>
