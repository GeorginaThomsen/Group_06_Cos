<%-- 
    Document   : AddComments
    Created on : Apr 24, 2015, 11:49:13 AM
    Author     : Ben
--%>

<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Comments JSP</title>
    </head>
    <body>
        <h1>View Comments Page</h1>
        <form action="AddCommentsServlet" method="post">
            
        
        <%
                Project project = (Project) request.getAttribute("project");
            %>
    
    
            <table border="1" style="width:100%">
                <tr>
                    
                    <th> Activity Description  </th>     
                    <th> Comments  </th> 
                    <th> Cost  </th> 
                    <th> MDF Budget  </th> 
                    <th> Execution Quarter  </th> 
                    <th> Start Date  </th> 
                    <th> End Date  </th> 
                    <th> Objective & Result  </th> 
                    <th> Required POE  </th> 
                    <th> Status </th> 
                    <th> PartnerID  </th> 

                </tr>
                       
                <tr>

                    <td><%= project.getActivityDescription()%></td>
                    <td><%= project.getComments()%></td>
                    <td><%= project.getCost()%></td>
                    <td><%= project.getMDFBudget()%></td>
                    <td><%= project.getExecutionQuarter()%></td>
                    <td><%= project.getStartDate()%></td>
                    <td><%= project.getEndDate()%></td>
                    <td><%= project.getObjAndResult()%></td>
                    <td><%= project.getRequiredPOE()%></td>
                    <td><%= project.getStatus()%></td>
                    <td><%= project.getPaID()%></td>

                    </tr>


                    
            </table><br><br>
                    <input type="hidden" name="projectID"  value="<%= project.getProjectID()%>">
                    Previous Comments: <input type="text" name="comments" value="<%= request.getAttribute("comments")%>" size="400" readonly><br><br>
            New Comments: <input type="text" name="newComments" value="" size="100">
            <button name="command" value="addComments">Add Comments To Project</button>
        </form><br><br>
         <form action="ShowAllProjectsServlet" method="post">
            <input type="hidden" name="command" value="viewAllProjects">

            <button name="viewAllProjects" value="">View All Projects</button>
        </form><br><br>
        <form action="FinanceInputServlet" method="get">
             <button name="DellLogInButton" value="">Get finance pending projects</button>
        </form><br><br>
    </body>
</html>
