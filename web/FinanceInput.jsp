<%-- 
    Document   : FinanceInput
    Created on : 09-04-2015, 08:50:33
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Finance</h1>
        <form>
            Project id:  <input type="text" name="ProjectId"><br>
            <input type="submit" value="Search project"><br>
            Fund allocation:   <input type="text" name="FundAllocation">€<br><!--Current balance - difference. Needs to be thought out--><br><br>
            <input type="submit" value="Edit">     
            <input type="submit" value="Delete"><br><br>
            Claim: <br>
            <input type="radio" name="status" value="approved"<br>
            <input type="radio" name="status" value="not approved"<br>
            <input type="radio" name="status" value="waiting approval" checked<br><br>
            Current status: <br>
            <input type="submit" value="Reimburse"></button>
        </form>
    </body>
</html>
