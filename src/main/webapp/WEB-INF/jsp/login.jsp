<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>S'identifier</h1>

    <form:form method="POST" modelAttribute="user" action="/login">

        <form:input type="text" required="required" path="username" id="username" class="form-control form-control-sm mb-3"
                    placeholder="Email"/>

        <form:input type="password" required="required" path="password" id="password" class="form-control form-control-sm mb-3"
                    placeholder="Mot De Passe"/>


        <input type="submit" class="btn btn-success" value="Valider"/>
        <input type="reset" class="btn btn-danger" value="Reset"/>
        <a class="btn btn-danger" href="/">Cancel</a>

    </form:form>
</div>
</body>
</html>