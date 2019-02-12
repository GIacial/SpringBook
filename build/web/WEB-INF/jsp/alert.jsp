<%-- 
    Document   : alert
    Created on : 12 févr. 2019, 14:07:59
    Author     : jérémy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:if test="${fn:length(alert) > 0}">
   <div class="alert alert-primary" role="alert">
       <p>${alert}</p>
    </div>
</c:if>