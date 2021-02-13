<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>
<head>
    <title>site</title>
</head>
<h2>Secteurs :</h2>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Informations du site d'escalade "${site.nom}"</h1>
</div>

<div class="col-sm-12">
    <h2>Sites</h2>
    <div class="table-responsive">

        <table class="table table-bordered">
            <tr>
                <th>nom du secteur</th>
                <th>voies</th>
                <th>cotation</th>
                <th>hauteur max</th>
                <th>equipment</th>
                <th>type de roche</th>
                <TH>Information additionnelle</TH>
                <sec:authorize access="hasAnyRole('ADMIN')">
                    <th>Modification</th>
                    <th>Suppression</th>
                </sec:authorize>
            </tr>

            <c:forEach items="${site.secteurs}" var="secteur">
                <tr>
                    <td>${secteur.nameSecteur}</td>
                    <td>${secteur.voies}</td>
                    <td>${secteur.cotation}</td>
                    <td>${secteur.heightMax}</td>
                    <td>${secteur.equipment}</td>
                    <td>${secteur.typeOfSockets}</td>
                    <td>${secteur.additionalInformation}</td>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th><a href="editSecteur/${secteur.id}" class="btn btn-success">Modifier</a></th>
                        <th><a href="deleteSecteur/${secteur.id}" class="btn btn-success">suprimer</a></th>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <a href="/addSecteur?id=${site.id}" class="btn btn-secondary">Ajouter un secteur </a><BR>
    </div>

</div>
</div>

<div class="table-responsive">

    <table class="table table-bordered">
        <tr>
            <th>utilisateur</th>
            <th>date</th>
            <th>commentaire</th>
            <th>modifier</th>
            <th>supprimer</th>
            <sec:authorize access="hasAnyRole('ADMIN')">
                <th>Modification</th>
                <th>Suppression</th>
            </sec:authorize>
        </tr>

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
        </c:forEach>
    </table>
</div>
<div>
    <a href="/addCommentaire?idSite=${site.id}" class="btn btn-secondary">Ajouter un commentaire </a>
</div>

</div>
</div>

<jsp:include page="../footer.jsp"/>