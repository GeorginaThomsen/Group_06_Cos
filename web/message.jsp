<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html 
    <html>
<%--Georgina: --%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload Result | Partner MDF Tool</title>
    <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <header>
        <div class="bottomcontainer">
            <div class="logowrap"><img src="images/logo2.png"></div>    
            <nav>
                <ul>
                    <li><form action="DashboardServlet" method="post">  
                            <input type="hidden" name="username" value="<%= request.getAttribute("username")%>" readonly>
                            <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>">
                            <button type="submit" name="command" value="readAllPartnerProjects">My Projects</button>

                    </li> 
                    <li>
                        <input type="hidden" name="partner" value="<%= request.getAttribute("partner")%>">
                        <button type="submit" name="command" value="requestProject">Request New Project</button>
                        </form> 
                    </li>

                </ul> 
            </nav>
        </div>
    </header>

    <div class="container"><center>
            <form action="DashboardServlet" method="post">

                <h1>Result</h1>
                <%= request.getAttribute("message")%><br>
                <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>"><br/><br/>











            </form>
        </center>
    </div>
</body>
</html>