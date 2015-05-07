<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html 
    <html>
<%--Georgina: --%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload Result</title>
</head>
<body>
<center>
    <form action="DashboardServlet" method="post">
        
    <h2>Message</h2>
    Information: <input type="text" name="message" value="<%= request.getAttribute("message")%>"><br>
                <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>">

                <button type="submit" name="command" value="readAllPartnerProjects">View All Projects</button>

    
    
    





    </form>
</center>
</body>
</html>