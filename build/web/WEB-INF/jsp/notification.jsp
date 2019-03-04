<%-- 
    Document   : notification
    Created on : 4 Mars. 2019, 12:54:39
    Author     : jérémy
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="card  border-primary bg-light mb-3" >
  <div class="card-header">Notification de 
            <a  href="amimur.htm?pseudo=${param.id}">${param.pseudoAuteur}</a>
            </div>
  <div class="card-body ">
    <p class="card-text">${param.msg}</p>
  </div>
</div>



