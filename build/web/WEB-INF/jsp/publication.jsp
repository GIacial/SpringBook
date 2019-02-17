<%-- 
    Document   : publication
    Created on : 13 févr. 2019, 10:47:39
    Author     : jérémy
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="card  border-primary bg-light mb-3" >
  <div class="card-header">Publication de 
            <a  href="amimur.htm?pseudo=${param.pseudoAuteur}">${param.pseudoAuteur}</a></div>
  <div class="card-body ">
    <p class="card-text">Contenu de la publication</p>
  </div>
</div>


