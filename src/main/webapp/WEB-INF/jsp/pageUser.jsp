<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body class="container">
<section class="row">
    <div class="col-12">
        <p class="h3">Liste des utilisateurs</p>
    </div>
    <div class="col-12 table-responsive">
        <table class="table table-sm table-striped table-bordered">
            <thead>
            <tr>
                <th>email</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Role</th>
                <th>Topos</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${User}" var="utilisateur" varStatus="status">
                <tr>
                    <td>${utilisateur.email}</td>
                    <td>${utilisateur.nom}</td>
                    <td>${utilisateur.prenom}</td>
                    <td>${utilisateur.role.getName()}</td>
                    <td><a class="btn btn-primary btn-sm" href="/inscrit/listeTopos/${utilisateur.id}">Liste</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
</body>
</html>
