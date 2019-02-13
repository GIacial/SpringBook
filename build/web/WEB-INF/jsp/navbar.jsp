<%-- 
    Document   : navbar
    Created on : 12 févr. 2019, 14:58:37
    Author     : jérémy
--%>

<%@include file="alert.jsp" %>


<nav class="navbar  navbar-light" style="background-color: #33cc33;">
        <a class="navbar-brand" href="mur.htm">SpringBook</a>
        <c:if test="${param.page > 0}">
            <a class="navbar-brand" href="deconnexion.htm">Déconnexion</a>
         </c:if>
        
</nav>
