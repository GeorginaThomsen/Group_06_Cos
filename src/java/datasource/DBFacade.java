/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import domain.*;
import java.sql.SQLException;

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
}
