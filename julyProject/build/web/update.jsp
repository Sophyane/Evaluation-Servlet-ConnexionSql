<%-- 
    Document   : update
    Created on : 31 juil. 2019, 11:45:33
    Author     : oz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                 <link href="July.css" rel="stylesheet" type="text/css"/>

        <title>To update</title>
    </head>
    <body>
        
        <div class="form-style-6">
<h1>You can update in here </h1> 
        <jsp:useBean id="Bazinga" scope="request" class="JCMODEL.UserP"/>


        <!--< <form action="UpdateServlet" method="POST--> 
        <form action="UpdateUser" method="POST">

            <input name="FIRST" type='text' value='${Bazinga.firstName}' /><p> First Name to edit</p>
            <input name="LAST" type='text' value='${Bazinga.lastName}' /><p> Last Name to edit</p>
            <input name="PASS" type='text' value='${Bazinga.password}' />
            <input name="EM" type='text' value='${Bazinga.email}' />
            <input name="ADRESS" type='text' value='${Bazinga.adress}' />
            <input name="TEL1" type='text' value='${Bazinga.telephone1}' />
            <input name="TEL2" type='text' value='${Bazinga.telephone2}' />
            <input name="FIRST" type="submit" value="Update his account">
            <a href="index.html">Retour</a>
            <input type ="hidden" name="IDTOUP" value='${Bazinga.idUser}'/>
           
        </form>
            <div/>
    </body>
</html>
