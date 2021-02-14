<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp"/>

<div class="container">

    <h1>modifier Secteur</h1>
    <form:form method="POST" modelAttribute="secteur" action="/editSecteur">

        <form:input type="hidden" path="site.id"/>

        <form:input type="hidden" path="id"/>

        <form:input type="text" required="required" path="nameSecteur" class="form-control form-control-sm mb-3" placeholder="nameSecteur"
                    autofocus="true"/>

        <form:input type="text" required="required" path="voies" class="form-control form-control-sm mb-3" placeholder="voies"/>

        <form:input type="text" required="required" path="cotation" class="form-control form-control-sm mb-3" placeholder="cotation"/>

        <form:input type="text" required="required" path="heightMax" class="form-control form-control-sm mb-3"
                    placeholder="heightMax"/>

        <form:input type="text" required="required" path="equipment" class="form-control form-control-sm mb-3"
                    placeholder="equipment"/>

        <form:input type="text" required="required" path="typeOfSockets" class="form-control form-control-sm mb-3"
                    placeholder="typeOfSockets"/>

        <form:input type="text" required="required" path="additionalInformation" class="form-control form-control-sm mb-3"
                    placeholder="additionalInformation"/>

        <input type="submit" class="btn btn-success" value="Modifier"/>
        <input type="reset" class="btn btn-danger" value="Reset"/>

    </form:form>
</div>

<jsp:include page="../footer.jsp"/>
