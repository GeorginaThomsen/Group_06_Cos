<%-- 
    Document   : ClaimSubmit
    Created on : Apr 9, 2015, 9:15:54 AM
    Author     : Peter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partner MDF Tool</title>
    </head>
    <body>
        <h1>Claim submit</h1>
        
        
        <form action="">
            Project ID:<br><input type="int" name="ProjectID"><br><br>
            <input type="hidden" name="command" value="ProjectID">
            <input type="submit" value="Claim submit"> 
        </form>
        
        <h2>What to submit</h2>
       <%--  
        PartnerName<br>
        Country<br>
        MDFBudget<br>
        Cost<br>
        --%>
        
    </body>
</html>
