<%-- 
    Document   : mur
    Created on : 12 févr. 2019, 15:00:00
    Author     : jérémy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>SpringBook</title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>

    <body>
        <jsp:include page="navbar.jsp" >
            <jsp:param name="page" value="1" />
          </jsp:include>
            <div class="container-fluid">
                
                <c:if test="${myPage }">
                     <h1 class="text-center">Mon mur</h1>    
                </c:if>
                <c:if test="${!myPage }">
                     <h1 class="text-center">Mur de ${identity.getPseudo()}</h1>  
                </c:if>
                <div class="row">
                  <div class="col-sm-3">
                      <!-- Identite du proprietaire du mur -->
                      
                      <div class="card  border-primary bg-light mb-3" >
                          <div class="card-header">Profil de <b>${identity.getPseudo()}</b></div>
                        <div class="card-body ">
                            <p class="card-text"><u>Localisation</u> : ${identity.getAdresse()} ${identity.getCodePostal()} ${identity.getVille()}</p>
                            <p class="card-text"><u>Date de naissance</u> : ${identity.getNaissance()} </p>
                            <p class="card-text"><u>Genre</u> : ${identity.getGenre()} </p>
                            <p class="card-text"><u>Profession</u> : ${identity.getProfession()} </p>
                        </div>
                      </div>
                       <!-- Notification de mon mur -->
                      <c:if test="${myPage }">
                          <h2>Notifications</h2>
                         <div>  
                         <!-- notif-->
                          <c:forEach items="${notifs}" var="notif">
                            <jsp:include page="notification.jsp">                         
                              <jsp:param name="pseudoAuteur" value="${notif.getAuteur().getPseudo()}" />  
                              <jsp:param name="idAuteur" value="${notif.auteur.getId()}" />             
                              <jsp:param name="msg" value="${notif.msg}" />
                          </jsp:include>
                        </c:forEach>
                          
                        </div>
                      </c:if>
                  </div>
                  <div class="col-sm-9" >
                      <!-- le mur -->
                      
                      <!-- button ajouter amis -->
                      <c:if test="${not myPage && not ami}">
                          <form method="POST" ACTION="addami.htm" class="container">

                              <input type="hidden"    name="key" value="${key}">
                            <button type="submit" class="btn btn-primary">Ajouter en Amis</button>
                          </form>
                      </c:if>
                      
                      
                      <!-- button de publication sur le mur -->
                      <c:if test="${myPage || ami}">
                          <div class="card  border-primary bg-light mb-3" >
                            <div class="card-header">Publier sur le mur</div>
                            <div class="card-body ">
                                <form method="POST" ACTION="publier.htm" class="container">

                                <div class="form-group">
                                  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="msg"></textarea>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="customFile" name="media">
                                    <label  for="customFile">Ajouter une image par url</label>
                                  </div>
                              <input type="hidden"    name="key" value="${key}">
                            <button type="submit" class="btn btn-primary">Publier</button>
                          </form>
                            </div>
                          </div>
                          
                          
                          <!-- publication -->
                         <!-- <div class="card-columns">-->
                          <c:forEach items="${publications}" var="pub">
                            <jsp:include page="publication.jsp">                         
                              <jsp:param name="pseudoAuteur" value="${pub.getAuteur().getPseudo()}" />  
                              <jsp:param name="id" value="${pub.auteur.getId()}" />            
                              <jsp:param name="create" value="${pub.creation}" />             
                              <jsp:param name="msg" value="${pub.message}" />                    
                              <jsp:param name="img" value="${pub.getCheminImage()}" />
                          </jsp:include>
                        </c:forEach>
                       <!--         </div>-->
                          
                        </div>
                      </c:if>
                      
                      
                      
                  </div>
                </div>
              </div>
        
    </body>
</html>

