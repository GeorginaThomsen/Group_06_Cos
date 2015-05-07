/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import datasource.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yagizaydinaksar
 */
public class Controller {

    private Project currentProject;
    private DBFacade dbf;
    private User currentLogin;

    public Controller() {
        currentProject = null;
        dbf = DBFacade.getInstance();
        currentLogin = null;
    }

    //Singleton over
    //== Getting project
    public Project getProject(int pno) {
        try {
            currentProject = dbf.getProject(pno);
        } catch (SQLException e) {
            e.getMessage();
        }
        return currentProject;

    }
    //Getting project over

    //Georgina:
    public Project insertProject(String act, String com, float cost, String mdf, String eQ, String end, String start, String obj, String pOE, String stat, int paid) throws SQLException {
        currentProject = new Project(act, com, cost, mdf, eQ, end, start, obj, pOE, stat, paid);

        boolean status = dbf.insertProject(currentProject);
        if (!status) {//If dbf.insterProject does not return an insterted project
            currentProject = null;
        }

        return currentProject;//This return is wrong I think
    }

    //added by Ben:
    public ArrayList<Project> getAllPartnerProjects(int paID) throws SQLException {

        return dbf.getAllPartnerProjects(paID);
    }

    public ArrayList<Project> readAllProjects() throws SQLException {
        return dbf.readAllProjects();
    }

    public ArrayList<Project> getPendingProjects() throws SQLException {
        return dbf.getPendingProjects();
    }

    //added by Ben:
    public boolean updateApproveProject(int pno, String approve) throws SQLException {
        return dbf.updateApproveProject(pno, approve);
    }
    
    public boolean updateCostProject(int pno, float cost) throws SQLException{
        return dbf.updateCostProject(pno, cost);
    }

     //Georgina:
    public User login(String username, String password, String userType/*, String userType*/) throws SQLException {
        return currentLogin = dbf.login(username, password, userType);
    }
     //Ben:
    public boolean insertComments(int projectID, String comments) throws SQLException{
        return dbf.insertComments(projectID, comments);
    }
    //Ben:
    public boolean checkForComments(int projectID) throws SQLException{
        return dbf.checkForComments(projectID);
    }
    //Ben:
    public String getComments(int projectID) throws SQLException{
        return dbf.getComments(projectID);
    }
    //Ben:
     public boolean upDateComments(int projectID, String comments) throws SQLException{
         return dbf.upDateComments(projectID, comments);
     }
      //Getting project over
     public Project getCompleteProject(int pno) throws SQLException{
         return dbf.getCompleteProject(pno);
     }
     public boolean editProject(int pno,  String column, String edit) throws SQLException{
         return dbf.editProject(pno, column, edit);
     }
     public boolean editCost(int pno,  String column, float edit) throws SQLException{
         return dbf.editCost(pno, column, edit);
     }
     //Ben:
     public int getPartnerID(String partnerName) throws SQLException{
         return dbf.getPartnerID(partnerName);
     }
    //Georgina:
     public void savePOE(POE poe) throws SQLException{
        dbf.savePOE(poe);
    }
     //Georgina:
    public void getPOE(int projectID, HttpServletResponse response) throws SQLException, IOException{
        dbf.getPOE(projectID, response);
    }
}
