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
    </head>
    <body>
        <h1>Request Project</h1>
        <form action="RequestProjectServlet" method="post">
            
            <!--<input type="hidden" name="ProjectID" value="ProjectID">-->
            Activity Description:<br><input type="text" name="ActivityDescription"><br>
            Comments:<br><input type="text" name="Comments"><br>
            Cost:<br><input type="text" name="Cost"><br>
            MDF Budget:<br><input type="text" name="MDFBudget"><br>
            Execution Quarter:<br><input type="text" name="ExecutionQuarter"><br>
            Start Date:<br><input type="text" name="StartDate"><br>
            End Date:<br><input type="text" name="EndDate"><br>
            Objective & Result:<br><input type="text" name="ObjAndResult"><br>
            Required POE:<br><input type="text" name="RequiredPOE"><br>
            POE:<br><input type="text" name="POE"><br>
            <input type="hidden" name="command" value="RequestProject">
            
            <br><button name="RequestProjectButton" value="" >Request Project</Button>
            </form>
    </body>
</html>
