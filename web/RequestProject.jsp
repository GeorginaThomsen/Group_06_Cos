<%-- 
    Document   : RequestProject
    Created on : 08-04-2015, 14:23:33
    Author     : Georgina Thomsen
--%>

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
                   <li>
                       <form action="DashboardServlet" method="post">
                       <input type="hidden" name="partner" value="<%= request.getAttribute("partner")%>">
                       <button type="submit" name="command" value="requestProject">Request New Project</button>
                       </form> 
                   </li>
                   
                </ul> 
            </nav>
            </div>
        </header>
            
            <div class="container">
        <h1>Request Project</h1>
         <div class="requestwrap">
            <form action="RequestProjectServlet" method="post">
            <input type="hidden" name="username" value="<%= request.getAttribute("username")%>">
            <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>">

            <!--<input type="hidden" name="ProjectID" value="ProjectID">-->
            <input type="text" name="ActivityDescription" placeholder="Activity Description" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Activity Description'"><br>
            <input type="text" name="Comments" placeholder="Comments" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Comments'"><br>
            <input type="text" name="Cost" placeholder="Cost" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Cost'"><br>
            <input type="text" name="MDFBudget" placeholder="MDF Budget" onfocus="this.placeholder = ''" onblur="this.placeholder = 'MDF Budget'"><br>
            <input type="text" name="ExecutionQuarter" placeholder="Execution Quarter" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Execution Quarter'"><br>
            <input type="text" name="StartDate" placeholder="Start Date" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Start Date'"><br>
            <input type="text" name="EndDate" placeholder="End Date" onfocus="this.placeholder = ''" onblur="this.placeholder = 'End Date'"><br>
            <input type="text" name="ObjAndResult" placeholder="Objective & Result" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Objective & Result'"><br>
            <input type="text" name="RequiredPOE" placeholder="Required POE" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Required POE'"><br>
            
            <!--Status: <br><input type="text" name="Status"><br>-->
            <!--POE:<br><input type="text" name="POE"><br>    hidden, needs to be filled after the event has taken place  -->
            <input type="hidden" name="command" value="RequestProject">

            <br><br><br><button name="RequestProjectButton" value="" >Request Project</Button>
        </form>
</div>
        
            </div>
    </body>
</html>
