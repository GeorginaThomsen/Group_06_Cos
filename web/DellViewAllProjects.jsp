<%-- 
    Document   : DellViewAllProjects
    Created on : Apr 20, 2015, 11:19:16 AM
    Author     : Ben
--%>

<%@page import="domain.POE"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>View all projects | Dell MDF Tool</title>
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
                <h1> View All Projects </h1>
            
                <form action="ViewPOE.jsp">

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
                    <td><input type="radio" name="project" value="<%= projects.get(i).getProjectID()%>"></td>

                </tr>


                <%}%>
            </table>
         
            <button type="submit" name="viewPOE" value=""> View POE </button>
         
            
       


        </form>
           
            </div>
        
    </body>
</html>
