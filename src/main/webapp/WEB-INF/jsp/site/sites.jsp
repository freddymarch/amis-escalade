<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<html>
<head>
    <title>sites</title>
</head>
<body>

   <TABLE BORDER="1">
       <TR>
           <TH>tag</TH>
           <TH>nom</TH>
           <TH>pays</TH>
           <TH>adresse</TH>

          <c:forEach items="${sites}" var="site">

              <tr>
              <td>${site.tag}</td>
              <td>${site.nom}</td>
              <td>${site.pays}</td>
              <td>${site.adresse}</td>
       <th><a href="editSite/${site.id}" class="btn btn-success">Modifier</a></th>
       <th><a href="deleteSite/${site.id}" class="btn btn-success">suprimer</a></th>
       <th><a href="site/${site.id}" class="btn btn-success">site</a></th>
   </tr>
       </TR>
       </c:forEach>
   </TABLE>
   <a class="button" href="addSite" class="btn btn-secondary">Ajouter un site </a><br>
</body>
</html>
