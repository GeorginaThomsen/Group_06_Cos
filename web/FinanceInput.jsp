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
        <title>Finance</title>
    </head>
    <body style="text-align:center">
        <h1>Finance</h1>
        <form action="FinanceInputServlet" method="get">
            Project id:  <br><input type="text" name="ProjectId"><br>
            <input type="submit" value="Search project"><br><br><br>
            Fund allocation:   <br>
            <input type="text" name="FundAllocation">€<!--Current balance - difference. Needs to be thought out--><br>
            <input type="submit" value="Edit">     
            <input type="submit" value="Delete"><br><br>
            <h4>Claim: </h4><br>
            <input type="radio" name="status" value="approved">Approved<br>
            <input type="radio" name="status" value="not approved">Not approved<br>
            <input type="radio" name="status" value="waiting approval" checked>Waiting approval<br><br>
            Current status: <br>
            <input type="submit" value="Reimburse">
        </form>
    </body>
</html>
