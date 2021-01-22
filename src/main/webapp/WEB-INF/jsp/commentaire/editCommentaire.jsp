<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ajout Commentaire</h1>
<form:form method="POST" modelAttribute="commentaire" action="/editCommentaire">

    <form:input type="hidden" path="site.id"/>
    <form:input type="hidden" path="user.id"/>

    <form:input type="hidden" path="id"/>

    <form:input type="text" path="commentaireText" class="form-control form-control-sm mb-3" placeholder="commentaire"
                autofocus="true"/>

    <form:input type="text" path="date" class="form-control form-control-sm mb-3" placeholder="date"
                autofocus="true"/>

    <input type="submit" class="btn btn-success" value="Modifier"/>
    <input type="reset" class="btn btn-danger" value="Reset"/>

</form:form>
</body>
</html>
