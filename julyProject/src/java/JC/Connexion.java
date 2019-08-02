package JC;


import JCMODEL.UserP;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oz
 */

//Servlet d'insertion des données dans la BDD
public class Connexion extends HttpServlet
{
    
    public static String EMAIL;
   

    private void register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
      response.setContentType("text/html;charset=UTF-8");
      //Recupération Getters
     String firstName = request.getParameter("firstname");
     String lastName = request.getParameter("lastname");
     String password = request.getParameter("password");
     String email = request.getParameter("email");
     String adress = request.getParameter("adress");
     int telephone1 = Integer.parseInt(request.getParameter("telephone1"));
     int telephone2 = Integer.parseInt(request.getParameter("telephone2"));
     
     //Variable static
      EMAIL = email;
     
     UserP myModel = new UserP();
     //Setters
     myModel.setFirstName(firstName);
     myModel.setLastName(lastName);
     myModel.setPassword(password);
     myModel.setEmail(email);
     myModel.setAdress(adress);
     myModel.setTelephone1(telephone1);
     myModel.setTelephone2(telephone2);
     
     //Definir attribut
     request.setAttribute("Bazinga", myModel);
     ResultSet recupIdU =null;
     int FINALID = -1;
     //Conditions champs vides
     if (myModel.getFirstName()== "" || myModel.getLastName() == "" || myModel.getPassword() == "" || myModel.getEmail() == "" || myModel.getTelephone1() == -1 || myModel.getTelephone2() == -1) 
     {
         //Lancement interface error
        request.getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
     }
     else
     {
         try
         {
             //utiliser SQL Connector
             Class.forName("com.mysql.cj.jdbc.Driver");
         }
         
         
         // En cas d'erreur, afficher message d'erreur propre au Connector
         catch (ClassNotFoundException e)
                 {
                     System.out.println(e.getMessage());
                 }
         try
         {
             //Utiliser le driver du connector
             DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
             //Utiliser la classe Connection propre au Connector
             Connection connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/julyproject?&serverTimezone=UTC", "root", "");
            // Utiliser la classe de liaison propre au Connector
             Statement statement = (Statement)connection.createStatement();
         //Requête SQL pour inserer les données récupérer par les inputs
              String requestSQL = "INSERT INTO user(firstName, lastName, password, email, adress, telephone1, telephone2) "
                      + "VALUES (" + "\"" + myModel.getFirstName() + "\"" + "," + "\"" + myModel.getLastName() + "\"" + "," + "\"" + myModel.getPassword() + 
                     "\"" + "," + "\"" + myModel.getEmail() + "\"" + "," + "\"" + myModel.getAdress() + "\"" + "," + myModel.getTelephone1() +  "," + myModel.getTelephone2() + ")";
            //execution de la liaison
                statement.executeUpdate(requestSQL);
                
                
                //Recupération de l'ID à partir de l'email inscrit sur la BDD
                String recupId = "SELECT `idUser` FROM `user` WHERE `email`='"+ myModel.getEmail() +"'";
                //Liaison
                recupIdU = statement.executeQuery(recupId);
                //Boucle de navigation
                while (recupIdU.next()){
                    FINALID = recupIdU.getInt("idUser");
                }
                myModel.setIdUser(FINALID);
            
                statement.close();
         }
         
         //Message d'erreur en cas de beug
         catch(SQLException e)
         {
             System.out.println(e.getMessage());
         }
         
         
         //Requête pour afficher la jsp en cas de bonne exécution du code et des inputs demandés
         request.getServletContext().getRequestDispatcher("/registered.jsp").forward(request, response);
     }
     
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        register(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        register(request, response);
    }
    
    @Override
    public String getServletInfo()
    {
        return "Description";
    }
}
