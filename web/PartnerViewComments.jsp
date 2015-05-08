<%-- 
    Document   : PartnerViewComments
    Created on : Apr 29, 2015, 10:56:04 AM
    Author     : Ben
--%>

<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>View Comments | Partner MDF Tool</title>
    </head>
    <body>
        <header>
            <div class="bottomcontainer">
            <div class="logowrap"><img src="images/logo2.png"></div>    
            <nav>
                <ul>
                   <li><form action="DashboardServlet" method="post">  
                       <input type="hidden" name="username" value="<%= request.getAttribute("username")%>" >
                       <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>">
                       <button type="submit" name="command" value="readAllPartnerProjects">My Projects</button>
                       </form>
                   </li> 
                   <li><form action="DashboardServlet" method="post">
                       <input type="hidden" name="username" value="<%= request.getAttribute("username")%>" >
                       <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>">
                       <input type="hidden" name="partner" value="<%= request.getAttribute("partner")%>">
                       <button type="submit" name="command" value="requestProject">Request New Project</button>
                       </form>
                   </li>
                   
                </ul> 
            </nav>
            </div>
        </header>
            
            <div class="container">
        <h1>Partner View Comments</h1>
        <form action="DashboardServlet" method="post">


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



            </table><br><br><div class="comments">
                        <input type="hidden" name="username" value="<%= request.getAttribute("username")%>" >

            <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>">

            <input type="hidden" name="projectID"  value="<%= project.getProjectID()%>">
            <input type="hidden" name="comments"  value="<%= request.getAttribute("comments")%>">
            Comments: <br><br>
            
                <%= request.getAttribute("comments")%>
            </div><br><br>


            <button type="submit" name="command" value="editProject">Edit Project</button><br><br>
         




        </form><br><br>


            </div>
    </body>
</html>
