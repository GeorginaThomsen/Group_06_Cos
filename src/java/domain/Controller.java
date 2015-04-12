/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import datasource.*;
import java.sql.SQLException;

/**
 *
 * @author yagizaydinaksar
 */
public class Controller {
    
    private Project currentProject; 
    private DBFacade dbf;
    
    //== Singleton
    private static Controller instance;

    private Controller()
    {
        currentProject = null;
        dbf = DBFacade.getInstance();
    }

    public static Controller getInstance()
    {
        if (instance == null)
        {
            instance = new Controller();
        }
        return instance;
    }
    //Singleton over
    //== Getting project
    public Project getProject(int pno) 
    {
        currentProject = dbf.getProject(pno);
        return currentProject;
    }
    //Getting project over
}
