<%-- 
    Document   : ViewPOE
    Created on : 04-05-2015, 09:50:49
    Author     : Georgina:
--%>

<%@page import="domain.POE"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MDF Tool</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body><header>
            <div class="bottomcontainer">
                <div class="logowrap"><img src="images/logo2.png"></div>    
                <nav>
                    <ul>
                        <li><form action="ShowAllProjectsServlet" method="post">                      
                                <button name="DellLogInButton" value="">All Projects</button>
                            </form>
                        </li> 
                        <li><form action="MarketingServlet" method="post"> 
                                <input type="hidden" name="command" value="getPendingProjects">
                                <button name="DellLogInButton" value="">Marketing Pending Projects</button>
                            </form>  
                        </li>
                        <li><form action="FinanceInputServlet" method="get">
                                <button name="DellLogInButton" value="">Finance Pending Projects</button>
                                <input type="hidden" name="command" value="getPendingProjects">
                            </form>
                        </li>
                    </ul> 
                </nav>
            </div>
        </header>

        <div class="container">
            <h1>POE</h1>
            <form action="GetPOEServlet" method="post">
                Project ID: <input type="text" name="projectID" value="<%= request.getParameter("project")%>"><br><br>

                <% POE newPOE = (POE) request.getAttribute("POE");%>
                <% if (newPOE != null) {%>
                POE:    <%=newPOE.getData()%><br>
                <% }%>
                <img src="POE" alt="image"></br></br>
                <button> View POE </button>
            </form><br><br>
        </div>
    </body>
</html>
