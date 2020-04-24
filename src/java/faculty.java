/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Siddharth
 */
public class faculty extends HttpServlet {
    
    String userid;
    String password;
    Connection con;
    ResultSet resultset;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @throws ServletException if a servlet-specific error occurs
     */
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        String driverClassName = config.getInitParameter("driverclassname");
        String dbURL = config.getInitParameter("dburl");
        String username = config.getInitParameter("username");
        String dbpassword = config.getInitParameter("dbpassword");
        try
        {
            Class.forName(driverClassName);
        }
        catch(ClassNotFoundException cnfe)
        {
            System.err.println("Error loading driver: " + cnfe);
        }
        try
        {
             con = DriverManager.getConnection(dbURL, username, dbpassword);
        }
        catch(SQLException sqle)
        {
            System.err.println("Connection error: " + sqle);
        }
    }
    public void destroy() {
       
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String uname = request.getParameter ("username");
           String pass = request.getParameter("password");
           
           
           String query = "INSERT INTO ADMIN (NAME,PASS) VALUES(?,?)";
           PreparedStatement  stmt = con.prepareStatement(query);
           stmt.setString(1,uname);
           stmt.setString(2, pass);
           stmt.executeUpdate();
           
           response.sendRedirect("admin_view.html");
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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