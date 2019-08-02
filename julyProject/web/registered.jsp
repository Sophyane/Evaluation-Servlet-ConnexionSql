<%-- 
    Document   : registered
    Created on : 26 juil. 2019, 14:45:03
    Author     : oz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="July.css" rel="stylesheet" type="text/css"/>
        <title>Registered page</title>
    </head>
    <div class="form-style-6">
<h1>Registred</h1>  
        <jsp:useBean id="Bazinga" scope="request" class="JCMODEL.UserP"/>
        ${Bazinga.getFirstName()}
        <p>Hey : ${Bazinga.firstName}</p>
        <p> your last name is : ${Bazinga.lastName}</p>
        <p> Your Password is : ${Bazinga.password}</p>
        <p> Your E-mail is : ${Bazinga.email}</p>
        <p> Your adress is : ${Bazinga.adress}</p>
        <p> Your first telephone : ${Bazinga.telephone1}</p>
        <p> Your second telephone : ${Bazinga.telephone2}</p>
        
        <a href="index.html">Retour</a>
        <a href="displayUserInfoServlet?id=${Bazinga.idUser}">Update User</a>
        <a href="DeleteUser">Delete</a>
        </div>
        
        
<!--        <form action="DeleteUser" method="POST">
            <input type="submit" value="Delete his account">
        </form>
        
         <form action="UpdateServlet" method="POST">
             <input type='text' value='${Bazinga.adress}' />
         <input type="submit" href="update.jsp" value="Update his account">
            
            
            
        </form>
    -->


