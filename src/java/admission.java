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

public class admission extends HttpServlet {

    String choice1;
     String choice2;
      String choice3;
      int X_year;
      int XII_year;
      int X_marks;
      int XII_marks;
      String l_name;
      String name;
      String address;
      String dob;

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
           choice1 = request.getParameter ("course1");
           choice2= request.getParameter ("course2");
           choice3 = request.getParameter ("course3");
           X_year = Integer.parseInt(request.getParameter("passingyearclassX"));
           
           X_marks = Integer.parseInt(request.getParameter("percentageclassX"));
           XII_year = Integer.parseInt(request.getParameter("passingyearclassXII"));
           XII_marks = Integer.parseInt(request.getParameter("percentageclassXII"));
           l_name = request.getParameter("lastname");
           name = request.getParameter("firstname");
           dob = request.getParameter("dob");
           address = request.getParameter("add");
            
           
           
           
           String query = "INSERT INTO ADMISSION (CHOICE1,CHOICE2,CHOICE3,X_YEAR,XII_YEAR,X_MARKS,XII_MARKS,LAST_NAME,NAME,ADDRESS,DOB) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement  stmt = con.prepareStatement(query);
           stmt.setString(1,choice1);
           stmt.setString(2, choice2);
           stmt.setString(3, choice3);
           stmt.setInt(4,X_year);
           stmt.setInt(5,XII_year);
           stmt.setDouble(6,X_marks);
           stmt.setDouble(7,XII_marks);
           stmt.setString(8,l_name);
           stmt.setString(9,name);
           stmt.setString(10,address);
           stmt.setString(11,dob);
           stmt.executeUpdate();
           
           response.sendRedirect("done.html");
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
