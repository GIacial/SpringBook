<%-- 
    Document   : navbar
    Created on : 12 févr. 2019, 14:58:37
    Author     : jérémy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="alert.jsp" %>


<nav class="navbar  navbar-light" style="background-color: #33cc33;">
        <a class="navbar-brand" href="mur.htm">SpringBook</a>
        <c:if test="${param.page eq 2}">
            <form method="POST" ACTION="findAmi.htm" class="container">
                <div class="form-group">
                  <input type="text" class="form-control" id="inputPseudo"  placeholder="Rechercher quelqu'un" name="pseudo">
                </div>
                <button type="submit" class="btn btn-primary">Lancer la recherche</button>
              </form>
         </c:if>
        
        <c:if test="${param.page eq 1}">
            <a class="navbar-brand" href="ami.htm">Amis</a>
         </c:if>
        <c:if test="${param.page > 0}">
            <a class="navbar-brand" href="deconnexion.htm">Déconnexion</a>
         </c:if>
            
            
        
</nav>
