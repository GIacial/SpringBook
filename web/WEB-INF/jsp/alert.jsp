<%-- 
    Document   : alert
    Created on : 12 févr. 2019, 14:07:59
    Author     : jérémy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:if test="${fn:length(alert) > 0}">
       <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <p>${alert}</p>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
</c:if>