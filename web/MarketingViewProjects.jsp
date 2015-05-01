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
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Marketing View Projects | Dell MDF Tool</title>
    </head>
    <body>
         <div class="container">
         <div class="menuwrap">
                <nav>
                    <ul>
                        <li> <img src="images/logo2.png"> </li>
                        
                        <li>  <form action="ShowAllProjectsServlet" method="post">                      
                              <button name="DellLogInButton" value="">All Projects</button>
                              </form>
                        </li>
                        <li> <form action="MarketingServlet" method="post"> 
                                <input type="hidden" name="command" value="getPendingProjects">

            <button name="DellLogInButton" value="">Marketing Pending Projects</button>
        </form>
                        </li>
                        <li> <form action="FinanceInputServlet" method="get">
             <button name="DellLogInButton" value="">Finance Pending Projects</button>
              <input type="hidden" name="command" value="getPendingProjects">
         </form> </li>
                     </ul>
                </nav>           
            </div>
             <div class="contentwrap">
             <header><h1>Marketing View Projects</h1></header>
        
        
        
        
         
        <form action="MarketingServlet" method="post">
            
        <%
        ArrayList<Project> projects = (ArrayList<Project>)request.getAttribute("projects");
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
                 <td><input type="checkbox" name="projectToUpdate" value="<%= projects.get(i).getProjectID()%>"></td> 
            </tr>
            
             
        <%}%>
        </table>
        
                    

       
        <select name="approval">
  <option value="approved">Approved</option>
  <option value="unapproved">Unapproved</option>
  <option value="review">Review</option>
         </select>
                    <input type="hidden" name="command" value="upDateApprove">

            <button name="ChangeApprovalStatus" value="">Update Approval Status</button>
            <button type="submit" name="command" value="viewComments">View Comments</button>
        </form>
        
    
                 
             </div>
         </div>
        
    </body>
</html>
