<%-- 
    Document   : ami
    Created on : 19 févr. 2019, 08:21:17
    Author     : jérémy
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="card  border-primary bg-light mb-3" >
  <div class="card-body ">
    <p class="card-text"><a  href="amimur.htm?pseudo=${param.id}">${param.pseudo}</a></p>
    <c:if test="${param.ami}">
        <form method="POST" ACTION="supprimerami.htm" class="container">
            <div class="form-group">

            <input type="hidden"    name="key" value="${param.id}">
            <button type="submit" class="btn btn-primary">Supprimer</button>
          </form>
    </c:if>
  </div>
</div>
</div>
