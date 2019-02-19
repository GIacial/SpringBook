

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SpringBook</title>
        <!-- Bootstrap -->
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>

    <body>
        <jsp:include page="navbar.jsp" >
            <jsp:param name="page" value="2" />
          </jsp:include>
        <div class="container-fluid">
            
            <h1 class="text-center">Mes amis</h1>
                <c:forEach items="${amis}" var="pub">
                    <jsp:include page="ami.jsp">                         
                      <jsp:param name="pseudo" value="${pub.getPseudo()}" />  
                      <jsp:param name="id" value="${pub.getId()}" />            
                      <jsp:param name="ami" value="true" />  
                  </jsp:include>
                </c:forEach>
            
            <h1 class="text-center">D'autres personnes</h1>
                <c:forEach items="${autres}" var="pub">
                    <jsp:include page="ami.jsp">                         
                      <jsp:param name="pseudo" value="${pub.getPseudo()}" />  
                      <jsp:param name="id" value="${pub.getId()}" />            
                      <jsp:param name="ami" value="false" />  
                  </jsp:include>
                </c:forEach>
            
        </div>
        
    </body>
</html>