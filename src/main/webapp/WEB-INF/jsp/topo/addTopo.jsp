<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>nouveau topo</title>
</head>
<body>
<h1>Ajout topo</h1>
<form:form method="POST" modelAttribute="topo" action="/addTopo">


    <form:input type="text" path="name" class="form-control form-control-sm mb-3" placeholder="Nom"
                autofocus="true"/>

    <form:input type="text" path="description" class="form-control form-control-sm mb-3" placeholder="description"/>

    <form:input type="text" path="places" class="form-control form-control-sm mb-3"
                placeholder="lieux"/>

    <form:input type="text" path="releaseDate" class="form-control form-control-sm mb-3"
                placeholder="date"/>

    <form:input type="text" path="userWithTopo" class="form-control form-control-sm mb-3"
                placeholder="iduser"/>

    <input type="submit" class="btn btn-success" value="Ajouter"/>
    <input type="reset" class="btn btn-danger" value="Reset"/>

</form:form>
</body>
</html>
