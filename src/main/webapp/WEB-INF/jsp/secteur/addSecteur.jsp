<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp"/>

<div class="container">

    <h1>Ajout Secteur</h1>
    <form:form method="POST" modelAttribute="secteur" action="/addSecteur">

        <form:input type="hidden" path="site.id"/>
        <form:input type="hidden" path="user.id"/>

        <form:input type="text" path="nameSecteur" class="form-control form-control-sm mb-3"
                    placeholder="nom du secteur"
                    autofocus="true"/>

        <form:input type="text" required="required" path="voies" class="form-control form-control-sm mb-3" placeholder="voies"/>

        <form:input type="text" required="required" path="cotation" class="form-control form-control-sm mb-3" placeholder="cotation"/>

        <form:input type="text" required="required" path="heightMax" class="form-control form-control-sm mb-3"
                    placeholder="hauteur max"/>

        <form:input type="text" required="required" path="equipment" class="form-control form-control-sm mb-3"
                    placeholder="équipement"/>

        <form:input type="text" required="required" path="typeOfSockets" class="form-control form-control-sm mb-3"
                    placeholder="type de roche"/>

        <form:input type="text" required="required" path="additionalInformation" class="form-control form-control-sm mb-3"
                    placeholder="Information additionnelle"/>

        <input type="submit" class="btn btn-success" value="Ajouter"/>
        <input type="reset" class="btn btn-danger" value="Reset"/>

    </form:form>
</div>

<jsp:include page="../footer.jsp"/>