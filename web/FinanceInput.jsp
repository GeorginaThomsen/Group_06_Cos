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
            Project id:  <br>"ProjectId"<br><br>
            Fund allocation:   <br>
            <input type="text" name="FundAllocation">€<br>
            <input type="submit" value="Edit"><br><br>
            <input type="submit" value="Reimburse">
        </form>
    </body>
</html>
