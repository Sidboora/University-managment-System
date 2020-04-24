<%-- 
    Document   : approval_status
    Created on : 30 Mar, 2020, 10:40:15 AM
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
    <center>
        <br>
        <h4>Approval Status</h4></center>
        
    
    
    <div class="table">
        <br>
        <br>
        <center>
        <table>
            <tr>
                <th>Name         </th>
                <th>Last Name   </th>
                <th>Choice1     </th>
                <th>10th marks      </th>
                <th>12th marks      </th>
                
                
            </tr>
            
    <%@page import="java.sql.*"%>
    <%
        try{  
  Class.forName("org.apache.derby.jdbc.ClientDriver");
  Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/mydb","root","root");
              
Statement ps=con.createStatement(); 
      
  
  
ResultSet rs=ps.executeQuery("SELECT NAME,LAST_NAME,CHOICE1,X_MARKS,XII_MARKS FROM ADMISSION WHERE CHOICE1 = 'mechanical' AND X_MARKS>75 AND XII_MARKS>70");  

 


while(rs.next()){
%>
<tr>

<td><%=rs.getString("NAME")%>   </td>
<td><%=rs.getString("LAST_NAME")%>      </td>
<td><%=rs.getString("CHOICE1")%>        </td>
<td><%=rs.getString("X_MARKS")%>        </td>
<td><%=rs.getString("XII_MARKS")%>      </td>




 

</tr>
<%
}

 


}catch(Exception e){}
    %>
        </table>
        </center>
    </div>
        <br>
        <br>
        <center><a href="admin_view.html">Admin page</a></center>
            
        
        </div>
        
    </body>
    
</html>
