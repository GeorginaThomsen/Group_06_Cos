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
    </head>
    <body>
        <h1>Edit Project</h1><br><br>
        <form action="DashboardServlet" method="post">
            
        Comments: <br><br>
        <textarea rows="10" cols="150">
            <%= request.getAttribute("comments")%>
        </textarea><br><br>
        <% Project p = (Project) request.getAttribute("project");%>
        <%  if (p != null) {%>
        <h2>Project</h2>
                    <input type="hidden" name="username" value="<%= request.getAttribute("username")%>" >

                        <input type="hidden" name="comments" value=" <%= request.getAttribute("comments")%>" >
                        <input type="hidden" name="projectID" value="<%= p.getProjectID()%>"  >
                        <input type="text" name="partnerID" value="<%= request.getAttribute("partnerID")%>"  >
        <table   border="1" style="width:100%">
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
                <td><input type="text" name="newAct" value="" size="100" ></td>
                <td><button type="submit" name="command" value="updateAct"> Edit Activity Description</button></td>

            </tr>
            <tr>

                <td> Comments</td>  
                <td><%= p.getComments()%></td>
            </tr>
            <tr>

                <td> Edit Comments</td> 
                <td><input type="text" name="newComments" value="" size="100"></td>
                <td><button type="submit" name="command" value="updateCom">Edit Comments</button></td>


            </tr>
            <tr>

                <td>Cost</td> 
                <td> <%= p.getCost()%></td>
            </tr>
            <tr>

                <td>Edit Cost</td>  
                <td><input type="number" step="any" name="newCost" value="" ></td>
                <td><button type="submit" name="command" value="updateCost">Edit Cost</button></td>

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
                <td><input type="text" name="newObj" value="" size="100" ></td>
                <td><button type="submit" name="command" value="updateObj">Edit Objective & Result</button></td>

            </tr>
            <tr>

                <td>Required POE </td> 
                <td><%= p.getRequiredPOE()%></td>
            </tr>
            <tr>

                <td> Edit Required POE </td> 
                <td><input type="text" name="newPOE" value="" size="100"></td>
                <td><button type="submit" name="command" value="updatePoe">Edit Required POE</button></td>

            </tr>
        </table><br><br>

        <% }%>
                    <button type="submit" name="command" value="readAllPartnerProjects">Back To Projects</button>

        </form>
    </body>
</html>
