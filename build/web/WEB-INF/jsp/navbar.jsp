<%-- 
    Document   : navbar
    Created on : 12 f�vr. 2019, 14:58:37
    Author     : j�r�my
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="alert.jsp" %>


<nav class="navbar  navbar-light" style="background-color: #33cc33;">
        <a class="navbar-brand" href="mur.htm">SpringBook</a>
        
        
        <c:if test="${param.page eq 1}">
            <a class="navbar-brand" href="ami.htm">Amis</a>
         </c:if>
        <c:if test="${param.page > 0}">
            <a class="navbar-brand" href="deconnexion.htm">D�connexion</a>
         </c:if>
            
            
        
</nav>
