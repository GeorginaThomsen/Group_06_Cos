/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import domain.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yagizaydinaksar
 */
public class DBFacade {
    
          private ProjectMapper pm; 
	  private Connection con;
          
          //Singleton
          private static DBFacade instance;
          private DBFacade() {
		  pm 	= new ProjectMapper();
		  con 	= DBCommunication.getInstance().getConnection();  		  
	  }
	  public static DBFacade getInstance()
	  {
		  if(instance == null)
			  instance = new DBFacade();
		  return instance;
	  }
          //== Singleton over
          
          //Getting Project
            public Project getProject(int pno) throws SQLException  //=PROBLEM
	  {
		  return pm.getProject(pno, con);	      
	  }
         //== Getting project over
            public boolean insertProject(Project p)throws SQLException{
                return pm.insertProjects(p, con);
            }
            //added by ben
            public ArrayList<Project> getAllPartnerProjects(int paID) throws SQLException
            {
                return pm.getAllPartnerProjects(paID, con);
            }
            public ArrayList<Project> readAllProjects()throws SQLException
            {
                return pm.readAllProjects(con);
            }
            public ArrayList<Project> getPendingProjects() throws SQLException {
                return pm.getPendingProjects(con);
            }
            //added by Ben
             public boolean updateApproveProject(int pno, String approve) throws SQLException{
                 return pm.updateApproveProject(pno, approve, con);
             }
}
