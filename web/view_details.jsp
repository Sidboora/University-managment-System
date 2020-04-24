<%-- 
    Document   : view_details
    Created on : 30 Mar, 2020, 10:30:24 AM
    Author     : Siddharth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
        <br>
                <center> <h1>
                    admission details
                    </h1></center>
                    
         
            
                <table>
                    <tr>
                <th>NAME</th>
                <th>LAST NAME</th>
                <th>10TH PASSING YEAR</th>
                <th>10TH MARKS</th>
                <th>12TH PASSING YEAR</th>
                <th>10TH MARKS</th>
                <th>SUBJECT CHOICE-1</th>
                <th>SUBJECT CHOICE-2</th>
                <th>SUBJECT CHOICE-3</th>
              </tr>
<%@page import="java.sql.*"%>
    <%
        try{  
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/mydb","root","root");

      Statement ps=con.createStatement(); 



      ResultSet rs=ps.executeQuery("SELECT * FROM ADMISSION");  




      while(rs.next()){
      %>

 

<tr>

 

    <td><%=rs.getString("NAME")%></td>
    <td><%=rs.getString("LAST_NAME")%></td>
    <td><%=rs.getString("X_YEAR")%></td>
    <td><%=rs.getString("X_MARKS")%></td>
    <td><%=rs.getString("XII_YEAR")%></td>
    <td><%=rs.getString("XII_MARKS")%></td>
    <td><%=rs.getString("CHOICE1")%></td>
    <td><%=rs.getString("CHOICE2")%></td>
    <td><%=rs.getString("CHOICE3")%></td>

 

</tr>
<%
}

 


}catch(Exception e){}
    %>
        </table>
        <div>
            <br>
            <br>
            <center><a href="admin_view.html">Go Back</a></center>
            </div>
   
    </body>
</html>
