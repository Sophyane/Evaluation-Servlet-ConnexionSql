/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletExemple;

import JC.Connexion;
import JCMODEL.UserP;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oz
 */
public class displayUserInfoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserP Bazinga = new UserP();
        PrintWriter out = response.getWriter();

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/julyproject?&serverTimezone=UTC", "root", "");
            Statement statement = (Statement) connection.createStatement();
            //RECUPERER L'ID en fonction de l'adresse E-mail

            String requestSQL = " SELECT * FROM user WHERE iduser = "+request.getParameter("id");

            // Instancier la variable result qui détient la class de MYSQL CONNECTOR qui nous sert à récupérer les valeurs de la BDD.          
            ResultSet result = null;
            //int idUser = -1;
            //Executer des requêtes pour pouvoir récupérer des informations de la BDD.

            result = statement.executeQuery(requestSQL);

            //Les infos dans la BDD sont dans result  // next c'est comme un curseur qui nous sert de se déplacer dans notre table BDD
            while (result.next()) {
                //idUser = result.getInt("idUser");
                Bazinga.setIdUser(result.getInt("idUser"));

                Bazinga.setFirstName(result.getString("firstName"));
                Bazinga.setLastName(result.getString("lastName"));
                Bazinga.setPassword(result.getString("password"));
                Bazinga.setEmail(result.getString("email"));
                Bazinga.setAdress(result.getString("adress"));
                Bazinga.setTelephone1(result.getInt("telephone1"));
                Bazinga.setTelephone2(result.getInt("telephone2"));
            }

            out.println(Bazinga.getIdUser());

//            requestSQL = "UPDATE FROM user VALUES () WHERE idUser = " + idUser;
//
//            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/julyproject?&serverTimezone=UTC", "root", "");
//            statement = (Statement) connection.createStatement();
//
//            statement.execute(requestSQL);
            request.setAttribute("Bazinga", Bazinga);

            request.getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
        } catch (SQLException e) {

            /* TODO output your page here. You may use following sample code. */
            out.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
