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
    private ArrayList<Project> newProject;

    private static Controller instance;

    private Controller() {
        currentProject = null;
        dbf = DBFacade.getInstance();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
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
        Project p = new Project(act, com, cost, mdf, eQ, end, start, obj, pOE);
        
        dbf.insertProject(p);
        
        return currentProject;//This return is wrong I think
    }
}
