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

/**
 *
 * @author oz
 */
public class UpdateUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        UserP Bazinga = new UserP();
      String Id = request.getParameter("IDTOUP");
      System.out.println(Id);
      String firstname = request.getParameter("FIRST");
       String lastname = request.getParameter("LAST");
        String password = request.getParameter("PASS");
         String email = request.getParameter("EM");
         String adress = request.getParameter("ADRESS");
         String telephone1 = request.getParameter("TEL1");
         String telephone2 = request.getParameter("TEL2");
            
         // Bazinga.setIdUser(Integer.parseInt(Id));
     Bazinga.setFirstName(firstname);
     Bazinga.setPassword(password);
     Bazinga.setEmail(email);
     Bazinga.setAdress(adress);
     Bazinga.setTelephone1(Integer.parseInt(telephone1));
     Bazinga.setTelephone2(Integer.parseInt(telephone2));
      
        // monUseraafficher.setEmail(Connexion.EMAIL);

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/julyproject?&serverTimezone=UTC", "root", "");
            Statement statement = (Statement) connection.createStatement();
            //RECUPERER L'ID en fonction de l'adresse E-mail
            String idUser = request.getParameter("id");
                

            
            

//          String requestSQL = "UPDATE user SET (firstName, lastName, password, email, adress, telephone1, telephone2) "
//                   +  "UPDATE  user SET "firstName = "", lastName = "", password = "", email = "", adress = "", telephone1 = 0, telephone2 = 0," WHERE idUser ="+idUser";
           statement.executeUpdate ("UPDATE user SET firstName='"+ firstname +"' WHERE idUser ="+ Id);
           statement.executeUpdate ("UPDATE user SET lastName='"+ lastname +"' WHERE idUser ="+ Id);
           statement.executeUpdate ("UPDATE user SET password='"+ password +"' WHERE idUser ="+ Id);
           statement.executeUpdate ("UPDATE user SET email='"+ email +"' WHERE idUser ="+ Id);
           statement.executeUpdate ("UPDATE user SET adress='"+ adress +"' WHERE idUser ="+ Id);
           statement.executeUpdate ("UPDATE user SET telephone1='"+ telephone1 +"' WHERE idUser ="+ Id);
           statement.executeUpdate ("UPDATE user SET telephone2='"+ telephone2 +"' WHERE idUser ="+ Id);




           connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/julyproject?&serverTimezone=UTC", "root", "");
            statement = (Statement) connection.createStatement();

           // statement.execute("requestSQL");
            request.setAttribute("Bazinga", Bazinga);

        } catch (SQLException e) {

        }
            request.getServletContext().getRequestDispatcher("/edited.jsp").forward(request, response);

        //Affichage de la JSP avec en parametre de l'appel fait par cette servlet le user a afficher
    }
}
