<%-- 
    Document   : FinanceInput
    Created on : 09-04-2015, 08:50:33
    Author     : Adam
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finance View Projects | Dell MDF Tool</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <header>
            <div class="bottomcontainer">
            <div class="logowrap"><img src="images/logo2.png"></div>    
            <nav>
                <ul>
                   <li><form action="ShowAllProjectsServlet" method="post">                      
                       <button name="DellLogInButton" value="">All Projects</button>
                        </form>
                   </li> 
                   <li><form action="MarketingServlet" method="post"> 
                       <input type="hidden" name="command" value="getPendingProjects">
                       <button name="DellLogInButton" value="">Marketing Pending Projects</button>
                       </form>  
                   </li>
                   <li><form action="FinanceInputServlet" method="get">
                       <button name="DellLogInButton" value="">Finance Pending Projects</button>
                       <input type="hidden" name="command" value="getPendingProjects">
                       </form>
                        </li>
                </ul> 
            </nav>
            </div>
        </header>
             <div class="container">
                 <h1>Finance View Projects</h1>

       
        <form action="FinanceInputServlet" method="post">

            <%
                ArrayList<Project> projects = (ArrayList<Project>) request.getAttribute("projects");
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
                    for (int i = 0; i < projects.size(); i++) {
                %>
                <!--       <%= projects.get(i).getProjectID()%> -->
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
                     <td><input type="radio" name="projectToEdit" value="<%= projects.get(i).getProjectID()%>" required></td>  
                    
                    
                    <input type="hidden" name="CostUpdate" value="<%= projects.get(i).getCost()%>"
                       <input type="hidden" name="StatusUpdate" value="<%= projects.get(i).getStatus()%>"
                       </tr>


                <%}%>
            </table>

                

            <!--   <form action="FinanceInputServlet" method="get" style="text-align: center"> -->
            <button name="command" value="upDateApprove">Reimburse</button>
            <input type="hidden" name="approval" value="Completed">
            <button type="submit" name="command" value="viewComments">View Comments</button>
            <input type="number" step="any" name="GetCost" placeholder="New Cost / €">
            <input type="submit" value="Change price">
            <input type="hidden" name="command" value="upDateCost">
             

           

            
        </form>
        
        <!-- <input type="submit" value="Reimburse"> -->
    </body>
</html>
