<%-- 
    Document   : PartnerEditProject
    Created on : Apr 30, 2015, 8:58:37 AM
    Author     : Ben
--%>

<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partner Edit Project</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>  <header>
            <div class="bottomcontainer">
                <div class="logowrap"><img src="images/logo2.png"></div>    
                <nav>
                    <ul>
                        <li><form action="DashboardServlet" method="post">  
                                <input type="hidden" name="username" value="<%= request.getAttribute("username")%>" >
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

        <div class="container">
            <h1>Edit Project</h1></br>
            <form action="DashboardServlet" method="post">

                <% Project p = (Project) request.getAttribute("project");%>
                <%  if (p != null) {%>
                <input type="hidden" name="username" value="<%= request.getAttribute("username")%>" >

                <input type="hidden" name="comments" value=" <%= request.getAttribute("comments")%>" >
                <input type="hidden" name="projectID" value="<%= p.getProjectID()%>"  >
                <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>"  >

                <div class="edit"><table   border="1" style="width:100%">
                        <tr>

                            <td>  Project ID   </td>  
                            <td> <%= p.getProjectID()%></td>
                        </tr>
                        <tr>

                            <td> Activity Description </td>    
                            <td> <%= p.getActivityDescription()%></td>
                        </tr>
                        <tr>

                            <td>  Edit Activity Description </td> 
                            <td><input type="text" name="newAct" value=""><button type="submit" name="command" value="updateAct"> Edit Activity Description</button></td>


                        </tr>
                        <tr>

                            <td> Comments</td>  
                            <td><%= p.getComments()%></td>
                        </tr>
                        <tr>

                            <td> Edit Comments</td> 
                            <td><input type="text" name="newComments" value="" ><button type="submit" name="command" value="updateCom">Edit Comments</button></td>



                        </tr>
                        <tr>

                            <td>Cost</td> 
                            <td> <%= p.getCost()%></td>
                        </tr>
                        <tr>

                            <td>Edit Cost</td>  
                            <td><input type="number" step="any" name="newCost" value="" ><button type="submit" name="command" value="updateCost">Edit Cost</button></td>

                        </tr>
                        <tr>

                            <td>MDF Budget </td> 
                            <td><%= p.getMDFBudget()%></td>
                        </tr>
                        <tr>

                            <td>Execution Quarter</td>  
                            <td><%= p.getExecutionQuarter()%></td>
                        </tr>
                        <tr>

                            <td>Start Date </td> 
                            <td><%= p.getStartDate()%></td>
                        </tr>
                        <tr>

                            <td>End Date</td>  
                            <td><%= p.getEndDate()%></td>
                        </tr>
                        <tr>

                            <td>Objective & Result </td>
                            <td><%= p.getObjAndResult()%></td>
                        </tr>
                        <tr>

                            <td>Edit Objective & Result </td> 
                            <td><input type="text" name="newObj" value=""  ><button type="submit" name="command" value="updateObj">Edit Objective & Result</button></td>

                        </tr>
                        <tr>

                            <td>Required POE </td> 
                            <td><%= p.getRequiredPOE()%></td>
                        </tr>
                        <tr>

                            <td> Edit Required POE </td> 
                            <td><input type="text" name="newPOE" value="" ><button type="submit" name="command" value="updatePoe">Edit Required POE</button></td>


                        </tr>
                    </table><br><br>

                    <% }%></div>


            </form></div>
    </body>
</html>
