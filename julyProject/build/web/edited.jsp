<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="July.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <div class="form-style-6">
<h1>Contact Us</h1>  
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
        