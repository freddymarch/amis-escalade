<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../header.jsp"/>

<div class="container" style="margin-top:30px">
    <div class="jumbotron text-center" style="margin-bottom:0">
        <h1>Informations sur les sites d'escalade</h1>
    </div>

    <div class="col-sm-12">
        <h2>Sites</h2>
        <div class="table-responsive">

            <table class="table table-bordered">
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Adresse</th>
                    <th>Pays</th>
                    <th>Tag</th>
                    <sec:authorize access="hasAnyRole('ADMIN')">
                        <th>Modification</th>
                        <th>Suppression</th>
                    </sec:authorize>
                </tr>

                <c:forEach items="${sites}" var="site">
                    <tr>
                        <th>${site.id}</th>
                        <th><a class="button" href="/site/${site.id}">${site.nom}</a></th>
                        <th>${site.adresse}</th>
                        <th>${site.pays}</th>
                        <th>${site.tag}</th>
                        <sec:authorize access="hasAnyRole('ADMIN')">
                            <th><a href="editSite/${site.id}" class="btn btn-success">Modifier</a></th>
                            <th><a href="deleteSite/${site.id}" class="btn btn-danger">suprimer</a></th>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div>
            <a class="button" href="addSite" class="btn btn-secondary">Ajouter un site </a>
        </div>

    </div>
</div>
<jsp:include page="../footer.jsp"/>
