<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>
<head>
    <title>Amis escalade</title>
</head>
<body>
<div>
    <div >
        <h5>Bienvenue sur le site des amis de l'escalade !</h5>
        <p>Nous vous souhaitons la bienvenue sur le site des amis de l'escalde.</p>
        <p>Pour profiter au maximum de notre communauté, n'hésitez pas à vous inscrire</p>

        <c:if test="${topo.available.equals(false) && topo.confirmReservation.equals(false)}">
            <h1>vous avez une demande de réservation en attente</h1>
        </c:if>

    </div>
</div>
</body>
<jsp:include page="footer.jsp"/>
