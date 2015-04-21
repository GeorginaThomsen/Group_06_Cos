/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import datasource.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yagizaydinaksar
 */
public class Controller {

    private Project currentProject;
    private DBFacade dbf;

    

    public Controller() {
        currentProject = null;
        dbf = DBFacade.getInstance();
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

    public Project insertProject(String act, String com, float cost, String mdf, String eQ, String end, String start, String obj, String pOE) throws SQLException {
        currentProject = new Project(act, com, cost, mdf, eQ, end, start, obj, pOE);
        
        boolean status = dbf.insertProject(currentProject);
        if(!status){//If dbf.insterProject does not return an insterted project
            currentProject = null;
        }
        
        return currentProject;//This return is wrong I think
    }
    //added by Ben
    public ArrayList<Project> getAllPartnerProjects(int paID) throws SQLException{
        
        return dbf.getAllPartnerProjects(paID);
    }
    public ArrayList<Project> readAllProjects()throws SQLException
    {
        return dbf.readAllProjects();
    }
    public ArrayList<Project> getPendingProjects() throws SQLException{
        return dbf.getPendingProjects();
    } 
}
