package datasource;

import domain.Project;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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

        for (int i = 0; i < pr.size(); i++) {
            Project p = pr.get(i);
            //Remember project id!
            preStatement.setString(1, p.getActivityDescription());
            preStatement.setString(2, p.getComments());
            preStatement.setFloat(3, p.getCost());
            preStatement.setString(4, p.getMDFBudget());
            preStatement.setString(5, p.getExecutionQuarter());
            preStatement.setDate(6, (Date) p.getStartDate());//Check with teacher if this is okey
            preStatement.setDate(7, (Date) p.getEndDate());
            preStatement.setString(8, p.getObjAndResult());
            preStatement.setString(9, p.getRequiredPOE());

            TuplesInserted += preStatement.executeUpdate();
        }
        return TuplesInserted == pr.size();
    }
}
