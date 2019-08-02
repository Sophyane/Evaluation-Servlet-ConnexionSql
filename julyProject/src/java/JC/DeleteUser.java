/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JC;

import JCMODEL.UserP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oz
 */

public class DeleteUser extends HttpServlet 
{
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
    {
         response.setContentType("text/html;charset=UTF-8");
         
         UserP myModel = new UserP();
         myModel.setEmail(Connexion.EMAIL);
         
         try {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/julyproject?&serverTimezone=UTC", "root", "");
        Statement statement = (Statement)connection.createStatement();
         //RECUPERER L'ID en fonction de l'adresse E-mail
                  
                String requestSQL = " SELECT idUser FROM user WHERE email = " + "\"" + myModel.getEmail() + "\"";
                
                  
                // Instancier la variable result qui détient la class de MYSQL CONNECTOR qui nous sert à récupérer les valeurs de la BDD.          
               ResultSet result = null;
              int idUser = -1;
              //Executer des requêtes pour pouvoir récupérer des informations de la BDD.

               result = statement.executeQuery(requestSQL);
               
               //Les infos dans la BDD sont dans result  // next c'est comme un curseur qui nous sert de se déplacer dans notre table BDD
               while ( result.next())
               {
                   idUser = result.getInt("idUser");           
               }
               
               System.out.println(idUser);
               
               requestSQL = "DELETE FROM user WHERE idUser = " + idUser;
               
               connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/julyproject?&serverTimezone=UTC", "root", "");
               statement = (Statement)connection.createStatement();
               
               statement.execute(requestSQL);
         }
         catch (SQLException e)
           { 
              
         }
                 

    }
}
