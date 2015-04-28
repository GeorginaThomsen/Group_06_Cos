<%-- 
    Document   : MarketingViewProjects
    Created on : Apr 21, 2015, 9:39:23 AM
    Author     : Ben
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marketing View Projects</title>
    </head>
    <body>
        <h1>Marketing View Projects</h1><br>
        
        <form action="DellFrontPage.jsp" method="post">                      
            <button name="DellBackButton" value="">Back</button>
        </form><br>
        
        
         <h2>Project Details</h2>
        <form action="MarketingServlet" method="post">
            
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
            <!--     <%= projects.get(i).getProjectID()%> -->
            <tr>
                <td><input type="checkbox" name="projectToUpdate" value="<%= projects.get(i).getProjectID()%>"></td>
            <inptu type="submit">
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
        
                    <button type="submit" name="command" value="viewComments">View Comments</button><br><br>

       
        <select name="approval">
  <option  value="approved">Approved</option>
  <option value="unapproved">UnApproved</option>
  <option value="review">Review</option>
  
        </select><br><br>
                    <input type="hidden" name="command" value="upDateApprove">

            <button name="ChangeApprovalStatus" value="">Update Approval Status</button>
        </form><br><br>
            <br><br>
        <form action="ShowAllProjectsServlet" method="post">
            <input type="hidden" name="command" value="viewAllProjects">

            <button name="viewAllProjects" value="">View All Projects</button>
        </form><br><br>

    </body>
</html>
