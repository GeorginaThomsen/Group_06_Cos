<%-- 
    Document   : RequestProjectView
    Created on : 09-04-2015, 11:10:27
    Author     : Georgina
--%>
<%-- BCE? Should jsp go through the controller or is that just normal java classes?--%>
<%@page import="domain.Project" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partner MDF Tool</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
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
                
        <form action="DashboardServlet" method="post">
               <input type="hidden" name="username" value="<%= request.getAttribute("username")%>"><br>
            <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>"><br>
        <h1>New Project Created By: <%= request.getAttribute("username")%></h1>
        <br>
        <% Project newproject = (Project) request.getAttribute("RPV");%>
        <% if (newproject != null) {%>

        <%--Project id:               <%= newproject.getProjectID() %><br>--%>
        Activity Description:     <%= newproject.getActivityDescription()%><br/><br/>
        Comments: <%= newproject.getComments()%><br><br/>
        Cost: <%= newproject.getCost()%><br><br/>
        MDF Budget: <%= newproject.getMDFBudget()%><br><br/>
        Execution Quarter: <%= newproject.getExecutionQuarter()%><br><br/>
        Start Date: <%= newproject.getStartDate()%><br><br/>
        End Date: <%= newproject.getEndDate()%><br><br/>
        Objective & Result: <%= newproject.getObjAndResult()%><br><br/>
        Required POE: <%= newproject.getRequiredPOE()%><br><br/>
        <%--Status: <%= newproject.getStatus() %>--%>


        <% }%>
        <br><br/>
        <%--
        Have to display the info from RequestProject
        --%>
                               </form>
            </div>
    </body>
</html>
