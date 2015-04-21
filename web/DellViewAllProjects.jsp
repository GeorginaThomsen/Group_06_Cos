<%-- 
    Document   : DellViewAllProjects
    Created on : Apr 20, 2015, 11:19:16 AM
    Author     : Ben
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>View All Projects</h1>
           

        
        <h2>Project Details</h2>
        <form>
            
        <%
        ArrayList<Project> projects = (ArrayList<Project>)request.getAttribute("projects");
                %>
       
        
     
        <table border="1" style="width:100%">
            <tr>
            <th>Select</th>
            <th> Activity Description  </th>     
            <th> Comments  </th> 
            <th> Cost  </th> 
            <th> MDF Budget  </th> 
            <th> Execution Quarter  </th> 
            <th> Start Date  </th> 
            <th> End Date  </th> 
            <th> Objective & Result  </th> 
            <th>Required POE  </th> 
            <th>Status </th> 
            <th>PartnerID  </th> 
            
            </tr>
            <%
                for(int i = 0; i < projects.size(); i++)
                {
            %>
            <!--       <%= projects.get(i).getProjectID()%> -->
            <tr>
                <td><input type="checkbox" name="project" value="Pro"></td>
                <td><%= projects.get(i).getActivityDescription()%></td>
                <td><%= projects.get(i).getComments()%></td>
                <td><%= projects.get(i).getCost()%></td>
                <td><%= projects.get(i).getMDFBudget()%></td>
                <td><%= projects.get(i).getExecutionQuarter()%></td>
                <td><%= projects.get(i).getStartDate()%></td>
                <td><%= projects.get(i).getEndDate()%></td>
                <td><%= projects.get(i).getObjAndResult()%></td>
                <td><%= projects.get(i).getRequiredPOE()%></td>
                <td><%= projects.get(i).getStatus()%></td>
                <td><%= projects.get(i).getPaID()%></td>
                 
            </tr>
            
             
        <%}%>
        </table><br><br>
           

        </form>
    </body>
</html>
