<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Modifier Site</h1>
<form:form method="POST" modelAttribute="topo" action="/editTopo">

    <form:input type="hidden" path="id" autofocus="true"/>

    <form:input type="text" path="name" class="form-control form-control-sm mb-3" placeholder="Nom"
                autofocus="true"/>

    <form:input type="text" path="description" class="form-control form-control-sm mb-3" placeholder="Pays"/>

    <form:input type="text" path="places" class="form-control form-control-sm mb-3"
                placeholder="Adresse"/>

    <form:input type="text" path="releaseDate" class="form-control form-control-sm mb-3"
                placeholder="tag"/>

    <input type="submit" class="btn btn-success" value="Modifier"/>
    <input type="reset" class="btn btn-danger" value="Reset"/>

</form:form>
</body>
</html>
