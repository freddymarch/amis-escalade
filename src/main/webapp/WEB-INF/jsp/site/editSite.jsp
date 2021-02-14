<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp"/>
<div class="container">
    <h1>Modifier Site</h1>
    <form:form method="POST" modelAttribute="site" action="/editSite">
        <form:input type="hidden" path="id" autofocus="true"/>

        <form:input type="text" required="required"  path="nom" class="form-control form-control-sm mb-3" placeholder="Nom"
                    autofocus="true"/>

        <form:input type="text" required="required"  path="pays" class="form-control form-control-sm mb-3" placeholder="pays"/>

        <form:input type="text" required="required"  path="adresse" class="form-control form-control-sm mb-3"
                    placeholder="adresse"/>

        <form:input type="text" required="required"  path="tag" class="form-control form-control-sm mb-3" placeholder="tag"/>

        <input type="submit" class="btn btn-success" value="Modifier"/>
        <input type="reset" class="btn btn-danger" value="Reset"/>
    </form:form>
</div>
<jsp:include page="../footer.jsp"/>
