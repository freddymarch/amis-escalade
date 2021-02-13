<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
<div class="container">
    <h1>S'identifier</h1>
    <c:if test="${param.error}">
        <div style="color:red">
            Login et/ou mot de passe incorrect(s).<br />
        </div>
    </c:if>
    <form:form method="POST" action="/login">
        <input type="text" required="required" name="username" class="form-control form-control-sm mb-3" placeholder="Email"/>
        <input type="password" required="required" name="password" class="form-control form-control-sm mb-3" placeholder="Mot De Passe"/>
        <input type="submit" class="btn btn-success" value="Valider"/>
        <input type="reset" class="btn btn-danger" value="Reset"/>
        <a class="btn btn-danger" href="/">Cancel</a>
    </form:form>
</div>
<jsp:include page="footer.jsp"/>
