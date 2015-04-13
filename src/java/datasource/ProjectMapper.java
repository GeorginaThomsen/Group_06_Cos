package datasource;

import domain.Project;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Georgina Thomsen
 */
public class ProjectMapper {

//    private static void insertProject()throws SQLException{
//        
//        Connection conn = null;
//        PreparedStatement preparedStatement = null;
//        String SQLProject = "insert into Project values(?,?,?,?,?,?,?,?,?)";
//        
//        preparedStatement = conn.prepareStatement(SQLProject);
//        Project p = 
//        preparedStatement.setInt(i, );
//    }
    public boolean insertProjects(ArrayList<Project> pr, Connection con) throws SQLException {
        int TuplesInserted = 0;

        String SQLProject = "insert into Project values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement preStatement = null;
        con.prepareStatement(SQLProject);
//        con.prepareStatement(SQLProject, preStatement.RETURN_GENERATED_KEYS);


        for (int i = 0; i < pr.size(); i++) {
            Project p = pr.get(i);
            //Remember project id!
            preStatement.setInt(1, p.getProjectID());
            preStatement.setString(2, p.getActivityDescription());
            preStatement.setString(3, p.getComments());
            preStatement.setFloat(4, p.getCost());
            preStatement.setString(5, p.getMDFBudget());
            preStatement.setString(6, p.getExecutionQuarter());
            preStatement.setString(7,  p.getStartDate());//Check with teacher if this is okey
            preStatement.setString(8, p.getEndDate());
            preStatement.setString(9, p.getObjAndResult());
            preStatement.setString(10, p.getRequiredPOE());

            TuplesInserted += preStatement.executeUpdate();
        }
        return TuplesInserted == pr.size();
    }
    
     public Project getProject(int pno, Connection con) throws SQLException 
    {
        Project p = null;
        
        String SQLProject =       //Getting project
          "select * " +
          "from project " +
          "where projectid = ?"; 
        PreparedStatement preStatement=null;      
        preStatement = con.prepareStatement(SQLProject);
         try{
         //=== Get project
          
          preStatement = con.prepareStatement(SQLProject);
          
          preStatement.setInt(1,pno);     // primary key value
          ResultSet rs  = preStatement.executeQuery();
          if (rs.next())
          {
            p = new Project(pno, 
                    rs.getString(2), 
                    rs.getString(3), 
                    rs.getFloat(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10));
          }         
         
         }
         catch (Exception e)
      {   
          System.out.println("Fail 1 in ProjectMapper - getProject");
          System.out.println(e.getMessage());
      }
        finally														// must close statement
      {
    	  try {
			preStatement.close();
		} catch (SQLException e) {
			System.out.println("Fail 2 in ProjectMapper - getProject");
			System.out.println(e.getMessage());
		}  
      }
        return p; 
    }
       
    
     
}
