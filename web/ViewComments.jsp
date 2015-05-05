<%-- 
    Document   : AddComments
    Created on : Apr 24, 2015, 11:49:13 AM
    Author     : Ben
--%>

<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Comments | Dell MDF Tool</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
          <header>
            <div class="bottomcontainer">
            <div class="logowrap"><img src="images/logo2.png"></div>    
            <nav>
                <ul>
                   <li><form action="ShowAllProjectsServlet" method="post">   
                                       <input type="hidden" name="command" value="viewAllProjects">

                       <button name="viewAllProjects" value="">View All Projects</button>
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
                <h1> View Comments </h1>
        <form action="AddCommentsServlet" method="post">
            
        
        <%
                Project project = (Project) request.getAttribute("project");
            %>
    
    
            <table border="1" style="width:100%">
                <tr>
                    
                    <th> Activity Description  </th>     
                    <th> Comments  </th> 
                    <th> Cost  </th> 
                    <th> MDF Budget  </th> 
                    <th> Execution Quarter  </th> 
                    <th> Start Date  </th> 
                    <th> End Date  </th> 
                    <th> Objective & Result  </th> 
                    <th> Required POE  </th> 
                    <th> Status </th> 
                    <th> PartnerID  </th> 

                </tr>
                       
                <tr>

                    <td><%= project.getActivityDescription()%></td>
                    <td><%= project.getComments()%></td>
                    <td><%= project.getCost()%></td>
                    <td><%= project.getMDFBudget()%></td>
                    <td><%= project.getExecutionQuarter()%></td>
                    <td><%= project.getStartDate()%></td>
                    <td><%= project.getEndDate()%></td>
                    <td><%= project.getObjAndResult()%></td>
                    <td><%= project.getRequiredPOE()%></td>
                    <td><%= project.getStatus()%></td>
                    <td><%= project.getPaID()%></td>

                    </tr>


                    
            </table>
                    <div class="comments">
                    <input type="hidden" name="projectID"  value="<%= project.getProjectID()%>">
                    <h2>Previous Comment</h2> <input type="text" name="comments" id="comments" value="<%= request.getAttribute("comments")%>" readonly><br><br>
                    <h2>Add New Comment</h2> <input type="text" name="newComments" id="newcomments" value="">
                    <button name="command" value="addComments">Comment</button>
        </form></div><br><br>
       
            
        </form>
         </div>
    </body>
</html>
