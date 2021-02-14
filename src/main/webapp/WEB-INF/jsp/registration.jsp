<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>
<head>
    <title>registration</title>
    <meta charset='utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<div class="container">
    <p style="color: red">${message}</p>
    <h1>Formulaires</h1>

    <form:form method="POST" modelAttribute="user" action="/registration">


    <form:input type="text" required="required" path="name" class="form-control form-control-sm mb-3" placeholder="Nom"
                autofocus="true"/>

    <form:input type="text" required="required" path="lastName" class="form-control form-control-sm mb-3"
                placeholder="Prenom"/>

    <form:input type="text" required="required"  path="email" class="form-control form-control-sm mb-3" placeholder="Mail"/>


    <form:input type="text" required="required" path="password" class="form-control form-control-sm mb-3"
                placeholder="Mot De Passe"/>


    <input type="submit" class="btn btn-success" value="Ajouter"/>
    <input type="reset" class="btn btn-danger" value="Reset"/>

    </form:form>
</div>
</body>
<jsp:include page="footer.jsp"/>
